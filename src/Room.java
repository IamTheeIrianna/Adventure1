import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private String shortDescription;
    private String longDescription;
    private Room north;
    private Room west;
    private Room east;
    private Room south;
    private ArrayList<Item> roomItems;

    public Room(String name, String description) {
        name = name;
        description = description;
        roomItems = new ArrayList<>();
    }

    // Setters
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getEast() {
        return east;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public void addItem(Item item) {
        roomItems.add(item);
    }

    public void removeItem(Item item) {
        roomItems.remove(item);
    }

    public ArrayList<Item> getItems() {
        return roomItems;
    }

    public Item findItem(String shortName) {
        for (Item item : roomItems) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }
}
