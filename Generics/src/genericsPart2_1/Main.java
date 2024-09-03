package genericsPart2_1;

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

        SportsTeam teamA2 = new SportsTeam("Team A");
        SportsTeam teamB2 = new SportsTeam("Team B");
        scoreResult(teamA2, 3, teamB2, 5);

        var harpeti = new FootballPlayer("B Harpeti", "Right Fielder");
        var marti = new FootballPlayer("B Marti", "Right Fielder");
        var guthrie = new BaseballPlayer("D Guthrie", "Right Fielder");

        teamA2.addTeamMember(harpeti);
        teamA2.addTeamMember(marti);
        teamA2.addTeamMember(guthrie); // !!!!! here is a problem, I can add the BaseballPlayer to the SportsTeam teamA !!!!!
        teamA2.listTeamMembers();
        System.out.println("-".repeat(30));

        // // // // // // // // // // // // // // // // // // // //

        Team<FootballPlayer> teamA = new Team<>("Team A");
        Team<FootballPlayer> teamB = new Team<>("Team B");
        scoreResult(teamA, 3, teamB, 5);

        var harpen = new FootballPlayer("B Harpen", "Right Fielder");
        var marlo = new FootballPlayer("B Marlo", "Right Fielder");
        var gunter = new BaseballPlayer("D Gunter", "Right Fielder");

        teamA.addTeamMember(harpen);
        teamA.addTeamMember(marlo);
//        teamA.addTeamMember(gunter); // can't add BaseballPlayer to the Team<FootballPlayer>
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

    // // // // // // // // // // // // // // // // // // // // // // // // //

    public static void scoreResult(Team team1, int t1_score, // the overloaded method
                                   Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score); // call setScore on the first team and get the message from that
        team2.setScore(t2_score, t1_score); // set the score on the second team, but ignore that message because we're
        // referring to the first team's message in our final output.
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
