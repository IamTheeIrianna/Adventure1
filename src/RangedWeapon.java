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
        return uses;
    }
    @Override
    public boolean canUse(){
        return uses > 0;
    }
    public void use() {
        if (uses > 0) uses--;
        else System.out.println("This weapon can no longer be used");
    }
    public void use(){
        if(canUse()) {
            uses--;
            System.out.println("fire your " + getLongName() + "!");
        } else {
            System.out.println("you have now more ammunition");
        }
    }
}
