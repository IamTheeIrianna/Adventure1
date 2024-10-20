public class Food extends Item {
    private int healthPoints;
    private String shortName;

    public Food(String name, String shortName, int healthPoints) {
        super(name, shortName); // Call the parent constructor with the full name
        this.healthPoints = healthPoints; // Set health points
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getShortName() {
        return shortName; // Getter for short name
    }
    public String toString() {
        return getShortName(); // Return short name for display purposes
    }
}
