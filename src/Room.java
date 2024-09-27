public class Room {
    private String name;
    private String description;
    private Room north;
    private Room west;
    private Room east;
    private Room south;

    public Room(String name) {
        this.name = name;
        this.description = description;
    }

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

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Room getEast(){
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
}