import java.util.ArrayList;

public class Room {
    private String name;
    private String description;

    private Room north;
    private Room west;
    private Room east;
    private Room south;
    private String shortName;
    private String longName;
    private ArrayList<Item> roomItems;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.shortName = shortName;
        this.longName = longName;
        this.roomItems = new ArrayList<>();
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

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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

    public String getLongName() {
        return longName;
    }
    public String getShortName() {
        return shortName;
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
            if (item.getDescription().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }
}
