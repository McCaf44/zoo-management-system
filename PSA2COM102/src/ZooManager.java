import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ZooManager {

    // Instance Variables
    // Uses plural 'animals' to show it manages a collection
    private ArrayList<Animal> animals = new ArrayList<>();
    private Scanner keyboard = new Scanner(System.in);
    private final String ZOO_NAME = "Ulster University Zoo";

    // Constructor
    public ZooManager() {
        //  Repopulate on startup
        loadData();
        System.out.println("Welcome to the " + ZOO_NAME + " Management System.");
    }



    // Zoo Service Methods

    public void addAnimal() {
        System.out.println("\n--- Add New Animal ---");

        // Common animal information
        System.out.print("Enter Species (1. Parrot | 2. Lion | 3. Panda | 4. Dolphin): ");
        int type = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Name: ");
        String name = keyboard.nextLine();

        System.out.print("Age: ");
        int age = keyboard.nextInt();

        System.out.print("Colour: ");
        keyboard.nextLine(); // clear before string
        String colour = keyboard.nextLine();

        System.out.print("Weight: ");
        double weight = keyboard.nextDouble();

        // Validation for the inherited variables from the animal classes
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }
        // Validation for Colour
        if (colour.isEmpty()) {
            System.out.println("Error: Colour cannot be empty.");
            return;
        }



        // specific animal types logic
        if (type == 1) {
            System.out.print("Wing Span: ");
            double wings = keyboard.nextDouble();
            animals.add(new Parrot(name, age, colour, weight, wings));
        } else if (type == 2) {
            System.out.print("Pride Size: ");
            int pride = keyboard.nextInt();
            animals.add(new Lion(name, age, colour, weight, pride));
        } else if (type == 3) {
            System.out.print("Bamboo Intake: ");
            double bamboo = keyboard.nextDouble();
            animals.add(new Panda(name, age, colour, weight, bamboo));
        } else if (type == 4) {
            System.out.print("IQ Score: ");
            int iq = keyboard.nextInt();
            animals.add(new Dolphin(name, age, colour, weight, iq));
        }

        keyboard.nextLine(); // Clear the final newline
        System.out.println("Success: Animal added to the zoo!");
    }
    public void removeAnimal() {
        System.out.print("Enter Name of animal to remove: ");
        String name = keyboard.nextLine();

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equalsIgnoreCase(name)) {
                animals.remove(i);
                System.out.println("Record deleted.");
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    public void searchAnimal() {
        System.out.print("Enter Name or Colour to search: ");
        String query = keyboard.nextLine();
        boolean found = false;

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);

            if (a.getName().equalsIgnoreCase(query) || a.getColour().equalsIgnoreCase(query)) {
                a.showDetails();
                System.out.println("Vocalisation: " + a.makeSound());
                found = true;
            }
        }

        if (found == false) {
            System.out.println("No matching animal found.");
        }
    }
    public void modifyAnimal() {
        System.out.print("Enter name to search for: ");
        String searchName = keyboard.nextLine();

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);


            if (a.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Animal found! Enter the new details.");

                System.out.print("New Weight: ");
                double w = keyboard.nextDouble();
                a.setWeight(w);

                System.out.print("New Age: ");
                int age = keyboard.nextInt();
                a.setAge(age);

                keyboard.nextLine();
                System.out.println("Updated successfully.");
                return; // Exit the method
            }
        }
    }

    public void viewAllAnimals() {
        System.out.println("\n--- All Animals ---");

        if (animals.size() == 0) {
            System.out.println("No animals in the zoo.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println(animals.get(i).toString());
            }
        }
    }
    public void performDailyCare() {
        // Create the Zookeeper instance
        // Hardcoded zookeeper name
        Zookeeper expert = new Zookeeper("John the Keeper");

        //  Message Passing: Tell the expert to do the routine
        // We pass the 'animals' ArrayList so the Zookeeper can access the collection
        System.out.println("\n--- Starting Zookeeper Routine ---");
        expert.performDailyRoutine(this.animals);

        System.out.println("Zookeeper routine finished successfully.");
    }


    public void generateReport() {
        System.out.println("\n--- Zoo report status ---");
        System.out.println("Total Animals: " + animals.size());

        //  counters
        int parrotCount = 0;
        int lionCount = 0;
        int pandaCount = 0;
        int dolphinCount = 0;

        // loop to count types
        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i); // Manually get the animal at index i

            if (a instanceof Parrot) {
                parrotCount++;
            } else if (a instanceof Lion) {
                lionCount++;
            } else if (a instanceof Panda) {
                pandaCount++;
            } else if (a instanceof Dolphin) {
                dolphinCount++;
            }
        }

        // Print the counts on separate lines (easier than printf)
        System.out.println("Parrots: " + parrotCount);
        System.out.println("Lions: " + lionCount);
        System.out.println("Pandas: " + pandaCount);
        System.out.println("Dolphins: " + dolphinCount);

        // Average age for animals
        if (animals.size() > 0) {
            int totalAge = 0;

            for (int i = 0; i < animals.size(); i++) {
                Animal a = animals.get(i);


                totalAge += a.getAge();
            }

            double average = (double) totalAge / animals.size();
            System.out.println("Average Age of Animals: " + average);
        }
    }
  // Data persistence
  private void loadData() {
      try {
          File f = new File("AnimalDetails.txt");
          Scanner fileReader = new Scanner(f);

          while (fileReader.hasNextLine()) {
              String line = fileReader.nextLine();
              String[] parts = line.split(",");

              //Grab  data directly from the array
              String type = parts[0];
              String name = parts[1];
              int age = Integer.parseInt(parts[2]);
              String colour = parts[3];
              double weight = Double.parseDouble(parts[4]);
              String special = parts[5];

              // Create the right animal
              if (type.equals("Parrot")) {
                  animals.add(new Parrot(name, age, colour, weight, Double.parseDouble(special)));
              } else if (type.equals("Lion")) {
                  animals.add(new Lion(name, age, colour, weight, Integer.parseInt(special)));
              } else if (type.equals("Panda")) {
                  animals.add(new Panda(name, age, colour, weight, Double.parseDouble(special)));
              } else if (type.equals("Dolphin")) {
                  animals.add(new Dolphin(name, age, colour, weight, Double.parseDouble(special)));
              }
          }
          fileReader.close(); // scanner closed

      } catch (Exception e) {
          // Error message
          System.out.println("No file found or error loading data.");
      }
  }

    public void saveData() {
        try {
            // Simple and direct
            PrintWriter writer = new PrintWriter("AnimalDetails.txt");

            for (int i = 0; i < animals.size(); i++) {
                // Fetch the animal manually using the index
                Animal a = animals.get(i);

                // Build the string line by line with commas
                String line = a.getName() + "," + a.getAge() + "," + a.getColour() + "," + a.getWeight();

                // Adding the "Special" attribute using casting
                if (a instanceof Parrot) {
                    line = "Parrot," + line + "," + ((Parrot) a).getWingSpan();
                } else if (a instanceof Lion) {
                    line = "Lion," + line + "," + ((Lion) a).getPrideSize();
                } else if (a instanceof Panda) {
                    line = "Panda," + line + "," + ((Panda) a).getBambooConsumption();
                } else if (a instanceof Dolphin) {
                    line = "Dolphin," + line + "," + ((Dolphin) a).getSwimSpeed();
                }

                writer.println(line);
            }

            writer.close();
            System.out.println("Data saved to AnimalDetails.txt.");

        } catch (Exception e) {
            System.out.println("Error: Could not save the file.");
        }
    }

    // 5. Main Entry Point
    public static void main(String[] args) {
        ZooManager myZoo = new ZooManager();
        Scanner input = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n=== Zoo Management Menu ===");
            System.out.println("1. Add | 2. Remove | 3. Search | 4. View All | 5. Care | 6. Report | 7.Modify | 0. Exit & Save");
            System.out.print("Select: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Clears the input buffer
                switch (choice) {
                    case 1:
                        myZoo.addAnimal();
                        break; // Required to prevent fall-through
                    case 2:
                        myZoo.removeAnimal();
                        break;
                    case 3:
                        myZoo.searchAnimal();
                        break;
                    case 4:
                        myZoo.viewAllAnimals();
                        break;
                    case 5:
                        myZoo.performDailyCare();
                        break;
                    case 6:
                        myZoo.generateReport();
                        break;

                        case 7:
                        myZoo.modifyAnimal();
                        break;

                        case 0:
                        myZoo.saveData();
                        break;
                    default:
                        System.out.println("Invalid selection.");
                        break; // Default case for unmatched values
                }
            } else {
                // If the user types a letter instead of a number
                System.out.println("Error: Please enter a number.");
                input.nextLine();
            }
        } while (choice != 0);
        System.out.println("System terminated. Goodbye!");
    }
}