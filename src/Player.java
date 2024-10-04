import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case "north":
                nextRoom = currentRoom.getNorth();
                break;
            case "east":
                nextRoom = currentRoom.getEast();
                break;
            case "south":
                nextRoom = currentRoom.getSouth();
                break;
            case "west":
                nextRoom = currentRoom.getWest();
                break;
            default:
                System.out.println("The path you have chosen is unavailable");
                return;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You've headed to ' " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        } else {
            System.out.println("The path you have chosen is unavailable");
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item findItem(String shortName) {
        for (Item item : inventory) {
            if (item.getDescription().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public void takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);
        if (item != null) {
            currentRoom.removeItem(item);
            addItem(item);
            System.out.println("You've chosen the " + item.getShortName());

        } else {
            System.out.println("There is no such " + shortName + " object here");
        }
    }

    public void dropItem(String shortName) {
        Item item = findItem(shortName);
        if (item != null) {
            removeItem(item);
            currentRoom.addItem(item);
            System.out.println("You've dropped the " + item.getShortName());
        } else {
            System.out.println("There is no such item as " + shortName + " in your inventory");
        }
    }
}
