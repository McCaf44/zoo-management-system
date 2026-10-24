// subclass 4 Panda is a type of Animal
// Panda implements the  Climbable  contract
public class Panda extends Animal implements Climbable {

    // Species-specific instance variable(Information Hiding)
    private double bambooConsumption;


    // Constructor to initialize the object and pass common data to superclass
    public Panda(String name, int age, String colour, double weight, double bambooConsumption) {
        super(name, age, colour, weight);

        // setter ensures validation logic is applied immediately
        setBambooConsumption(bambooConsumption);
    }

    // Overriding makeSound method to provide noise and dynamic description
    @Override
    public String makeSound() {
        // Uses inherited getters to follow Information Hiding principles
        return "Chirp-squeak! I am " + getName() + ", a " + getAge() +
                "year old " + getColour() + "panda.";
    }

    //  saving logic
    @Override
    public String toFileFormat() {
        // Order: Type, Name, Age, Colour, Weight, BambooConsumption
        return "Panda," + getName() + "," + getAge() + "," + getColour() + "," + getWeight() + "," + bambooConsumption;
    }

    @Override
    public String toString() {
        return String.format("Type: Panda   | Name: %-10s | Age: %d | Weight: %.1f kg | Colour: %-7s | Bamboo: %.1f kg",
                getName(), getAge(), getWeight(), getColour(), bambooConsumption);
    }

    // Climmable Interface Implementations (Realization)
    @Override
    public void climb() {
        System.out.println(getName() + " is slowly climbing a tree.");

    }

    @Override
    public void checkHabitatTemperature() {
        //Performs specialized care specific to the interface
        System.out.println("Zookeeper is checking if " + getName() + "'s enclosure is cool enough.");

    }

    // Getters and Setters with validation
    public double getBambooConsumption() {
        return bambooConsumption;
    }

    // create a setter for bamboo consumption
    public void setBambooConsumption(double bambooConsumption) {
        // validation to check for data integrity
        if (bambooConsumption > 0) {
            this.bambooConsumption = bambooConsumption;
        } else {
            // UI message
            System.out.println("Invalid bamboo consumption! Must be greater than 0kg. ");
        }

    }
}

