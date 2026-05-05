package colombianleaguesoccer;

import java.util.ArrayList;
import java.util.List;

public class Journey {

    List<Match> matches;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Journey(int id) {
        this.matches = new ArrayList<>();
        this.id = id;
    }

    public boolean isAvailableTeam(Team team) {
        for (Match match : matches) {
            if (match.getFirstTeam() == team || match.getSecondTeam() == team) {
                return false;
            }
        }
        return true;
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public void finalizeJourney() {
        for (Match match : matches) {
            match.setResult();
        }
    }

}
