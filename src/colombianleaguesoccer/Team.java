package colombianleaguesoccer;

import java.util.List;

public class Team {

    private String name;
    private int points;
    private int matchPlayed;
    private int wonMatches;
    private int drawMatches;
    private int goalsScored;
    private int goalsConceded;
    private int positionTeam;
    private List<Team> nextMatches;

    public List<Team> getNextMatches() {
        return nextMatches;
    }

    public void setNextMatches(List<Team> nextMatches) {
        this.nextMatches = nextMatches;
    }

    public void removeNextMatchTeamOption(Team team) {
        this.nextMatches.remove(team);
    }

    public Team(String name, int positionTeam) {
        this.name = name;
        this.points = 0;
        this.matchPlayed = 0;
        this.wonMatches = 0;
        this.drawMatches = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.positionTeam = positionTeam;
    }

    public int getPositionTeam() {
        return positionTeam;
    }

    public void setPositionTeam(int positionTeam) {
        this.positionTeam = positionTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed += matchPlayed;
    }

    public int getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(int wonMatches) {
        this.wonMatches += wonMatches;
    }

    public int getLostMatches() {
        return matchPlayed - (wonMatches + drawMatches);
    }

    public int getDrawMatches() {
        return drawMatches;
    }

    public void setDrawMatches(int drawMatches) {
        this.drawMatches += drawMatches;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored += goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded += goalsConceded;
    }

}
