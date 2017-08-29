/**
 * Created by hadoop-user on 8/29/17.
 */

import org.junit.Assert;
import org.junit.Test;


    public class TestBoard {



        @Test
        public void Test1() {

            Board b = new Board();

            b.addShip(true,2, 1 ,0,1);
            b.addShip(true,4,5,0,2);
            b.addShip(false,3,5,6,3);
            b.addShip(false,3,1,4,4);



            b.display();


        }
    }
























