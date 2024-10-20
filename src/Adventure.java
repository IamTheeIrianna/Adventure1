import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
    private Player player;
    private UserInterface ui;

    public Adventure() {
        player = new Player();
        Map map = new Map();
        ui = new UserInterface();
        ui.displayWelcomeMessage();
        player.setCurrentRoom(map.getRoom(0)); // Start in Room 1

    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().toLowerCase();

            if (command.equals("start")) {
                ui.displayRoomDescription(player.getCurrentRoom());
                startGame();

            } else if (command.startsWith("go ")) {
                processCommand(command);
            } else if (command.equals("exit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (command.startsWith("take ")) {
                takeItem(command);
            } else if (command.equals("inventory")) {
                ui.showInventory(player);
            } else {
                System.out.println("Invalid command. Type 'go [direction]', 'take [item]', or 'exit'.");
            }
        }
        scanner.close();
    }

    private void processCommand(String command) {
        switch (command) {
            case "go north":
                moveNorth();
                break;
            case "go south":
                moveSouth();
                break;
            case "go east":
                moveEast();
                break;
            case "go west":
                moveWest();
                break;
            default:
                System.out.println("You cannot go that way.");
        }
    }

    private void moveNorth() {
        Room nextRoom = player.getCurrentRoom().getNorth();
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    private void moveSouth() {
        Room nextRoom = player.getCurrentRoom().getSouth();
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    private void moveEast() {
        Room nextRoom = player.getCurrentRoom().getEast();
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    private void moveWest() {
        Room nextRoom = player.getCurrentRoom().getWest();
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    private void takeItem(String command) {
        String itemName = command.substring(5); // Extract item name from command
        Item item = player.getCurrentRoom().removeItem(itemName);

        if (item != null) {
            player.takeItem(item);
            System.out.println("You took the " + item.getName() + ".");
        } else {
            System.out.println("There is no such item here.");
        }
    }
    //-----------------------------------------------
    private void checkForEnemies() {
        ArrayList<Enemy> enemiesInRoom = player.getCurrentRoom().getEnemies();

        if (!enemiesInRoom.isEmpty()) {
            for (Enemy enemy : enemiesInRoom) {
                encounterEnemy(enemy);
            }
        }
    }
    //-------------------------------------------------
    private void encounterEnemy(Enemy enemy) {
        System.out.println("You encounter a " + enemy.getEnemyName() + "!");

        while (enemy.getHealth() > 0 && player.getHealth() > 0) {
            enemy.hit(10);
            if (enemy.getHealth() > 0) {
                enemy.attack(player);
            }
        }
    }

}
