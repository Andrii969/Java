public class Player_Enhanced {

    private String name;
    private int health;
    private String weapon;

    public Player_Enhanced(String name) {
        this(name, 100, "Sword");
//        this.name = name;
    }

    public Player_Enhanced(String name, int health, String weapon) {
        this.name = name;
        if (health <= 0) {
            this.health = 1;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth (int damage) {
        this.health -= damage;
        if (this.health < 0) {
            System.out.println("Player knocked out of the game");
        }
    }

    public int healthRemaining() {
        return health;
    }

    public void restoreHealth(int extraHealth) {
        health += extraHealth;
        if (health > 100) {
            System.out.println("Player restored to 100%");
            health = 100;
        }
    }

}
