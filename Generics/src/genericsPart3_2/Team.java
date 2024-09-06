package genericsPart3_2;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player, S> { // T, S, U, V
    // Note that for this second type parameter (S), I didn't include an upper bound, so I
    //could pass a simple string, or another instance of any class, to another team.

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();            // it's best practice to use the interface type for the
                                                                // reference variable. In other words, use List and not ArrayList
                                                                // on the left side of the assignment operator.
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation; // S can be anything

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {
        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {
       System.out.print(teamName + " Roster:");
       System.out.println((affiliation == null ? "" : " AFFILIATION: " + affiliation));
       for (T t : teamMembers) {
           System.out.println(t.name()); // !!!! CAN GET PLAYER'S NAME, AS WE EXTEND Player interface, which has this field !!!!
       }
    }

    public int ranking() {
        return totalLosses * 2 + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
