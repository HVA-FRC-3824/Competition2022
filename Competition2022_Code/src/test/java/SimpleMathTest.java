import static org.junit.Assert.assertEquals;

import frc.robot.SimpleMath;
import org.junit.*;

public class SimpleMathTest {
    
    SimpleMath simpleMath; // Create a SimpleMath object for us to test

    @Before // This method will run before each test
    public void setup() {
        simpleMath = new SimpleMath();
    }

    @After // This method will run after each test
    public void shutdown() throws Exception {
        // SimpleMath does not keep any state, so there is nothing needed here for this simple example
    }

    @Test 
    public void addTest() {
        int c = 2;
        int d = simpleMath.add(1, 1);
        System.out.print("Expected Value: " + c + " Actual Value: " + d);
        assertEquals(c, d);
        assertEquals( 5, simpleMath.add(2, 3)); // 2 + 3 = 5
        assertEquals( 0, simpleMath.add(-1, 1)); // -1 + 1 = 0
        assertEquals( 3, simpleMath.add(-1, 4)); // -1 + 4 = 3
        assertEquals( -4, simpleMath.add(-6, 2)); // -6 + 2 = -4
        assertEquals( -2, simpleMath.add( -1, -1)); // -1 + -1 = -2

        // Loop through two variables to test a range of values
        for(int a = -5; a <= 5; a++) {
            for(int b = -3; b <= 3; b++) {
                int expectedResult = a+b;
                assertEquals(expectedResult, simpleMath.add(a,b));
            }
        }
    }

    @Test
    public void subtractTest() {
        assertEquals( 1, simpleMath.subtract(5, 4));
        assertEquals( -1, simpleMath.subtract(4, 5));
        assertEquals( 0, simpleMath.subtract(5, 5));
    }
}
