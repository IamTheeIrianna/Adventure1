public class Map {

    private Room theLine, theShadow, theDream, time, industrialChaos, theFall, digitalFrontier, ageOfEnlightenment, theCosmicAge;

    public Map() {
        createRooms();
        connectRooms();
        addItemsToRooms();
    }
    //---------------------------------------------
//room creation
    private void createRooms() {
      theLine = new Room("The line of existence", "\nA dark space,a sky surrounded by endless reflections & whispers of a past. \nAhead of you is nothing but an infinite luminous line");
      theShadow = new Room("The dimension of shadows", "\nYou are in the DOS dimension. A place, in the dark, where light and dark dance in an eternal struggle. luminous lines begin to attatch, \nforming luminous floating geometric shapes");
      theDream = new Room("The dream tree", "\nParticles of light, in the dark, have multiplied into a dark luminous tree dimensional forest");
      time = new Room("Time", "\nA fluid landscape where past, present, and future intertwine. \nHere, few have escaped. The only escape is to travel through or to travel backwards into the macrocosmos.");
      industrialChaos = new Room("The dimension of chaos", "\nAn unpredictable realm where order is a fleeting concept. A smoke-filled landscape dominated by machinery where progress \ncomes at a cost, changing nature as we know it.");
      theFall = new Room("The fall", "\nA field of tragedies, overpopulated by universes that hold infectious particles within their microcosm");
      ageOfEnlightenment = new Room("The Age of enlightenment", "\nHere, in the new world, as above, so below. A landscape filled with libraries and gardens, knowledge reinvents the wheel. ");
      digitalFrontier = new Room("The Digital Frontier", "\nAn expansive digital landscape filled with neon lights, \ncode streams, and virtual constructs.");
      theCosmicAge = new Room("The Cosmic age", "\nThe dimension of emotions. \nAn ethereal realm where emotion manifests as tangible forces. \nFilled with stars, nebulae, and cosmic phenomena, \nwhere time bends and reality shifts.");
    }
    //---------------------------------------------
    //room location setters
    private void connectRooms() {

        //map setting
        theLine.setEast(theShadow);
        theLine.setSouth(time);

        theShadow.setWest(theLine);
        theShadow.setEast(theDream);

        theDream.setWest(theShadow);
        theDream.setSouth(theFall);

        time.setNorth(theLine);
        time.setSouth(digitalFrontier);

        industrialChaos.setSouth(ageOfEnlightenment);

        theFall.setNorth(theDream);
        theFall.setSouth(theCosmicAge);

        digitalFrontier.setNorth(time);
        digitalFrontier.setEast(ageOfEnlightenment);

        ageOfEnlightenment.setNorth(industrialChaos);
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

        theShadow.addItem(new Food("a healing potion", "potion", 20));
        theShadow.addItem(new RangedWeapon("Bow and Arrow", "bow", 5,10));

        //--------------------------------------------- add more items to room if needed
    }
    public void attack(String enemy){

    }
    //---------------------------------------------
    public Room getStartingRoom() {
        return theLine; // Starting point for the player
    }
}
