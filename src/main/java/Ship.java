/**
 * Created by hadoop-user on 8/28/17.
 */
public class Ship {
    private int length;
    private int hits;
    private boolean sunk = false;

    public Ship(int initLength)
    // Instantiates a new ship.


    {
        length = initLength;
        hits = 0;
    }

    public void hits()
    // Adds one hit to the ship.

    {
        hits++;
    }

    public boolean isSunk()
    //@return sunk Returns true if the ship has been sunk.

    {
        if(hits == length)
        {
            sunk = true;
        }

        return sunk;
    }


}