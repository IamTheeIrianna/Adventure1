import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);


    public void displayWelcomeMessage() {
        System.out.println("\nWelcome to the adventure game!");
        System.out.println("In this game you will be navigating through 9 different dimensions");
        System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east \n- south \n- west.");
        System.out.println("Abbreviations:" + "\n[" + "n,e,s,w" + "]");
        System.out.println("- 'look' or 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("inventory / inv / invent - Show your inventory");
        System.out.println("health - Show your current health status");
        System.out.println("take <item> - Take an item");
        System.out.println("drop <item> - To drop an item");
        System.out.println("eat <food> - To eat an edible");
        System.out.println("equip <weapon name> - To equip weapon");
        System.out.println("attack - Attack the enemy in the room");
        System.out.println("\nEnter [start] to start the game.");
        String command = scanner.nextLine().toLowerCase();
    }

    public void showInstructions() {
        System.out.println("\n--- Help Menu ---");
        System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east \n- south \n- west.");
        System.out.println("Abbreviations:" + "\n[" + "n,e,s,w" + "]");
        System.out.println("- 'look' or 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("inventory / inv / invent - Show your inventory");
        System.out.println("health - Show your current health status");
        System.out.println("take <item> - Take an item");
        System.out.println("drop <item> - To drop an item");
        System.out.println("eat <food> - To eat an edible");
        System.out.println("equip <weapon name> - To equip weapon");
        System.out.println("attack - Attack the enemy in the room");
    }

    public void displayRoomDescription(Room room) {
        System.out.println(room.getDescription());
        List<Item> itemsInRoom = room.getItems();

        if (!itemsInRoom.isEmpty()) {
            System.out.print("Items in this dimension: ");
            for (Item item : itemsInRoom) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        }
    }

    public void showInventory(Player player) {
        List<Item> inventoryItems = player.getInventory();

        if (inventoryItems.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.print("You have: ");
            for (Item item : inventoryItems) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        }
    }
}
