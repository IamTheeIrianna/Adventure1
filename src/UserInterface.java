import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }

    public void start() {
        System.out.println("\nWelcome to the adventure game!");
        System.out.println("In this game you will be navigating through 9 different realms");
        System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east  \n- south \n- west.");
        System.out.println("Abbreviations:" + "\n[" + "n,e,s, w" + "]");
        System.out.println("- 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("\n Enter [Start] to start the game.");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Thank you for playing!");
                break;
            } else if (command.equals("start")) {
                System.out.println(adventure.getCurrentRoomDescription());
                printRoomItems();
            } else if (command.equals("help")) {
                adventure.printHelp();
            } else if (command.equals("look")) {
                System.out.println(adventure.getCurrentRoomDescription());
                printRoomItems();
            } else if (command.equals("north") || command.equals("n")) {
                adventure.movePlayer("north");
            } else if (command.equals("east") || command.equals("e")) {
                adventure.movePlayer("east");
            } else if (command.equals("south") || command.equals("s")) {
                adventure.movePlayer("south");
            } else if (command.equals("west") || command.equals("w")) {
                adventure.movePlayer("west");
            } else if (command.equals("inventory") || command.equals("inv") || command.equals("invent")) {
                printInventory();
            } else if (command.startsWith("take ")) {
                adventure.takeItem(command.substring(5));
            } else if (command.startsWith("drop ")) {
                adventure.dropItem(command.substring(5));
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }

    private void printRoomItems() {
        System.out.println("Current room items:");
        for (Item item : adventure.getCurrentRoomItems()) {
            System.out.println("- " + item.getLongName());
        }
    }

    private void printInventory() {
        System.out.println("Your current inventory:");
        for (Item item : adventure.getPlayerInventory()) {
            System.out.println("- " + item.getLongName());
        }
    }

    public void printHelp() {
        System.out.println("Available commands:");
        System.out.println("start - Begin the game");
        System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east  \n- west.");
        System.out.println("\nAbbreviations:" + "\n[" + "n,e,s, w" + "]");
        System.out.println("\n- 'inventory' or 'inv' or 'invent' to see your inventory.");
        System.out.println("\n- 'take [item]' to take an item.");
        System.out.println("\n- 'drop [item]' to drop an item.");
        System.out.println("\n- 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("\n Enter [Start] to start the game.");
    }
}
