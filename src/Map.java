public class Map {
    private Room[] rooms;

    public Map() {
        rooms = new Room[9];
        createRooms();
        connectRooms();
        addItemsToRooms();
        addEnemiesToRooms();
    }

    private void createRooms() {
        rooms[0] = new Room("\nThe line of existence", "A dark space,a sky surrounded by endless reflections & whispers of a past. \nAhead of you is nothing but an infinite luminous line");
        rooms[1] = new Room("\nThe dimension of shadows", "You are in the DOS dimension. \nA place, in the dark, where light and dark dance in an eternal struggle. \nluminous lines begin to attatch, \nforming luminous floating geometric shapes");
        rooms[2] = new Room("\nThe dream tree", "Particles of light, in the dark, \nhave multiplied into a dark luminous tree dimensional forest");
        rooms[3] = new Room("\nTime", "A fluid landscape where past, present, and future intertwine. \nHere, few have escaped. \nThe only escape is to travel through or to travel backwards into the macrocosmos.");
        rooms[4] = new Room("\nThe dimension of chaos", "An unpredictable realm where order is a fleeting concept. \nA smoke-filled landscape dominated by machinery where progress \ncomes at a cost, changing nature as we know it.");
        rooms[5] = new Room("\nThe fall", "A field of tragedies, overpopulated by universes that hold infectious particles within their microcosm");
        rooms[6] = new Room("\nThe Age of enlightenment", "Here, in the new world, as above, so below. \nA landscape filled with libraries and gardens, knowledge reinvents the wheel. ");
        rooms[7] = new Room("\nThe Digital Frontier", "An expansive digital landscape filled with neon lights, \ncode streams, and virtual constructs.");
        rooms[8] = new Room("\nThe Cosmic age", "The dimension of emotions. \nAn ethereal realm where emotion manifests as tangible forces. \nFilled with stars, nebulae, and cosmic phenomena,\nwhere time bends and reality shifts.");
    }

    private void connectRooms() {
        rooms[0].setEast(rooms[1]);
        rooms[0].setSouth(rooms[3]);

        rooms[1].setWest(rooms[0]);
        rooms[1].setEast(rooms[2]);

        rooms[2].setWest(rooms[1]);
        rooms[2].setSouth(rooms[5]);

        rooms[3].setNorth(rooms[0]);
        rooms[3].setSouth(rooms[7]);

        rooms[4].setSouth(rooms[6]);

        rooms[5].setNorth(rooms[2]);
        rooms[5].setSouth(rooms[8]);

        rooms[7].setNorth(rooms[3]);
        rooms[7].setEast(rooms[6]);

        rooms[6].setNorth(rooms[4]);
        rooms[6].setWest(rooms[7]);
        rooms[6].setEast(rooms[8]);

        rooms[8].setNorth(rooms[5]);
        rooms[8].setWest(rooms[6]);
    }

    private void addItemsToRooms() {

        //miscellaneous objects (string name, string short name)
        rooms[0].addItem(new Item("luminous torch", "torch"));
        rooms[1].addItem(new Item("Shadow cloak", "cloak"));
        rooms[2].addItem(new Item("Dream Catcher", "dream"));
        rooms[3].addItem(new Item("Hour glass", "glass"));
        rooms[4].addItem(new Item("Chains of woe", "Chains"));
        rooms[5].addItem(new Item("Bird Beak Mask", "Mask"));
        rooms[6].addItem(new Item("The emerald tablet", "tablet"));
        rooms[7].addItem(new Item("Code fragment", "Code"));
        rooms[8].addItem(new Item("XTC resin", "XTC"));

        //RangedWeapon (string name, string short name, int damage,int range ,int uses)
        rooms[0].addItem(new RangedWeapon("Ray of light", "lightning", 10, 10, 3));
        rooms[2].addItem(new RangedWeapon("Lucid dream control", "lucid", 20, 10, 3));
        rooms[6].addItem(new RangedWeapon("Sand scripts", "scripts", 15, 5, 3));

        // melee weapon (string name, string short name, int damage)
        rooms[0].addItem(new MeleeWeapon("ethereal blade", "blade", 20));
        rooms[3].addItem(new MeleeWeapon("Death", "Death", 50));
        rooms[4].addItem(new MeleeWeapon("Unity blade", "Unity", 30));
        rooms[5].addItem(new MeleeWeapon("Leech infused scalpel", "scalpel", 25));

        //Food (string name, string short name, int health points)
        rooms[0].addItem(new Food("mountain leaves", "leaves", 10));
        rooms[1].addItem(new Food("Dark nectar", "nectar", -10));
        rooms[2].addItem(new Food("Dream fruit", "fruit", 5));
        rooms[3].addItem(new Food("Ayahuasca potion", "potion", 50));
        rooms[4].addItem(new Food("Breadcrumbs of woe", "Breadcrumbs", -50));
        rooms[5].addItem(new Food("Four Thieves Vinegar:", "vinegar", 10));
        rooms[6].addItem(new Food("Apple of knowledge", "Apple", 25));
        rooms[7].addItem(new Food("Electrolyte bytes", "bytes", 15));
        rooms[8].addItem(new Food("Cosmic fruit", "fruit", 100));


    }

    private void addEnemiesToRooms() {
        // weapon subclass , weapon object name, new instance of weapon subclass (string name, string short name, int damage, int range, int uses)
        RangedWeapon isolation = new RangedWeapon("Ray of light", "lightning", 10, 30, 5);

        // enemy class, enemy object name, new instance of enemy class (string name, int health, weapon subclass)
        Enemy theVoid = new Enemy("Phantom Archer", 5, isolation);
// which room enemy is in, add enemy to room (enemy name)
        rooms[0].addEnemy(theVoid);
//---------------------
        Weapon enemyWeapon = new MeleeWeapon("Shadow Blade", "S blade", 5);
        Enemy theShadow = new Enemy("The Void", 10, enemyWeapon);
        rooms[1].addEnemy(theShadow);
//--------------------------
        Weapon blade = new MeleeWeapon("Shadow Blade", "S blade", 5);
        Enemy sleepParalysis = new Enemy("The Void", 10, blade);
        rooms[2].addEnemy(sleepParalysis);

    }

    public Room getRoom(int index) {
        return rooms[index];
    }
}