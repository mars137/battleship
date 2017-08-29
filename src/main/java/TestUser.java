/**
 * Created by hadoop-user on 8/29/17.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class TestUser {
    private Board board;
    public boolean loss;
    private ShipList fleet;
    private AttackRecord record;


    public void placeShip(int m, int n)
    /**
     * @param m ship length
     * @param n ship type: 1- aircraft carrier; 2- battleship;
     * 3- destroyer; 4- submarine; 5- patrol boat
     */
    {
        int x = 0;
        int y = 0;
        boolean valid = false;
        boolean alignment = false;
        while(valid == false)
        {


            String ship = "";
            if(n==1)
            {
                ship = "aircraft carrier";
            }
            if(n==2)
            {
                ship = "battleship";
            }
            if(n==3)
            {
                ship = "destroyer";
            }
            if(n==4)
            {
                ship = "submarine";
            }
            if(n==5)
            {
                ship = "patrolboat";
            }
            try
            {
                System.out.println("Please place your " + ship + ". This gamepiece is " + m + " squares long.");
                System.out.println("Should the orientation be: 1 - horizontal, or 2 - vertical?");
                Scanner orientation = new Scanner(System.in);
                int a = orientation.nextInt();
                if(a != 1 && a != 2)
                {
                    InputMismatchException e = new InputMismatchException();
                    throw e;
                }
                else if(a == 1)
                {
                    alignment = true;
                }
                else if(a == 2)
                {
                    alignment = false;
                }
                System.out.println("Please name a starting point on the vertical axis.");
                Scanner vertical = new Scanner(System.in);
                x = vertical.nextInt();
                System.out.println("Please name a starting point on the horizontal axis.");
                Scanner horizontal = new Scanner(System.in);
                y = horizontal.nextInt();
                board.checkAvailibility(alignment, m, x, y);
                if (valid == false)
                {
                    System.out.println("There's no place on the board for this ship. Please put it somewhere else.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("The information you have input is not valid. Please try again.");
                valid = false;
            }



        }
        board.addShip(alignment, m, x, y, n);
    }


    public Coordinates attack()
    /**
     * Generates coordinates for an attack.
     * that contains coordinates for an attack.
     */
    {
        System.out.println("It is time to attack.");
        int x = 0;
        int y = 0;
        boolean redundant = true;



        while(redundant)
        {
            try
            {
                System.out.println("Please select a coordinate on the vertical axis to target.");
                Scanner targetx = new Scanner(System.in);
                x = targetx.nextInt();
                if (x < 0 || x > 9)
                {
                    InputMismatchException f = new InputMismatchException();
                    throw f;
                }
                System.out.println("Please select a coordinate on the horizontal axis to target.");
                Scanner targety = new Scanner(System.in);
                y = targety.nextInt();
                if (y < 0 || y > 9)
                {
                    InputMismatchException f = new InputMismatchException();
                    throw f;
                }
                if(record.isRedundant(x, y))
                {
                    System.out.println("You've already hit there. Please select different coordinates.");
                }
                else
                {
                    redundant = false;
                }
            }
            catch (InputMismatchException f)
            {
                System.out.println("This is not a valid coordinate. Coordinates must be integers between 0 and 9.");
                redundant = true;
            }
        }


        Coordinates attackCoordinates = new Coordinates(x, y);
        record.addAttack(attackCoordinates);
        return attackCoordinates;
    }


}