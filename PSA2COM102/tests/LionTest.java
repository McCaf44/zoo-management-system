import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LionTest {

    @Test
    void testGetNameValid() {
        // Arrange
        Lion myLion = new Lion("Simba", 5, "Gold", 200.0, 10);

        // Act & Assert
        assertEquals("Simba", myLion.getName(), "The name should be Simba.");
    }

    @Test
    void testGetNameBlank() {
        // Arrange: Start with a valid lion
        Lion myLion = new Lion("Simba", 5, "Gold", 200.0, 10);

        // Act: Attempt to set name to blank
        myLion.setName("");

        // Assert: Name should still be "Simba" because of your validation logic
        assertEquals("Simba", myLion.getName(), "The name should not have changed to a blank string.");
    }
}