public abstract class Animal {
    // instance variables made private
    private String name;
    private int age;
    private String colour;
    private double weight;

    // Constructor initializes data
    public Animal(String name, int age, String colour, double weight) {
        // Call the setter methods inside constructor to improve data validation
        setName(name);   // Uses validation logic
        setAge(age);     // Checks the 0-150 range
        setColour(colour);
        setWeight(weight);
    }


    // Encapsulation getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColour() {
        return colour;
    }


    public double getWeight() {
        return weight;
    }

    // setter methods for encapsulation
    public void setName(String name) {
        // use .length() because name is a string
        if (name.length() > 0) {
            this.name = name;
        } else {
            // validation
            System.out.println("Error name cannot be left blank");
        }
    }

    public void setAge(int age) {
        // check if integer  is valid
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            //validation
            System.out.println("Invalid age provided");
        }
    }

    public void setColour(String colour) {
        // use .length() because colour is a string
        if (colour.length() > 0) {
            this.colour = colour;
        } else {
            // validation
            System.out.println("Error colour cannot be left blank");
        }

    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            // validation
            System.out.println("Error: Weight must be a positive number.");
        }
    }


    // abstract method
    public abstract String makeSound();


    public boolean isValid() {
        //  Check that strings aren't blank (length > 0)
        // and numbers are within valid ranges.
        return name.length() > 0 && colour.length() > 0 && age >= 0 && weight > 0;
    }


    public abstract String toFileFormat();


    @Override
    public abstract String toString();



    // Helper for  Search requirement
    public void showDetails() {
        System.out.println(this.toString());
    }
}

// no main method because Animal class is an abstract class


