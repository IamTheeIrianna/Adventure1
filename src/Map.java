public class Map {

    private Room theLine, theStone, theBronze, time, ironDome, theFall, eraOfEval, renaissance,theEntrapment;

    public Map() {
        createRooms();
        connectRooms();
        addItemsToRooms();
    }
    //---------------------------------------------
//room creation
    private void createRooms() {
      theLine = new Room("The line of existence", "In the dark with nothing but an infinite luminous line");
      theStone = new Room("The age of the stone", "You are in the DOS dimension. A place in the dark where luminous lines begin to attatch, \nforming luminous floating geometric shapes");
      theBronze = new Room("Age of bronze", "The particles of light have multiplied into a dark luminous tree dimensional forest ");
      time = new Room("Room 4", "You are on a spaceship.");
      ironDome = new Room("Room 5", "You are in the central chamber.");
      theFall = new Room("Room 6", "You are in a tranquil garden.");
      eraOfEval = new Room("Room 7", "You are in a bustling market.");
      renaissance = new Room("Room 8", "You are on a high mountain.");
      theEntrapment = new Room("Room 9", "You are in an ancient temple.");
    }
    //---------------------------------------------
    //room location setters
    private void connectRooms() {

        //map setting
        theLine.setEast(theStone);
        theLine.setSouth(time);

        theStone.setWest(theLine);
        theStone.setEast(theBronze);

        theBronze.setWest(theStone);
        theBronze.setSouth(theFall);

        time.setNorth(theLine);
        time.setSouth(eraOfEval);

        ironDome.setSouth(renaissance);

        theFall.setNorth(theBronze);
        theFall.setSouth(theEntrapment);

        eraOfEval.setNorth(time);
        eraOfEval.setEast(renaissance);

        renaissance.setNorth(ironDome);
        renaissance.setWest(eraOfEval);
        renaissance.setEast(theEntrapment);

        theEntrapment.setNorth(theFall);
        theEntrapment.setWest(renaissance);

        //---------------------------------------------
    }
    //---------------------------------------------
    private void addItemsToRooms() {
        // Add items to rooms as per requirements
        theLine.addItem(new Food("a shiny brass lamp", "lamp", 0));
        theLine.addItem(new MeleeWeapon("Rusty Sword", "sword", 5));

        theStone.addItem(new Food("a healing potion", "potion", 20));
        theStone.addItem(new RangedWeapon("Bow and Arrow", "bow", 5,10));

        //--------------------------------------------- add more items to room if needed
    }
    public void attack(String enemy){

    }
    //---------------------------------------------
    public Room getStartingRoom() {
        return theLine; // Starting point for the player
    }
}
