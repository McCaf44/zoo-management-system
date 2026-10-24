import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ParrotTest {
    @Test
    void makeSound() {
        //  Create a parrot with specific details
        // (Ensure these match your Parrot constructor: Name, Age, Colour)
        Parrot testParrot = new Parrot("Polly", 5, "Green", 20, 25);

        // expected result
        String expected = "Squawk! I am Polly, a 5 years old Green parrot.";

        //get actual result
        String actual = testParrot.makeSound();

        // check if they match
        assertEquals(expected, actual, "The parrot sound message is incorrect!");

        // print to show the test accually executed the method
        System.out.println("makeSound method executed successfully ");
    }

}