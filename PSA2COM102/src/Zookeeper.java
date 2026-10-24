import java.util.ArrayList;

public class Zookeeper {
    private String name;

    public Zookeeper(String name) {
        this.name = name;
    }

    public void performDailyRoutine(ArrayList<Animal> animalList) {
        System.out.println("Zookeeper " + name + " is starting the morning rounds...");

        for (Animal a : animalList) {
            System.out.println("--- Caring for " + a.getName() + " ---");

            // Use the standard check and manual cast for each interface
            if (a instanceof Flyable) {
                Flyable f = (Flyable) a;
                f.fly();
                f.performWingHealthCheck();
            }

            if (a instanceof Swimmable) {
                Swimmable s = (Swimmable) a;
                s.swim();
                s.checkDolphinAirway();
            }

            if (a instanceof Predator) {
                Predator p = (Predator) a;
                p.trackPrey();
                p.checkDentalHealth();
            }

            if (a instanceof Climbable) {
                Climbable c = (Climbable) a;
                c.climb();
                c.checkHabitatTemperature();
            }

            System.out.println("Status: Health Verified for " + a.getName());
        }
    }
}