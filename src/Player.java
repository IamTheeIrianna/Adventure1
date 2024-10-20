import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;

    public Player() {
        inventory = new ArrayList<>();
        health = 90;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room; }

    public void takeItem(Item item) {
        inventory.add(item);
    }

    public Item dropItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.remove(item);
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    public int getHealth() {
        return health;
    }
    public void decreaseHealth(int amount) {
        health -= amount;
        System.out.println("Your health is now at " + health);

        if (health <= 0) {
            System.out.println("D.E.F.E.A.T.");
        }
    }
}
