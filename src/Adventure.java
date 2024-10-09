import java.util.ArrayList;

public class Adventure {
    private Map theCircle;
    private Player player;

    private UserInterface ui;


    public Adventure() {
        theCircle = new Map();
        Room startingRoom = theCircle.getStartingRoom();
        player = new Player(startingRoom);
        ui = new UserInterface(this);
    }

    public void startGame() {
        ui.start();
    }

    public void movePlayer(String direction) {
        player.move(direction);
    }

    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getDescription();
    }

    public ArrayList<Item> getCurrentRoomItems() {
        return player.getCurrentRoom().getItems();
    }

    public ArrayList<Item> getPlayerInventory() {
        return player.getInventory();
    }

    public void takeItem(String shortName) {
        player.takeItem(shortName);
    }

    public void dropItem(String shortName) {
        player.dropItem(shortName);
    }

    public void printHelp() {
        ui.printHelp();
    }
}
