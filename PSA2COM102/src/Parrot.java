// subclass 1 Parrot is a type of Animal
// parrot can also fly so it implements Flyable
public class Parrot extends Animal implements Flyable {

    // Connects subclass to both the base class and the behaviour contract
    private double wingSpan;

    public Parrot(String name, int age, String colour, double weight, double wingSpan) {
        super(name, age, colour, weight); // Fulfils the "Animal" contract
        // instead of doing this.wingSpan = wingSpan; using setter applies validation immediately below
        setWingSpan(wingSpan);
    }


    @Override
    public String makeSound() {
        //Noise  and description  calling in methods from the animal base class (eg Miaow! I am pixel, a 4 year old tabby)
        return "Squawk! I am " + getName() + ", a " + getAge() + " years old " + getColour() + " parrot.";
    }

    //  -- Interface implementations --
    @Override
    public void fly() {
        System.out.println(getName() + " is flying with it's " + wingSpan + "m wingspan. ");
    }


    @Override
    public void performWingHealthCheck() {
        // Specialized care that is specific to flying animals
        System.out.println("Zookeeper is checking " + getName() + "'s wings for health issues.");
    }

    //  Getters and Setters with Validation
    public double getWingSpan() {
        return wingSpan;
    }


    @Override
    public String toFileFormat() {
        return "Parrot," + getName() + "," + getAge() + "," + getColour() + "," + getWeight() + "," + wingSpan;
    }
    @Override
    public String toString() {
        // Order: Name, Age, Weight, Colour, Wingspan
        return String.format("Type: Parrot | Name: %-10s | Age: %d | Weight: %.1f kg | Colour: %-7s | Wingspan: %.1f m",
                getName(), getAge(), getWeight(), getColour(), wingSpan);
    }


    public void setWingSpan(double wingSpan) {
        if (wingSpan > 0) { // validation to maintain integrity of the variable
            this.wingSpan = wingSpan;
        } else {
            System.out.println("Invalid wingspan!");


        }

    }
}





