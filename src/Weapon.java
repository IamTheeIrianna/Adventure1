public abstract class Weapon extends Item {

    public Weapon(String longName, String shortName) {
        super(longName, shortName);
    }
    public abstract int getDamage();
    public abstract int remainingUses();
    public abstract boolean canUse();
    public abstract void use();
}
