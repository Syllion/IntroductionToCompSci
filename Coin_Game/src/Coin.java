/**
 * This class represents a coin
 * @author alchambers
 */

public class Coin{
    private boolean taken;
    private int denomination;

    /**
     * Constructs a new coin with the specified denomination
     * @param denomination The denomination (i.e. value) of the coin
     */
    public Coin(int denomination){
        taken = false;
        this.denomination = denomination;
    }
    
    /**
     * Returns the denomination of the coin
     * @return The coin's denomination
     */
    public int getDenomination(){
        return denomination;        
    }
     
    /**
     * Marks the coin as having been taken by a player
     */
    public void setTaken(){
        taken = true;
    }
    
    /**
     * Returns whether the coin has been taken or not
     * @return true if the coin has been taken, false otherwise
     */
    public boolean isTaken(){
        return taken;
    }    
}
