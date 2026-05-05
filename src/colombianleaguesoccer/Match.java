package colombianleaguesoccer;

public class Match {

    private Team firstTeam;
    private Team secondTeam;
    private int firstTeamGoals;
    private int secondTeamGoals;

    public Match(Team firstTeam, Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamGoals = 0;
        this.secondTeamGoals = 0;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public int getFirstTeamGoals() {
        return firstTeamGoals;
    }

    public void setFirstTeamGoals(int firstTeamGoals) {
        this.firstTeamGoals = firstTeamGoals;
    }

    public int getSecondTeamGoals() {
        return secondTeamGoals;
    }

    public void setSecondTeamGoals(int secondTeamGoals) {
        this.secondTeamGoals = secondTeamGoals;
    }

    public Team getWinnerMatch() {
        if (firstTeamGoals > secondTeamGoals) {
            return firstTeam;
        } else if (secondTeamGoals > firstTeamGoals) {
            return secondTeam;
        } else {
            return null;
        }
    }

    public void setResult() {
        Team winner = this.getWinnerMatch();
        this.firstTeam.getStats().setGoalsScored(this.firstTeamGoals);
        this.secondTeam.getStats().setGoalsScored(this.secondTeamGoals);
        this.firstTeam.getStats().setGoalsConceded(this.secondTeamGoals);
        this.secondTeam.getStats().setGoalsConceded(this.firstTeamGoals);
        this.firstTeam.getStats().setMatchPlayed(1);
        this.secondTeam.getStats().setMatchPlayed(1);
        if (winner == null) {
            this.firstTeam.getStats().setPoints(1);
            this.secondTeam.getStats().setPoints(1);
            this.firstTeam.getStats().setDrawMatches(1);
            this.secondTeam.getStats().setDrawMatches(1);
        } else {
            winner.getStats().setPoints(3);
            winner.getStats().setWonMatches(1);
        }
    }

}
