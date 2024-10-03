public class Map {
    private Room startingRoom;

    public Map() {
        createRooms();
    }

    private void createRooms() {
        Room TheCityOfShadows = new Room("The city of shadows", " here you are just a silhouette \nmade from particles of light");
        Room TheWickedGate = new Room("The Wicked Gate", "In this relm you will find the cousins judgment and critisism");
        Room TheSloughOfDespair = new Room("The Slough of despair", "Surrounded by your old conciousness");
        Room TheMountainOfSorrow = new Room("The mountain of sorrow", "Life begins on the other side");
        Room ThePalace = new Room("The Palace", "Your conciousness has been reset but you remain a silhouette");
        Room TheValleyOfHumiliation = new Room("The valley of Humiliation", "In this realm you will find humiliation");
        Room CelestialCity = new Room("Celestial city", "Where thoughts and the physical self seize to exist. \nOnly feelings remain");
        Room VanityFair = new Room("Vanity fair", "Cousins with the valley of humiliation");
        Room TheValleyOfTheUnknown = new Room("The valley of the unknown", " \nWhatever you imagine the new world to be.");

        // Setters
        TheCityOfShadows.setEast(TheWickedGate);
        TheCityOfShadows.setSouth(TheMountainOfSorrow);

        TheWickedGate.setWest(TheCityOfShadows);
        TheWickedGate.setEast(TheSloughOfDespair);

        TheSloughOfDespair.setWest(TheWickedGate);
        TheSloughOfDespair.setSouth(TheValleyOfHumiliation);

        TheMountainOfSorrow.setNorth(TheCityOfShadows);
        TheMountainOfSorrow.setSouth(CelestialCity);

        ThePalace.setSouth(VanityFair);

        TheValleyOfHumiliation.setNorth(TheSloughOfDespair);
        TheValleyOfHumiliation.setSouth(TheValleyOfTheUnknown);

        CelestialCity.setNorth(TheMountainOfSorrow);
        CelestialCity.setEast(VanityFair);

        VanityFair.setNorth(ThePalace);
        VanityFair.setEast(TheValleyOfTheUnknown);
        VanityFair.setWest(CelestialCity);

        TheValleyOfTheUnknown.setNorth(TheValleyOfHumiliation);
        TheValleyOfTheUnknown.setWest(VanityFair);

        // Add items to rooms
        TheCityOfShadows.addItem(new Item("feelings from the self", "thoughts"));
        TheWickedGate.addItem(new Item("Self accept", "Conformity"));
        TheSloughOfDespair.addItem(new Item("to be discovered", "dreams"));
        TheMountainOfSorrow.addItem(new Item("cross the mountain", "return to comfort"));
        ThePalace.addItem(new Item("wisdom", "knowledge"));
        TheValleyOfHumiliation.addItem(new Item("Humility", "Wrath"));
        CelestialCity.addItem(new Item("soul", "physical self"));
        VanityFair.addItem(new Item("ego", "blindness"));
        TheValleyOfTheUnknown.addItem(new Item("currency", "Eternal supply of food"));

        startingRoom = TheCityOfShadows;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }
}
