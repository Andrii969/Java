package genericsPart3_1;

public class Main {

    public static void main(String[] args) {

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

        // // // // // // // // // // // // // // // // // //
//        Team<String> adelaide = new Team<>("Adelaide Storm"); // Type parameter 'java.lang.String' is not within its bound;
//                                                                        // should implement 'genericsPart3_1.Player'
//
//        var canberra = new Team<String>("Canberra Heat"); // Type parameter 'java.lang.String' is not within its bound;
//                                                                    // should implement 'genericsPart3_1.Player'
//
//        Team<Integer> melbourneVB = new Team<>("Melbourne Vipers"); // Type parameter 'java.lang.Integer' is not within its bound;
//                                                                                // should implement 'genericsPart3_1.Player'
        // // // // // // // // // // // // // // // // // //



    }

    public static void scoreResult(Team team1, int t1_score, // the overloaded method
                                   Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score); // call setScore on the first team and get the message from that
        team2.setScore(t2_score, t1_score); // set the score on the second team, but ignore that message because we're
        // referring to the first team's message in our final output.
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
