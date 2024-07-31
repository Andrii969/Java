public class Player {

    public String name;
    public int health;
    public String weapon;

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
