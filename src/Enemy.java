public class Enemy {
    private String name;
    private int health;
    private Weapon weapon;
    //---------------------------------------------
    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }
    //---------------------------------------------
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    //---------------------------------------------
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }
    public void attack(Player player) {
        System.out.println(name + " you've been attacked with a " + weapon.getLongName() + "!");
        player.takeDamage(weapon.getDamage());
    }
}
