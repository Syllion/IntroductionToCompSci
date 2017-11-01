/**
 * Coin game
 * Players choose the left-most or right-most coin from a row of coins until no coins are left
 * Games tallies totals and displays them
 *
 * @author alchambers
 * @author Nalin Richardson
 */

import java.util.Scanner;
import java.util.Random;

public class CoinGame{
    private final int UPPERBOUND = 25; // the maximum coin value
    private final int NUM_COINS = 10;  // the number of coins 

    private Coin[] board;

    private Scanner scan;
    private Random rand;

    private boolean persOnesTurn;
    int persOneTot;
    int persTwoTot;


    public CoinGame(){
        scan = new Scanner(System.in);
        rand = new Random();
        board = new Coin[NUM_COINS];
        persOnesTurn = true;
        persOneTot = 0;
        persTwoTot = 0;
    }
    
    /**
     * Runs one game 
     */
    public void play(){
        // Each iteration of the while loop should implement one 
        // turn of the game
        
        int numTurns = 0;
        int leftSpot = 0;
        int rightSpot = NUM_COINS-1;
        
        printWelcomeMessage();
        makeBoard();

        while(numTurns < NUM_COINS-1){
            numTurns++;

            whosTurn(persOnesTurn);
            toString();

            if(getUsersTurn().equals("left")){
                oneround(leftSpot, persOnesTurn);
                leftSpot++;

            }
            else{
                oneround(rightSpot, persOnesTurn);
                rightSpot--;
            }

            changeTurn(persOnesTurn);

        }

        persTwoTot += board[rightSpot].getDenomination();
        
        System.out.println("\nThe game is over! Here are the results: ");
        System.out.println("Player 1 got "+persOneTot+" points");
        System.out.println("Player 2 got "+persTwoTot+" points");
  
    }

    public String toString(){
        String str = "[";
        for(int i = 0; i<NUM_COINS; i++){
            if(board[i].isTaken()){
                str += "--,";
            }
            else{
                str += "" + board[i].getDenomination() +",";
            }
        }
        return str += "]";
    }

    
    /**
     * Prints a welcoming message to the screen when the game
     * begins.
     */
    private void printWelcomeMessage(){
        System.out.println("===== Welcome to the coin game! =====");
    }
    
    
    /**
     * Prompts the user to choose either the left or right coin and
     * returns the user's choice as a String
     * @return A String containing the user's choice
     */
    private String getUsersTurn(){
        System.out.println("Gameboard: ");
        System.out.println(toString());
        
        // This while loop continues until the user types a valid choice
        String choice = "";        
        while(!validChoice(choice)){
            System.out.print("Type \"left\" or \"right\": ");
            choice = scan.nextLine(); 
        }        
        return choice;
    }
    
    /**
     * Returns whether the String is a valid choice
     * @return Returns true if the input is "left" or "right" and false otherwise
     */
    private boolean validChoice(String input){
        return input.equals("left") || input.equals("right");
    }

    /**
     * Makes a new random board
     */
    private void makeBoard(){
        int[] denominations = new int[] {1,5,10,25};
        for(int i = 0; i < NUM_COINS; i++){
            int randNum = rand.nextInt(4);
            Coin newCoin = new Coin(denominations[randNum]);
            board[i] = newCoin;
        }
    }

    /**
     * Runs one round of the coin game
     * @parem spot The spot of the next number chosen
     * @parem turn A boolean that represents who's turn your on
     */
    private void oneround(int spot,boolean turn){
        int num = board[spot].getDenomination();
        if(turn){
            persOneTot += num;
        }
        else{
            persTwoTot += num;
        }
        board[spot].setTaken();
    }


    /**
     * Prints message stating who's turn it is
     * @param turn Boolean stating if its player one's turn
     */
    private void whosTurn(boolean turn){
        if(turn){
            System.out.println("\nPlayer 1's turn...\n");
        }
        else{
            System.out.println("\nPlayer 2's turn...\n");
        }
    } 

    /**
     * Changes who's turn it is
     * @param turn Boolean stating if its player one's turn
     */
    private void changeTurn(boolean turn){
        if(turn){
            persOnesTurn = false;
        }
        else{
            persOnesTurn = true;
        }
    }


}

    