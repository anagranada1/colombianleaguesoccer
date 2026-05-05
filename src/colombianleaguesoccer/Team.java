package colombianleaguesoccer;

import java.util.List;

public class Team {

    private final TeamStats stats = new TeamStats();
    private String name;
    private int positionTeam;
    private List<Team> nextMatches;

    public Team(String name, int positionTeam) {
        this.name = name;
        this.positionTeam = positionTeam;
    }

    public TeamStats getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionTeam() {
        return positionTeam;
    }

    public void setPositionTeam(int positionTeam) {
        this.positionTeam = positionTeam;
    }

    public List<Team> getNextMatches() {
        return nextMatches;
    }

    public void setNextMatches(List<Team> nextMatches) {
        this.nextMatches = nextMatches;
    }

    public void removeNextMatchTeamOption(Team team) {
        this.nextMatches.remove(team);
    }
}
