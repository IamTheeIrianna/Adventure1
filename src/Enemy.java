public class Enemy {

    private final String enemyName;
    private int health;
    private Weapon weapon;

    public Enemy(String name, int health, Weapon weapon) {
        this.enemyName = name;
        this.health = health;
        this.weapon = weapon;

    }
    public String getEnemyName() {
        return enemyName;
    }

    public int getHealth() {
        return health;
    }

    public void attack(Player player) {
        int attackDamage = weapon.getDamage();
        player.decreaseHealth(attackDamage);
    }

    public void hit(int damage) {
        health -= damage; // Reduce enemy's health by damage taken
        System.out.println(enemyName + " has taken  " + damage + "  in damage");

        if (health <= 0) {
            System.out.println(enemyName + " has been absolved");
        }
    }
}
