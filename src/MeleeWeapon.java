public class MeleeWeapon extends Weapon {
private int damamge;
    public MeleeWeapon(String longName, String shortName, int damage) {
        super(longName, shortName);
        this.damage = damage;
    }

    @Override
    public int remainingUses() {
        return Integer.MAX_VALUE;
    } // Melee weapons can be used indefinitely
@Override
public boolean canUse() {
        return true;
}
@Override
public int getDamage() {
        return damage;
}
    public void use() {

    }
}
