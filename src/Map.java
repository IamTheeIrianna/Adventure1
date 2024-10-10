public class Map {

    private Room theLine, theShadow, theDream, time, industrialChaos, theFall, digitalFrontier, ageOfEnlightenment, theCosmicAge;

    public Map() {
        createRooms();
        connectRooms();
        addItemsToRooms();
        addEnemiesToRooms();
    }
    //---------------------------------------------
//room creation
    private void createRooms() {
      theLine = new Room("\nThe line of existence", "A dark space,a sky surrounded by endless reflections & whispers of a past. \nAhead of you is nothing but an infinite luminous line");
      theShadow = new Room("\nThe dimension of shadows", "You are in the DOS dimension. \nA place, in the dark, where light and dark dance in an eternal struggle. \nluminous lines begin to attatch, \nforming luminous floating geometric shapes");
      theDream = new Room("\nThe dream tree", "Particles of light, in the dark, \nhave multiplied into a dark luminous tree dimensional forest");
      time = new Room("\nTime", "A fluid landscape where past, present, and future intertwine. \nHere, few have escaped. \nThe only escape is to travel through or to travel backwards into the macrocosmos.");
      industrialChaos = new Room("\nThe dimension of chaos", "An unpredictable realm where order is a fleeting concept. \nA smoke-filled landscape dominated by machinery where progress \ncomes at a cost, changing nature as we know it.");
      theFall = new Room("\nThe fall", "A field of tragedies, overpopulated by universes that hold infectious particles within their microcosm");
      ageOfEnlightenment = new Room("\nThe Age of enlightenment", "Here, in the new world, as above, so below. \nA landscape filled with libraries and gardens, knowledge reinvents the wheel. ");
      digitalFrontier = new Room("\nThe Digital Frontier", "An expansive digital landscape filled with neon lights, \ncode streams, and virtual constructs.");
      theCosmicAge = new Room("\nThe Cosmic age", "The dimension of emotions. \nAn ethereal realm where emotion manifests as tangible forces. \nFilled with stars, nebulae, and cosmic phenomena,\nwhere time bends and reality shifts.");
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
        theDream.addItem(new Item(" ", " "));
        ageOfEnlightenment.addItem(new Item(" ", " "));

        theLine.addItem(new Item("a shiny brass lamp", "lamp"));
        theLine.addItem(new MeleeWeapon("Rusty Sword", "sword", 5));

        theShadow.addItem(new Food("a healing potion", "potion", 20));
        theShadow.addItem(new RangedWeapon("Bow and Arrow", "bow", 5, 10));
        theShadow.addItem(new Item("a shadow cloak", "cloak"));

    }
    private void addEnemiesToRooms() {
        MeleeWeapon capitalism = new MeleeWeapon("capitalism", "capital" , 10);
       time.addEnemy(new Enemy("coorporations", 100, capitalism));

        RangedWeapon isolation = new RangedWeapon("Isolation", "isolation", 5, 5);
        theLine.addEnemy(new Enemy("The void",80, isolation));



        //--------------------------------------------- add more items to room if needed
    }
    public void attack(String enemy){

    }
    //---------------------------------------------
    public Room getStartingRoom() {
        return theLine; // Starting point for the player
    }
}
