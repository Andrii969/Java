package genericsPart2;

public class Main {

    public static void main(String[] args) {

        BaseballTeam teamA1 = new BaseballTeam("Team A");
        BaseballTeam teamB1 = new BaseballTeam("Team B");
        scoreResult(teamA1, 3, teamB1, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        teamA1.addTeamMember(harper);
        teamA1.addTeamMember(marsh);
        teamA1.listTeamMembers();
        System.out.println("-".repeat(30));

        // // // // // // // // // // // // // // // // // // // //

        SportsTeam teamA = new SportsTeam("Team A");
        SportsTeam teamB = new SportsTeam("Team B");
        scoreResult(teamA, 3, teamB, 5);

        var harpeti = new FootballPlayer("B Harpeti", "Right Fielder");
        var marti = new FootballPlayer("B Marti", "Right Fielder");
        var guthrie = new BaseballPlayer("D Guthrie", "Right Fielder");

        teamA.addTeamMember(harpeti);
        teamA.addTeamMember(marti);
        teamA.addTeamMember(guthrie); // !!!!! here is a problem, I can add the BaseballPlayer to the SportsTeam teamA !!!!!
        teamA.listTeamMembers();
        System.out.println("-".repeat(30));
    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score); // call setScore on the first team and get the message from that
        team2.setScore(t2_score, t1_score); // set the score on the second team, but ignore that message because we're
        // referring to the first team's message in our final output.
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    // // // // // // // // // // // // // // // // // // // // // // // // //

    public static void scoreResult(SportsTeam team1, int t1_score, // the overloaded method
                                   SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score); // call setScore on the first team and get the message from that
        team2.setScore(t2_score, t1_score); // set the score on the second team, but ignore that message because we're
        // referring to the first team's message in our final output.
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
