import java.util.Scanner;

public class Adventure {
    private Room currentRoom;
    //room declaration
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

//room creator with random temporary description
    private void createRooms() {
                room1 = new Room(" BLANK 1");
                room2 = new Room("BLANK 2");
                room3 = new Room("BLANK 3");
                room4 = new Room("BLANK 4");
                room5 = new Room("BLANK 5");
                room6 = new Room("BLANK 6");
                room7 = new Room("BLANK 7");
                room8 = new Room("BLANK 8");
                room9 = new Room("BLANK 9");

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
    System.out.println("\nWelcome to the adventure game!");
    System.out.println("In this game you will be navigating through 9 different relms");
    System.out.println("\nUse the following commands to navigate between rooms:\n- north \n- east  \n- west.");
    System.out.println("\nAbreviations:" + "\n[" + "n,e,s, w" + "]" );
    System.out.println("\n- 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
    System.out.println("\n Enter [play] to start the game.");
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.print("> ");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("play")) {
            startGame();
            break;
        }
    }
    scanner.close();
}

    private void showInstructions() {
        System.out.println("\ncommands: ");
        System.out.println("\nNavigation: \n- north \n- east  \n- west.");
        System.out.println("Abreviations:" + "\n[" + "n,e,s, w" + "]" );
        System.out.println("\n- 'look around' for placement description. \n- 'help' for instructions. \n- 'exit' to leave the game.");
        System.out.println("\n Enter 'play' to start the game.");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("play")) {
                startGame();
                break;

            }
        }
        scanner.close();
    }

    private void startGame() {
Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nyou have now arrived at " + currentRoom.getName());
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
                break;

            case "east":
            case "e":
                nextRoom = currentRoom.getEast();
                break;

            case "south":
            case "s" :
                nextRoom = currentRoom.getSouth();
                break;

            case "west":
            case "w":
                nextRoom = currentRoom.getWest();
                break;

        }

    }

}



