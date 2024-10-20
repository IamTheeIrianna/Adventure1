public class RangedWeapon extends Weapon {
    private int damage;
    private int range;
    private int uses;



    public RangedWeapon(String name, String shortName, int damage, int range, int uses) {
        super(name, shortName);
        this.damage = damage;
        this.range = range;
        this.uses = uses;
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
    public int getRange() {
        return range;
    }
    @Override
    public int getDamage() {
        return damage;
    }
    @Override
    public void use() {
        if (canUse()) {
            uses --;
            System.out.println("fire your" + getName() + "!");
        } else {
            System.out.println("you have now more ammunition in" + getshortName() + "!" + damage);
        }
    }
}
