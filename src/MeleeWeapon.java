public class MeleeWeapon extends Weapon {
    private int damage;



    public MeleeWeapon(String name, String shortName, int damage) {
        super(name, shortName);
        this.damage = damage;

    }
    @Override
    public int remainingUses() {
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean canUse() {
        return true;

    }
    @Override
    public int getRange() {
        return 1; // Melee weapons typically have a range of 1
    }

    @Override
    public int getDamage() {
        return damage;
    }
    @Override
    public void use() {
        System.out.println("you have now more ammunition in" + getshortName() + "!" + damage);
    }
}
