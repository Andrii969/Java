package genericsPart3_2;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {

    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>(); // it's best practice to use the interface type for the
                                                                // reference variable. In other words, use List and not ArrayList
                                                                // on the left side of the assignment operator.
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(BaseballPlayer player) {
        if (!teamMembers.contains(player)) { // Since BaseballPlayer is a record, and records come with an implicit equals
                                            // method, this method can test the equality of all the record's attributes.
            teamMembers.add(player);
        }
    }

    public void listTeamMembers() {
       System.out.println(teamName + " Roster:");
       System.out.println(teamMembers);
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
