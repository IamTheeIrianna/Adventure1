import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies; //array list to hold enemies
    //---------------------------------------------
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        enemies = new ArrayList<>(); //enemy list initializer
    }
    //---------------------------------------------
    //add enemy to room method
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
    //---------------------------------------------
     public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }
    //---------------------------------------------
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    //---------------------------------------------
    public void addItem(Item item) {
        items.add(item);
    }
    //---------------------------------------------
    public void removeItem(Item item) {
        items.remove(item);
    }
    //---------------------------------------------
    public ArrayList<Item> getItems() {
        return items;
    }
    //---------------------------------------------
    public boolean hasItem(String shortName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return true; // Item exists in the room
            }
        }
        return false; // Item not found
    }
    //---------------------------------------------
    public String getDescription() {
        return description; // Method to get room description
    }

    public String getName() {
        return name; // Method to get room name
    }
    //---------------------------------------------
    // Setters for room connections
    public void setNorth(Room north) { this.north = north; }

    public void setEast(Room east) { this.east = east; }

    public void setSouth(Room south) { this.south = south; }

    public void setWest(Room west) { this.west = west; }
    //---------------------------------------------
    // Getters for room connections
    public Room getNorth() { return north; }

    public Room getEast() { return east; }

    public Room getSouth() { return south; }

    public Room getWest() { return west; }
}
