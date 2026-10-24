// sub class 3 dolphin is a type of Animal
// Dolphin implements swimmable
public class Dolphin extends Animal implements Swimmable {


    // Species-specific instance variable
    private double swimSpeed;

    // Constructor passes common data to the animal superclass
    public Dolphin(String name, int age, String colour, double weight, double swimSpeed) {
        super(name, age, colour, weight);

// setter applies validation logic immediately upon instantiation
        setSwimSpeed(swimSpeed);
    }

    //  overriding makeSound to provide noise and dynamic description
    @Override
    public String makeSound() {
        // uses inherited getters
        return "Click-whistle! I am " + getName() + ", a " + getAge() + " year old " + getColour() + " dolphin.";
    }

    // Swimmable interface implementations
    @Override
    public void swim() {
        System.out.println(getName() + " is gliding through the water at " + swimSpeed + "knots.");
    }

    public void checkDolphinAirway() {
//Performs specialized care specific to the interface
        System.out.println("Zookeeper is performing an airway check on  " + getName() + "!");
    }

    // Getters and setters with Validation
    public double getSwimSpeed() {
        return swimSpeed;
    }

   @Override
    public String toFileFormat() {
        // Order: Type, Name, Age, Colour, Weight, SwimSpeed
        return "Dolphin," + getName() + "," + getAge() + "," + getColour() + "," + getWeight() + "," + swimSpeed;
    }

    @Override
    public String toString() {
        // 1. Name (%-10s) | 2. Age (%d) | 3. Weight (%.1f) | 4. Colour (%-7s) | 5. Speed (%.1f)
        return String.format("Type: Dolphin | Name: %-10s | Age: %d | Weight: %.1f kg | Colour: %-7s | Speed: %.1f knots",
                getName(), getAge(), getWeight(), getColour(), swimSpeed);
    }
    public void setSwimSpeed(double swimSpeed) {
// Validation that maintains the integrity of the object's state
        if (swimSpeed > 0) {
            this.swimSpeed = swimSpeed;
        } else {
            System.out.println("Invalid swim speed! Speed must be greater than 0.");
        }
    }
}

