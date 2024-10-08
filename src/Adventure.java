import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
    private final Scanner scanner;
    private final Player player;

    //---------------------------------------------
    // Constructor for  Adventure class
    public Adventure() {
        scanner = new Scanner(System.in);
        Map map = new Map();
        player = new Player(map.getStartingRoom()); // Initialize the player in start room
        welcomeMessage(); // Display the welcome message
    }
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
        System.out.println(getDrop() + " <item> - Drop an item");
        System.out.println("eat <food> - Eat a food item");
        System.out.println("equip + weapon name - to equip weapon");
        System.out.println("attack - Attack the enemy in the room");
        System.out.println("\nEnter [start] to start the game.");
    }
    //----------------------------------------------
    // Method to start the game
    public void startGame() {
        String input = scanner.nextLine(); // user input reader

        if (input.equalsIgnoreCase("start")) {
            displayCurrentRoom(); // current room details display
//----------------------------------------------
            gameLoop(); // game loop start
            //----------------------------------------------
        } else {
            System.out.println("Invalid command. Please type 'start' to begin.");
            startGame(); // Prompt to start if incorrent input
        }
    }
    // Main game loop for game logic execution
    private void gameLoop() {
        while (true) {
            String input = scanner.nextLine(); // user input

            if (input.equals("exit")) {
                System.out.println("Thank you for playing");
                break;// Exit game loop
                //----------------------------------------------
            } else if (input.startsWith("equip ")) { // Equip command
                String weaponName = input.substring(6);
                Item itemToEquip = player.findItem(weaponName); // Find item in inventory

                if (itemToEquip instanceof Weapon) { // Check if it's a Weapon
                    player.equipWeapon((Weapon) itemToEquip);
                } else {
                    System.out.println("You can't equip that item.");
                }
                //----------------------------------------------


            } else if (input.startsWith("attack ")) {
                attack(input.substring(7));

            } else if (input.equalsIgnoreCase("look") || input.equalsIgnoreCase("look around")) {
            displayCurrentRoom(); // Display the current room details
                // ---------------------------------------------
        } else if (input.equalsIgnoreCase("help")) {
            displayHelpMessage(); // Display 'help' message
            //---------------------------------------------
        } else if (input.startsWith("take ")) {
            takeItem(input.substring(5)); // Take an item from the room
            //---------------------------------------------
        } else if (input.startsWith("drop ")) {
            dropItem(input.substring(5)); // Drop an item from the inventory
            //---------------------------------------------
        } else if (input.equals("inventory") || input.equals("inv") || input.equals("inven")) {
            showInventory(); // Show player inventory
            //---------------------------------------------
        } else if (input.equals("health")) {
            showHealth(); // Show player health
            //---------------------------------------------
        } else if (input.startsWith("eat ")) {
            eatFood(input.substring(4)); // Eat a food item
            //----------------------------------------------
        } else if (input.startsWith("go ")) {
            navigate(input.substring(3).toLowerCase()); // Navigate to a different room
                // ----------------------------------------------
        } else if (input.length() == 1) {
            switch (input.toLowerCase()) {
                case "n", "go north", "NORTH", "GO NORTH":
                    navigate("north");
                    break;
                case "s", "go south", "SOUTH", "GO SOUTH":
                    navigate("south");
                    break;
                case "e","go east", "EAST", "GO EAST":
                    navigate("east");
                    break;
                case "w", "go west", "WEST", "GO WEST":
                    navigate("west");
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' for options.");
            }
        } else {
            System.out.println("Invalid command. Type 'help' for options.");
        }
    }
        scanner.close();
}
    //----------------------------------------------
    private void attack(String enemyName) {
        Weapon equippedWeapon = player.getEquippedWeapon();
        //----------------------------------------------
        if(equippedWeapon == null) {
            System.out.println("Equip weapon from inventory or move to retrospecitve room");
            return;
            //----------------------------------------------
        }
        Enemy targetEnemy = null;

        if (enemyName != null && !enemyName.isEmpty()) {

            for(Enemy enemy : player.getCurrentRoom().getEnemies()) {

                if(enemy.getName().equalsIgnoreCase(enemyName)) {
                    targetEnemy = enemy;
                    break;
                }
            }
            if (targetEnemy == null) {
                System.out.println("there is no enemies in this room");
                return;
            }
            System.out.println("Attack" + targetEnemy.getName() + "with the" + equippedWeapon.getLongName() + "!");
            targetEnemy.takeDamage(equippedWeapon.getDamage());

            //----------------------------------------------
            if(targetEnemy.getHealth() > 0) {
                targetEnemy.attack(player);
//----------------------------------------------
            } else {
                player.getCurrentRoom().removeEnemy(targetEnemy);
                System.out.println(targetEnemy.getName() + "has been defeated!!!");
            }
        } else {
            System.out.println("you've attacked the air with " + equippedWeapon.getLongName() + "!");
            equippedWeapon.use();

        }
    }
    //----------------------------------------------
    private static String getDrop() { //item drop
        return "drop";
    }
    //----------------------------------------------
    private void displayCurrentRoom() {
        Room currentRoom = player.getCurrentRoom(); // Get the current room of the player
        System.out.println(currentRoom.getName()); // Display the room name
        System.out.println(currentRoom.getDescription()); // Display the room description
//----------------------------------------------
        if(!currentRoom.getEnemies().isEmpty()) {
            System.out.println("this room has an enemy!");
            for(Enemy enemy : currentRoom.getEnemies()) {
                System.out.println("- " + enemy.getName() + "health status: " + "("+ enemy.getHealth() + " )");
            }
        } else {
            System.out.println("There are no enemies here... Luckily...");
        }
        //----------------------------------------------
        displayItemsInCurrentRoom(); // Display items in the current room
    }
    //----------------------------------------------
    // Method to display items in the current room
    //move to UI?
    private void displayItemsInCurrentRoom() {
        ArrayList<Item> items = player.getCurrentRoom().getItems(); // Get items in the current room

        if (items.isEmpty()) {
            System.out.println("There are no items here. "); // No items in the room

        } else {
            System.out.println("Items in this room: ");
            for (Item item : items) {
                System.out.println("- " + item.getLongName()); // Display each item's long name
            }
        }
    }
    //----------------------------------------------
    // Method to show inventory
    private void showInventory() {
        ArrayList<Item> inventory = player.getInventory(); // Get player's inventory
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory: ");
            for (Item item : inventory) {
                System.out.println("- " + item.getLongName()); // Display each item's long name. change to include short name?
            }
        }
    }
    //----------------------------------------------
    // Method to show health
    private void showHealth() {
        System.out.println("Your health is: " + player.getHealth()); // Display player's health
    }
    //----------------------------------------------
    // Method to take an item from the room
    private void takeItem(String itemName) {
        Room currentRoom = player.getCurrentRoom(); // Get the current room
        for (Item item : currentRoom.getItems()) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                currentRoom.removeItem(item); // Remove item from the room
                player.addItem(item); // Add item to player's inventory
                System.out.println("You've picked up the " + item.getLongName() + ".");
                return;
            }
        }
        System.out.println("Item unavailable."); // Item not found
    }
    //----------------------------------------------
    // Method to drop an item from the inventory
    private void dropItem(String itemName) {
        Item itemToDrop = player.findItem(itemName); // Find item in player inventory
        if (itemToDrop != null) {
            player.removeItem(itemToDrop); // Remove item from inventory
            player.getCurrentRoom().addItem(itemToDrop); // Add item to current room
            System.out.println("You dropped the " + itemToDrop.getLongName() + ".");
        } else {
            System.out.println("You don't have that item."); // Item not in inventory
        }
    }
    //----------------------------------------------
    // Method to eat food
    private void eatFood(String foodName) {
        Item food = player.findItem(foodName); // Find food item in inventory
        if (food instanceof Food) {
            player.eat((Food) food); // Eat the food item
            player.removeItem(food); // Remove food after eating
            System.out.println("You eat the " + food.getLongName() + ".");
        } else {
            System.out.println("You can't eat that."); // Item is not food
        }
    }
    // Method to navigate to a different room
    //move to player class //---------------------------------------------
    private void navigate(String direction) {
        Room nextRoom;
        switch (direction) {
            case "north":
                nextRoom = player.getCurrentRoom().getNorth(); // Get the room to the north
                break;
            case "south":
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
            System.out.println("You can't go that way."); // No room in the specified direction
        }
    }
    // move to UI class //---------------------------------------------
    // Method to display the help message
    private void displayHelpMessage() {
        System.out.println("\n--- Help Menu ---");
        System.out.println("- 'look' or 'look around': Display your current room's details.");
        System.out.println("- 'help': Show this help message.");
        System.out.println("- 'exit': Exit the game.");
        System.out.println("- 'inventory', 'inv', or 'invent': Show your inventory.");
        System.out.println("- 'health': Show your current health status.");
        System.out.println("- 'take <item>': Take an item from the room.");
        System.out.println("- 'drop <item>': Drop an item from your inventory into the room.");
        System.out.println("- 'eat <food>': Eat a food item from your inventory.");
        System.out.println("- 'attack': Attack the enemy in the room.");
        System.out.println("equip + weapon name - to equip weapon");
        System.out.println("- Navigate using: north, south, east, west \nor their abbreviations n, s, e, w.");
        System.out.println("------------------\n");
    }
}
