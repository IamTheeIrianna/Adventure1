public class Item {
    private String name;
    private String shortName;


    public Item(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name; }

    public String getshortName() {
        return shortName; // Getter for short name
    }
}
