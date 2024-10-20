
public abstract class Weapon extends Item {

    public Weapon(String name, String shortName) {
        super(name, shortName);
    }
    public abstract int getDamage();
    public abstract int getRange();
    public abstract int remainingUses();
    public abstract boolean canUse();
    public abstract void use();

}
