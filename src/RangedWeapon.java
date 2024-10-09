public class RangedWeapon extends Weapon {

    private int uses;
    private int damage;

    public RangedWeapon(String longName, String shortName, int uses) {
        super(longName, shortName);
        this.uses = uses;
        this.damage = damage;
    }

    @Override
    public int remainingUses() {
        return uses; }

    public void use() {
        if (uses > 0) uses--;
        else System.out.println("No more uses left!");
    }
}
