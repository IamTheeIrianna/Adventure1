import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;
    //---------------------------------------------
    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        //---------------------------------------------
        this.health = 100; // Example starting health
    }
    //---------------------------------------------
    public Room getCurrentRoom() {
        return currentRoom;
    }
    //---------------------------------------------
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }
    //---------------------------------------------
    public ArrayList<Item> getInventory() { return inventory; }
    //---------------------------------------------
    public int getHealth() { return health; }
    //---------------------------------------------
    public void eat(Food food) {
        health += food.getHealthPoints();
        System.out.println("Your health is now: " + health);
    }
    //---------------------------------------------
    public void addItem(Item item) { inventory.add(item); }

    public void removeItem(Item item) { inventory.remove(item); }

    public Item findItem(String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item; // Return the found item
            }
        }
        return null; // Not found
    }
    //----------------------------------------
    // Attack method
    public void attack(Enemy enemy) {
        System.out.println("You've attacked" + enemy.getName() + "!");
        enemy.takeDamage(10); // Example damage value
    }
}
