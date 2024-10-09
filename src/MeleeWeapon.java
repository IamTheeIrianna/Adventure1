public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String longName, String shortName) { super(longName, shortName); }

    @Override
    public int remainingUses() { return Integer.Max; } // Melee weapons can be used indefinitely

    public void use() { /* No action needed for melee weapon usage */ }
}
