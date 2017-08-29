/**
 * Created by hadoop-user on 8/28/17.
 */
import java.lang.ArrayIndexOutOfBoundsException;

public class Board {
    private int[][] board;

    public Board()
    {
        /**
         * instantiates a new 10x10 board.
         */
        board = new int[10][10];
    }

    public void display()
    {
        /**
         * Displays the board to the player.
         * O denotes where ships have not been hit
         * $ denotes where ships have been hit.
         */
        System.out.println();
        System.out.println("This is your board. O: your ships / $: where ships are hit / X: enemy misses");
        System.out.println("  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("--+---+---+---+---+---+---+---+---+---+---|");
        for(int x=0; x<board.length; x++)
        {
            System.out.print(x + " |");

            for(int y = 0; y<board.length; y++)
            {
                System.out.print(" ");

                if(board[x][y] == 1 || board[x][y] == 2 || board[x][y] == 3 || board[x][y] == 4 | board[x][y] == 5)
                {
                    System.out.print("O");
                }

                if(board[x][y] == 6)
                {
                    System.out.print("$");
                }

                if(board[x][y] == 0)
                {
                    System.out.print(" ");
                }

                System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
            System.out.println("--+---+---+---+---+---+---+---+---+---+---|");
        }
    }

      public boolean checkAvailibility(boolean horizontal, int length, int startx, int starty)

     //Returns true when the ship can be placed, given these specifications.

    {
        boolean valid = false;
        try
        {
            if (horizontal == true)
            {
                for (int n=0; n<length; n++)
                {
                    if (board[startx][starty+n] == 0)
                    {
                        valid = true;
                    }
                    else
                    {
                        valid = false;
                        break;
                    }
                }
            }
            if (horizontal == false)
            {
                for (int n=0; n<length; n++)
                {
                    if (board[startx+n][starty] == 0)
                    {
                        valid = true;
                    }
                    else
                    {
                        valid = false;
                        break;
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            valid = false;
        }

        return valid;
    }

    public void addShip(boolean horizontal, int length, int startx, int starty, int type)

    // Adds a ship to the grid at a specified location.


    {
        if (horizontal == true)
        {
            for(int n = 0; n<length; n++)
            {
                board[startx][starty+n] = type;
            }
        }
        if (horizontal == false)
            for(int n = 0; n<length; n++)
            {
                board[startx+n][starty] = type;
            }
    }

    public int checkHit(Coordinates c)
    /**
     * Checks whether there is a ship at given coordinates.
     ** @return int 0 - miss, 1-5 - hit ship
     */
    {
        int x = c.getX();
        int y = c.getY();
        int status = 0;

        if (board[x][y] == 0)
        {
            board[x][y] = 7;
            status = 0;
        }

        if (board[x][y] > 0 && board[x][y] < 6)
        {
            status = board[x][y];
        }

        return status;
    }

    public void receiveHit(Coordinates c)
    /**
     * Deals with when the player's ship has been hit.
     */
    {
        board[c.getX()][c.getY()] = 6;
    }

    public void receiveMiss(Coordinates c)
    /**
     * Deals with when the player's board has been hit, but the
     * attack has missed a ship.
     */
    {
        board[c.getX()][c.getY()] = 11;
    }
}
