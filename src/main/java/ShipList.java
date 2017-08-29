/**
 * Created by hadoop-user on 8/28/17.
 */

public class ShipList {
    private Ship aircraft_carrier;
    private Ship battleship;
    private Ship destroyer;
    private Ship submarine;
    private Ship patrol_boat;
    private boolean lost = false;

    public ShipList()
    //Instantiates a new ShipList.

    {
        aircraft_carrier = new Ship(5);
        battleship = new Ship(4);
        destroyer = new Ship(3);
        submarine = new Ship(3);
        patrol_boat = new Ship(2);
    }

    public void shipHit(int a)
    //Adds one hit to a designated ship.

    {
        if (a == 1)
        {
            aircraft_carrier.hits();
        }
        if (a == 2)
        {
            battleship.hits();
        }
        if (a == 3)
        {
            destroyer.hits();
        }
        if (a == 4)
        {
            submarine.hits();
        }
        if (a == 5)
        {
            patrol_boat.hits();
        }
    }

    public boolean isLost()
    /**
     Detects when the player has lost all ships, and therefore
     when the player has lost the game.
    */
    {
        if (aircraft_carrier.isSunk() && battleship.isSunk() && destroyer.isSunk() && submarine.isSunk() && patrol_boat.isSunk())
        {
            lost = true;
        }
        return lost;
    }

}