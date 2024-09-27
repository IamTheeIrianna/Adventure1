import java.util.Scanner;

public class Adventure {
    private Room currentRoom;

    public Adventure() {
        createRooms();
    }

    public void startGame() {
        System.out.println("\nWelcome to the adventure game!");
        System.out.println("In this game you will be navigating through 9 different relms");
        System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east  \n- south \n- west.");
        System.out.println("Abreviations:" + "\n[" + "n,e,s, w" + "]" );
        System.out.println("- 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("\n Enter [Start] to start the game.");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (command.equals("start")) {
                System.out.println(currentRoom.getDescription());
            } else if (command.equals("help")) {
                printHelp();
            } else if (command.equals("look")) {
                System.out.println(currentRoom.getDescription());
            } else if (command.startsWith("go ")) {
                move(command.substring(3));
            } else if (command.equals("north") || command.equals("n")) {
                move("north");
            } else if (command.equals("east") || command.equals("e")) {
                move("east");
            } else if (command.equals("south") || command.equals("s")) {
                move("south");
            } else if (command.equals("west") || command.equals("w")) {
                move("west");
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }

    private void createRooms() {
        Room room1 = new Room("Room 1", "Temporary Blank room ");
        Room room2 = new Room("Room 2", "Temporary Blank room.");
        Room room3 = new Room("Room 3",  "Temporary Blank room.");
        Room room4 = new Room("Room 4", "Temporary Blank room.");
        Room room5 = new Room("Room 5",  "Temporary Blank room.");
        Room room6 = new Room("Room 6",  "Temporary Blank room.");
        Room room7 = new Room("Room 7", "Y Temporary Blank room.");
        Room room8 = new Room("Room 8", "Temporary Blank room.");
        Room room9 = new Room("Room 9", "Temporary Blank room.");

        //setters
        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setWest(room8);

        currentRoom = room1;
    }

    private void move(String direction) {
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
            System.out.println("You moved to " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        } else {
            System.out.println("The path you have chosen is unavailable");
        }
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("start - Begin the game");
        System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east  \n- west.");
        System.out.println("\nAbreviations:" + "\n[" + "n,e,s, w" + "]" );
        System.out.println("\n- 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("\n Enter [Start] to start the game.");

    }
}
