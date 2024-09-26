import java.util.Scanner;

public class Adventure {
    private Room currentRoom;
    private Room
    room1,
    room2,
    room3,
    room4,
    room5,
    room6,
    room7,
    room8,
    room9;

public Adventure() {
        createRooms();
        welcomeUser();
        startGame();
    }
//create rooms with random temporary description

    private void createRooms() {
                room1 = new Room ("");
                room2 = new Room("green");
                room3 = new Room("red");
                room4 = new Room("yellow");
                room5 = new Room("purple");
                room6 = new Room("orange");
                room7 = new Room("black");
                room8 = new Room("pink");
                room9 = new Room("...");

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

private void welcomeUser() {
    System.out.println("Welcome to the adventure game!");
    System.out.println("\nIn this game you will be navigating through 9 different relms");
    System.out.println("\nUse the following commands to navigate between rooms: \nnorth, south, east and west.");
    System.out.println("\nShorter abbreviations may also be used, such as: \nn,e,s and w");
    System.out.println("\nEnter 'look around' to get a description of your current location. \n Insert 'help' for instructions. \n Insert 'exit' to leave the game.");
    System.out.println("\nplease enter 'play' to start the game.");
    System.out.println("\nEnter 'go' to view game instructions and to start playing");

    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("> ");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("go")) {
            showInstructions();
            break;

        } else {
            System.out.println("Enter 'go' to continue");
        }
    }
    scanner.close();
}

    private void showInstructions() {
        System.out.println("\nAvailable commands: ");
        System.out.println(" To navigate through the rooms you can use these following commands:");
        System.out.println("enter the follwing commands to navigate to the retrospective door: north, east ,  south or west");
        System.out.println("You may also use the shorter abreviated versions: n, e, s, w ");
        System.out.println("Enter 'look' to get a description of the current room");
        System.out.println("Enter 'help' for command overview ");
        System.out.println("to exit game enter 'exit'");
        System.out.println("\n Type 'play' to start the adventure game!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("play")) {
                startGame();
                break;

            } else {
                System.out.println("Enter 'play' to start the game.");
            }
        }
        scanner.close();
    }

    private void startGame() {
Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nyou have now arrived at " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
            System.out.println("> ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("thank you for playing!");
                break;

            } else if (command.startsWith("look")) {
                System.out.println(currentRoom.getDescription());
            } else if (command.startsWith("go ")) {
                move(command.substring(3));

            } else if (command.equals("north") || command.startsWith("n")) {
                move("north");

            } else if (command.equals("south") || command.startsWith("s")) {
                move("south");

            } else if (command.equals("west") || command.startsWith("w")) {
                move("west");

            } else if (command.equals("east") || command.startsWith("e")) {
                move("east");

            } else if (command.equals("help")) {
                showInstructions();

            } else {
                System.out.println("Invalid command. PLease try again or enter 'help' for command list.");
            }
        }
        scanner.close();
    }


    private void lookAround() {
        System.out.println(currentRoom.getDescription());
    }

    private void move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case "north":
            case "n" :
                nextRoom = currentRoom.getNorth();
                System.out.println("heading north");
                break;

            case "east":
            case "e":
                nextRoom = currentRoom.getEast();
                System.out.println("heading east");
                break;

            case "south":
            case "s" :
                System.out.println("heading south");
                nextRoom = currentRoom.getSouth();
                break;

            case "west":
            case "w":
                System.out.println("heading west");
                nextRoom = currentRoom.getWest();
                break;

            default:
                System.out.println("this path cannot be accessed. Enter 'help' for command list ");
                return;
        }

        if(nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("heading towards " + currentRoom.getName());
        } else {
            System.out.println("The chosen direction is unavailable");
        }
    }
    private void showHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("- go north / n");
        System.out.println("- go east / e");
        System.out.println("- go south / s");
        System.out.println("- go west / w");
        System.out.println("- look");
        System.out.println("- help");
        System.out.println("- exit");
    }
}



