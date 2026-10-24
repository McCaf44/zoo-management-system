// subclass 2 lion is a type of animal
// a lion is also a predator so it implements Predator
public class Lion extends Animal implements Predator{

// Introduce at least one additional instance variable
// relevant to the specific type of animal. For a lion
// I will be using a number of members in its pride

    private int prideSize; // Encapsulated because it is species specific data

    // constructor that uses the super call
    public Lion(String name, int age, String colour, double weight, int prideSize) {
        // Passes common data to the animal constructor
        super(name, age, colour, weight);

        // Setter to validate the value right away
        // The set checks if the value is greater than 0
        setPrideSize(prideSize);
    }

    // Requiremnt of overriding makesound method to provide noise and a description
    @Override
    public String makeSound() {
        return "Roar! I am " + getName() + ", a " + getAge() + " years old " + getColour() + " I am in a pride of " + getPrideSize() + "lions.";
    }

    //  Getters and Setters with Validation
    public int getPrideSize() {
        return prideSize;
    }

    @Override
    public String toFileFormat() {
        return "Lion," + getName() + "," + getAge() + "," + getColour() + "," + getWeight() + "," + prideSize;
    }

    @Override
    public String toString() {
        // Added "Weight: %.1f kg" and getWeight() in the correct order
        return String.format("Type: Lion    | Name: %-10s | Age: %d | Weight: %.1f kg | Colour: %-7s | Pride Size: %d",
                getName(), getAge(), getWeight(), getColour(), prideSize);
    }

    // Predator interface implementations ( realization)
    @Override
    public void trackPrey() {
        System.out.println(getName() + " is stalking through the grass. ");

    }

    @Override
    public void checkDentalHealth() {
        // requirement 6 specialized care for predators
        System.out.println("Zookeeper is checking " + getName() + "'s sharp teeth for decay.");
    }

    public void setPrideSize(int prideSize) {
        if (prideSize > 0) { // validation to maintain integrity of the variable
            this.prideSize = prideSize;
        } else {
            System.out.println("Invalid pride size !");
        }
    }
}

