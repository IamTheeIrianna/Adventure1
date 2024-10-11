import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
    private final Scanner scanner;
    private final Player player;

    //--------------------------------------------
    // game cosstructor
    public Adventure() {
        scanner = new Scanner(System.in);
        Map map = new Map();
        player = new Player(map.getStartingRoom()); // Initialize the player

        welcomeMessage(); // Display the welcome message
    }

    //------------------------------------------------
    // Method to display the welcome message
    private void welcomeMessage() {
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
        System.out.println("equip + weapon name - to equip weapon");
        System.out.println("attack - Attack the enemy in the room");
        System.out.println("\nEnter [start] to start the game.");

    }

    //----------------------------------------------
    // Method to start the game
    public void startGame() {
        String input = scanner.nextLine(); // User input reader

        if (input.equalsIgnoreCase("start")) {
            displayCurrentRoom();
            gameLoop(); // Start the game loop

        } else {
            System.out.println("Invalid command. Please type 'start' to begin.");
            startGame(); // Prompt to start if incorrect input
        }
    }

    //----------------------------------------
    //  game logic execution loop
    private void gameLoop() {
        while (true) {
            String input = scanner.nextLine(); // User input

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for playing");
                scanner.close();
                break; // Exit game loop

            } else if (input.startsWith("go ")) {
                navigate(input.substring(3).toLowerCase()); // Navigate to a different room

            } else if (input.equalsIgnoreCase("look") || input.equalsIgnoreCase("look around")) {
                displayCurrentRoom(); // Display the current room details

            } else if (input.equalsIgnoreCase("help")) {
                displayHelpMessage(); // help message

            } else if (input.startsWith("take ")) {
                takeItem(input.substring(5)); // Take item method

            } else if (input.startsWith("drop ")) {
                dropItem(input.substring(5)); // Drop an item from the inventory

            } else if (input.equalsIgnoreCase("inventory") || input.equalsIgnoreCase("inv")) {
                showInventory(); // Show player inventory

            } else if (input.startsWith("eat ")) {
                eatFood(input.substring(4));

            } else if (input.startsWith("equip ")) {
                equipWeapon(input.substring(6)); // Equip a weapon from inventory

            } else if (input.startsWith("attack ")) {
                attack(input.substring(7)); // Attack an enemy in the room

            } else {
                System.out.println("Invalid command. Type 'help' for options.");
            }
        }
    }

    //---------------------------------------------------
    private void navigate(String direction) {
        Room nextRoom;
        switch (direction) {
            case "north", "n", "go north", "NORTH", "GO NORTH":
                nextRoom = player.getCurrentRoom().getNorth(); // Get the room to the north
                break;
            case "south", "go south", "SOUTH", "GO SOUTH":
                nextRoom = player.getCurrentRoom().getSouth(); // Get the room to the south
                break;
            case "east":
                nextRoom = player.getCurrentRoom().getEast(); // Get the room to the east
                break;
            case "west":
                nextRoom = player.getCurrentRoom().getWest(); // Get the room to the west
                break;
            default:
                System.out.println("Invalid direction."); // Invalid direction
                return;
        }
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom); // Set the player's current room to the next room
            displayCurrentRoom(); // Show new room descript after new nav
        } else {
            System.out.println("You can't go that way.");
        }
    }

    //-------------------------------------------------
    private void displayCurrentRoom() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());

        if (!currentRoom.getEnemies().isEmpty()) {
            System.out.println("This room has enemies!");
            for (Enemy enemy : currentRoom.getEnemies()) {
                System.out.println("- " + enemy.getName() + " health: " + enemy.getHealth());
            }
        }

        displayItemsInCurrentRoom(); // Display items in the current room
    }

    //------------------------------
    private void displayItemsInCurrentRoom() {
        ArrayList<Item> items = player.getCurrentRoom().getItems();

        if (items.isEmpty()) {
            System.out.println("no items.");
        } else {
            System.out.println("Items in this dimension: ");
            for (Item item : items) {
                System.out.println("- " + item.getLongName());
            }
        }
    }

    //------------------------------------------
    private void showInventory() {
        ArrayList<Item> inventory = player.getInventory();

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Items in inventory: ");
            for (Item item : inventory) {
                System.out.println("- " + item.getLongName());
            }
        }
    }

    //------------------------------------------
    private void takeItem(String itemName) {
        Room currentRoom = player.getCurrentRoom(); // Get the current room
        for (Item item : currentRoom.getItems()) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                currentRoom.removeItem(item); // Remove item from the room
                player.addItem(item); // Add item to player's inventory
                System.out.println("You've picked up " + item.getLongName() + ".");
                return;
            }
        }
        System.out.println("Item unavailable.");
    }
    //------------------------------------------
    private void dropItem(String itemName) {
        Item itemToDrop = player.findItem(itemName);

        if (itemToDrop != null) {
            player.removeItem(itemToDrop);
            player.getCurrentRoom().addItem(itemToDrop);
            System.out.println("You dropped the " + itemToDrop.getLongName());
        } else {
            System.out.println("Item unavailable.");
        }
    }

    //------------------------------------------
    private void eatFood(String foodName) {
        Item food = player.findItem(foodName);

        if (food instanceof Food) {
            player.eat((Food) food);
            player.removeItem(food);
            System.out.println("You've eaten the " + food.getLongName() + ".");
        } else {
            System.out.println("Unedible object");
        }
    }

    //------------------------------------------
    private void equipWeapon(String weaponName) {
        Weapon weaponToEquip = (Weapon) player.findItem(weaponName);

        if (weaponToEquip != null && weaponToEquip instanceof Weapon) {
            player.equipWeapon(weaponToEquip);
            System.out.println("You've equipped " + weaponToEquip.getLongName());
        } else {
            System.out.println("weapon unavailable.");
        }
    }
    //------------------------------------------
    private void attack(String enemyName) {
        Enemy targetEnemy = null;

        for (Enemy enemy : player.getCurrentRoom().getEnemies()) {
            if (enemy.getName().equalsIgnoreCase(enemyName)) {
                targetEnemy = enemy;
                break;
            }
        }
        //------------------------------------------
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon == null) {
            System.out.println("Please choose a weapon to equip");
            return;
        }
        if (targetEnemy != null) {
            int damageDealt = equippedWeapon.getDamage();
            targetEnemy.takeDamage(damageDealt);
            System.out.println(targetEnemy.getName() + " has taken " + damageDealt + " damage.");

            if (!targetEnemy.isAlive()) {
                player.getCurrentRoom().removeEnemy(targetEnemy);
                Item droppedWeapon = targetEnemy.dropWeapon();
                player.getCurrentRoom().addItem(droppedWeapon);
                System.out.println(targetEnemy.getName() + " has been defeated!!!");
            } else {
                targetEnemy.attack(player);  // Enemy attacks back
                System.out.println(player.getHealth());  // Show player's health after attack
            }
        } else {
            System.out.println("Unknown or unavailable enemy");
        }
    }

    //------------------------------------------
    private void displayHelpMessage() {
        System.out.println("\n--- Help Menu ---");
        System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east \n- south \n- west.");
        System.out.println("Abbreviations:" + "\n[" + "n,e,s,w" + "]");
        System.out.println("- 'look' or 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("inventory / inv / invent - Show your inventory");
        System.out.println("health - Show your current health status");
        System.out.println("take <item> - Take an item");
        System.out.println("drop <item> - To drop an item");
        System.out.println("eat <food> - To eat an edible");
        System.out.println("equip + weapon name - to equip weapon");
        System.out.println("attack - Attack the enemy in the room");
    }
}
