package genericsPart3_2;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();            // it's best practice to use the interface type for the
                                                                // reference variable. In other words, use List and not ArrayList
                                                                // on the left side of the assignment operator.
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(T t) {
        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {
       System.out.println(teamName + " Roster:");
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
