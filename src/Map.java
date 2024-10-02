public class Map {
    private Room startingRoom;

    public Map() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room("Room 1", "Temporary Blank room ");
        Room room2 = new Room("Room 2", "Temporary Blank room.");
        Room room3 = new Room("Room 3", "Temporary Blank room.");
        Room room4 = new Room("Room 4", "Temporary Blank room.");
        Room room5 = new Room("Room 5", "Temporary Blank room.");
        Room room6 = new Room("Room 6", "Temporary Blank room.");
        Room room7 = new Room("Room 7", "Temporary Blank room.");
        Room room8 = new Room("Room 8", "Temporary Blank room.");
        Room room9 = new Room("Room 9", "Temporary Blank room.");

        // Setters
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

        // Add items to rooms
        room1.addItem(new Item("to be discovered", "null"));
        room2.addItem(new Item("to be discovered", "null"));
        room3.addItem(new Item("to be discovered", "null"));
        room4.addItem(new Item("to be discovered", "null"));
        room5.addItem(new Item("to be discovered", "null"));
        room6.addItem(new Item("to be discovered", "null"));
        room7.addItem(new Item("to be discovered", "null"));
        room8.addItem(new Item("to be discovered", "null"));
        room9.addItem(new Item("to be discovered", "null"));

        startingRoom = room1;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }
}
