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
        // Example: No room to the north of Room 1
        //map setting
        theLine.setEast(theStone); // 'theLine' connects east to 'theStone'
        theLine.setSouth(ironDome); // 'theLine' connects south to 'ironDome'

        theStone.setWest(theLine); // 'theStone' connects west to 'theLine'
        theStone.setEast(theBronze); // 'theStone' connects east to 'theBronze'

        theBronze.setWest(theStone); // 'theBronze' connects west to 'theStone'
        theBronze.setSouth(eraOfEval); // 'theBronze' connects south to 'eraOfEval'

        ironDome.setNorth(theLine); // 'ironDome' connects north to 'theLine'
        ironDome.setSouth(theFall); // 'ironDome' connects south to 'theFall'

        theFall.setSouth(renaissance); // 'theFall' connects south to 'renaissance'

        eraOfEval.setNorth(theBronze); // 'eraOfEval' connects north to 'theBronze'
        eraOfEval.setSouth(theEntrapment); // 'eraOfEval' connects south to 'das'

        theFall.setNorth(ironDome); // 'theFall' connects north to 'ironDome'
        theFall.setEast(renaissance); // 'theFall' connects east to 'renaissance'

        renaissance.setWest(theFall); // 'renaissance' connects west to 'theFall'
        renaissance.setNorth(theFall); // 'renaissance' connects north to 'theFall'

        theEntrapment.setNorth(eraOfEval);

        //---------------------------------------------
    }
    //---------------------------------------------
    private void addItemsToRooms() {
        // Add items to rooms as per requirements
        theLine.addItem(new Food("a shiny brass lamp", "lamp", 0));
        theLine.addItem(new MeleeWeapon("Rusty Sword", "sword"));

        theStone.addItem(new Food("a healing potion", "potion", 20));
        theStone.addItem(new RangedWeapon("Bow and Arrow", "bow", 5));

        //--------------------------------------------- add more items to room if needed
    }
    public void attack(String enemy){

    }
    //---------------------------------------------
    public Room getStartingRoom() {
        return theLine; // Starting point for the player
    }
}
