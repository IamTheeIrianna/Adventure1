public class Map {

    private Room theLine, theStone, theBronze, time, ironDome, theFall, digitalFrontier, ageOfEnlightenment, theCosmicAge;

    public Map() {
        createRooms();
        connectRooms();
        addItemsToRooms();
    }
    //---------------------------------------------
//room creation
    private void createRooms() {
      theLine = new Room("The line of existence", "A dark space with nothing but an infinite luminous line");
      theStone = new Room("The age of the stone", "You are in the DOS dimension. A place in the dark where luminous lines begin to attatch, \nforming luminous floating geometric shapes");
      theBronze = new Room("Age of bronze", "Particles of light, in the dark, have multiplied into a dark luminous tree dimensional forest ");
      time = new Room("Time", "Here, few have escaped. The only escape is to travel through or demise.");
      ironDome = new Room("The Iron Dome", "A smoke-filled landscape dominated by machinery where progress \ncomes at a cost, changing nature as we know it.");
      theFall = new Room("The fall", "A field of tragedies, overpopulated by universes that hold infectious particles within their microcosm");
      ageOfEnlightenment = new Room("The Age of enlightenment", "Here, in the new world, as above, so below. A landscape filled with libraries and gardens, knowledge reinvents the wheel.  ");
      digitalFrontier = new Room("The Digital Frontier", "An expansive digital landscape filled with neon lights, \ncode streams, and virtual constructs.");
      theCosmicAge = new Room("The Cosmic age", "An ethereal realm filled with stars, nebulae, and cosmic phenomena, \nwhere time bends and reality shifts.");
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
        time.setSouth(digitalFrontier);

        ironDome.setSouth(ageOfEnlightenment);

        theFall.setNorth(theBronze);
        theFall.setSouth(theCosmicAge);

        digitalFrontier.setNorth(time);
        digitalFrontier.setEast(ageOfEnlightenment);

        ageOfEnlightenment.setNorth(ironDome);
        ageOfEnlightenment.setWest(digitalFrontier);
        ageOfEnlightenment.setEast(theCosmicAge);

        theCosmicAge.setNorth(theFall);
        theCosmicAge.setWest(ageOfEnlightenment);

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
