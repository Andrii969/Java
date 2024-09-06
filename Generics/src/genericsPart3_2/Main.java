package genericsPart3_2;

public class Main {

    public static void main(String[] args) {

        Team<FootballPlayer, Affiliation> teamA = new Team<>("Team A");
        Team<FootballPlayer, Affiliation> teamB = new Team<>("Team B");
        scoreResult(teamA, 3, teamB, 5);

        var harpen = new FootballPlayer("B Harpen", "Right Fielder");
        var marlo = new FootballPlayer("B Marlo", "Right Fielder");
        var gunter = new BaseballPlayer("D Gunter", "Right Fielder");

        teamA.addTeamMember(harpen);
        teamA.addTeamMember(marlo);
//        teamA.addTeamMember(gunter); // can't add BaseballPlayer to the Team<FootballPlayer, Affiliation>
        teamA.listTeamMembers();
        System.out.println("-".repeat(30));

        // // // // // // // // // // // // // // // // // // // // //

        Team<VolleyballPlayer, Affiliation> volleyballTeamA = new Team<>("Team A");
        volleyballTeamA.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        Team<VolleyballPlayer, Affiliation> volleyballTeamB = new Team<>("Team B");
        volleyballTeamB.addTeamMember(new VolleyballPlayer("N Sting", "Setter"));
        scoreResult(volleyballTeamA, 3, volleyballTeamB, 5);
        volleyballTeamA.listTeamMembers();
        System.out.println("-".repeat(30));

        // // // // // // // // // // // // // // // // // // // // //

        Team<VolleyballPlayer, Affiliation> volleyballTeamC = new Team<>("Team A",
                new Affiliation("city", "New York", "US"));
        volleyballTeamC.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        volleyballTeamC.listTeamMembers();

        // // // // // // // // // // // // // // // // // // // // //

        Team<VolleyballPlayer, String> volleyballTeamD = new Team<>("Team A","Some Affiliation");
        volleyballTeamD.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        volleyballTeamD.listTeamMembers();



    }

    public static void scoreResult(Team team1, int t1_score, // the overloaded method
                                   Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score); // call setScore on the first team and get the message from that
        team2.setScore(t2_score, t1_score); // set the score on the second team, but ignore that message because we're
        // referring to the first team's message in our final output.
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
