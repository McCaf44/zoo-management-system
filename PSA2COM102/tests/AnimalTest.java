import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AnimalTest {
    @Test
    void testSetAgeValid() {
        // Arrange: Create an instance of a subclass (like Parrot)
        Parrot parrot = new Parrot("Bluey", 2, "Green", 0.5, 30.0);

        // Act: Use the setter to change the age
        parrot.setAge(5);

        // Assert: Verify the age was actually updated
        assertEquals(5, parrot.getAge(), "The age should be updated to 5.");

        System.out.println("SetAgeValid was successful!");
    }
    @Test
    void testSetAgeInvalid() {
        // Arrange
        Parrot parrot = new Parrot("Bluey", 2, "Green", 0.5, 30.0);
        parrot.setAge(-5); // Try to set an invalid negative age
        // Check the age didn't change
        assertEquals(2, parrot.getAge(), "The age should not update to a negative value.");
        System.out.println("Data Validation (setAge) was successful: Negative age prevented.");
    }
}

