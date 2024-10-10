public class RangedWeapon extends Weapon {
    private int uses;
    private int damage;

    public RangedWeapon(String longName, String shortName, int uses, int damage) {
        super(longName, shortName);
        this.uses = uses;
        this.damage = damage;
    }
    @Override
    public int remainingUses() {
        return uses;
    }
    @Override
    public boolean canUse() {
        return uses > 0;
    }
    @Override
    public int getDamage() {
    return damage;
    }
    @Override
    public void use () {
        if (canUse()) {
            uses --;
            System.out.println("fire your" + getLongName() + "!");
        } else {
            System.out.println("you have now more ammunition in" + getLongName() + "!");


        }
    }
}
















