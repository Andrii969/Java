public class Player_Main {

    public static void main(String[] args) {

        Player_Enhanced player = new Player_Enhanced("Tim");
        System.out.println("Remaining health = " + player.healthRemaining());

//        Player player = new Player();
//        player.name = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println(String.format("Remaining health = %d", player.healthRemaining()));
//        player.health = 200;
//        System.out.println(String.format("Remaining health = %d", player.healthRemaining()));
//        player.loseHealth(201);
//        System.out.println(String.format("Remaining health = %d", player.healthRemaining()));
    }
}
