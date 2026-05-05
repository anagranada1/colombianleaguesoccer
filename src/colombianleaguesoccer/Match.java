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
        this.firstTeam.setGoalsScored(this.firstTeamGoals);
        this.secondTeam.setGoalsScored(this.secondTeamGoals);
        this.firstTeam.setGoalsConceded(this.secondTeamGoals);
        this.secondTeam.setGoalsConceded(this.firstTeamGoals);
        this.firstTeam.setMatchPlayed(1);
        this.secondTeam.setMatchPlayed(1);
        if (winner == null) {
            this.firstTeam.setPoints(1);
            this.secondTeam.setPoints(1);
            this.firstTeam.setDrawMatches(1);
            this.secondTeam.setDrawMatches(1);
        } else {
            winner.setPoints(3);
            winner.setWonMatches(1);
        }
    }

}
