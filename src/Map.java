public class Map {
    private Room startingRoom;

    public Map() {
        createRooms();
    }

    public void createRooms() {
        Room theCityOfShadows = new Room("The city of shadows", "Here you are just a silhouette \nmade from particles of light");
        Room theWickedGate = new Room("The Wicked Gate", "In this relm you will find the cousins judgment and critisism");
        Room theSloughOfDespair = new Room("The Slough of despair", "Surrounded by your old conciousness");
        Room theMountainOfSorrow = new Room("The mountain of sorrow", "Life begins on the other side");
        Room thePalace = new Room("The Palace", "Your conciousness has been reset but you remain a silhouette");
        Room theValleyOfHumiliation = new Room("The valley of Humiliation", "In this realm you will find humiliation");
        Room celestialCity = new Room("Celestial city", "Where thoughts and the physical self seize to exist. \nOnly feelings remain");
        Room vanityFair = new Room("Vanity fair", "Cousins with the valley of humiliation");
        Room theValleyOfTheUnknown = new Room("The valley of the unknown", " \nWhatever you imagine the new world to be.");

        // Setters
        theCityOfShadows.setEast(theWickedGate);
        theCityOfShadows.setSouth(theMountainOfSorrow);

        theWickedGate.setWest(theCityOfShadows);
        theWickedGate.setEast(theSloughOfDespair);

        theSloughOfDespair.setWest(theWickedGate);
        theSloughOfDespair.setSouth(theValleyOfHumiliation);

        theMountainOfSorrow.setNorth(theCityOfShadows);
        theMountainOfSorrow.setSouth(celestialCity);

        thePalace.setSouth(vanityFair);

        theValleyOfHumiliation.setNorth(theSloughOfDespair);
        theValleyOfHumiliation.setSouth(theValleyOfTheUnknown);

        celestialCity.setNorth(theMountainOfSorrow);
        celestialCity.setEast(vanityFair);

        vanityFair.setNorth(thePalace);
        vanityFair.setEast(theValleyOfTheUnknown);
        vanityFair.setWest(celestialCity);

        theValleyOfTheUnknown.setNorth(theValleyOfHumiliation);
        theValleyOfTheUnknown.setWest(vanityFair);

        // Add items to rooms
        theCityOfShadows.addItem(new Item("feelings from the self", "Feelings"));
        theWickedGate.addItem(new Item("Self accept", "Conformity"));
        theSloughOfDespair.addItem(new Item("to be discovered", "dreams"));
        theMountainOfSorrow.addItem(new Item("cross the mountain", "return to comfort"));
        thePalace.addItem(new Item("wisdom", "knowledge"));
        theValleyOfHumiliation.addItem(new Item("Humility", "Wrath"));
        celestialCity.addItem(new Item("soul", "physical self"));
        vanityFair.addItem(new Item("ego", "blindness"));
        theValleyOfTheUnknown.addItem(new Item("currency", "Eternal supply of food"));

        startingRoom = theCityOfShadows;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }
}
