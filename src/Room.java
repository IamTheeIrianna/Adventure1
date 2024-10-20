import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north, south, east, west;
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public void setNorth(Room room) { this.north = room; }
    public void setSouth(Room room) { this.south = room; }
    public void setEast(Room room) { this.east = room; }
    public void setWest(Room room) { this.west = room; }

    public Room getNorth() { return north; }
    public Room getSouth() { return south; }
    public Room getEast() { return east; }
    public Room getWest() { return west; }

    public String getDescription() {
        return description;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Item removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null; // Item not found
    }

    public ArrayList<Item> getItems() { return items; }
}

