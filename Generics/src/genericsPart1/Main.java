package genericsPart1;

public class Main {

    public static void main(String[] args) {

        BaseballTeam teamA = new BaseballTeam("Team A");
        BaseballTeam teamB = new BaseballTeam("Team B");
        scoreResult(teamA, 3, teamB, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        teamA.addTeamMember(harper);
        teamA.addTeamMember(marsh);
        teamA.listTeamMembers();


    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score); // call setScore on the first team and get the message from that
        team2.setScore(t2_score, t1_score); // set the score on the second team, but ignore that message because we're
                                            // referring to the first team's message in our final output.
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
