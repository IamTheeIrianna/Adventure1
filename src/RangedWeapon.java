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
    public int getDamage() {
    return damage;
    }
    public void use () {
        if (canUse()){
            uses --;
            System.out.println();
        }
    }
}

    @Override
    public boolean canUse(){
        return uses > 0;

    } if(uses > 0) uses--;
     System.out.println("This weapon can no longer be used"); {

    }
    public void use(){

        if(canUse()) {
            uses--;
            System.out.println("fire your " + getLongName() + "!");{

            } else if  (uses > 0) uses--; {
            else System.out.println("This weapon can no longer be used");

        } else {
            System.out.println("you have now more ammunition");
        }
    }
}
