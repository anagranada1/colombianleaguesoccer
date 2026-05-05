package colombianleaguesoccer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {

    private List<Team> teams;
    private Match match;
    private List<Journey> journeys;
    private int actualJourney;
    private static final int JOURNEY_COUNT = 19;
    private static final int MATCHES_PER_JOURNEY = 10;

    public League() {
        initTeams();
        initJourneys();
        actualJourney = 0;
    }

    public void initTeams() {
        teams = new ArrayList<>();
        teams.add(new Team("Águilas Doradas", 1));
        teams.add(new Team("Alianza", 2));
        teams.add(new Team("América de Cali", 3));
        teams.add(new Team("Atlético Bucaramanga", 4));
        teams.add(new Team("Atlético Nacional", 5));
        teams.add(new Team("Boyacá Chicó FC", 6));
        teams.add(new Team("Deportes Tolima", 7));
        teams.add(new Team("Deportivo Cali", 8));
        teams.add(new Team("Deportivo Pasto", 9));
        teams.add(new Team("Deportivo Pereira", 10));
        teams.add(new Team("Envigado FC", 11));
        teams.add(new Team("Fortaleza CEIF", 12));
        teams.add(new Team("Independiente Medellín", 13));
        teams.add(new Team("Independiente Santa Fe", 14));
        teams.add(new Team("Jaguares FC", 15));
        teams.add(new Team("Junior", 16));
        teams.add(new Team("La Equidad", 17));
        teams.add(new Team("Millonarios", 18));
        teams.add(new Team("Once Caldas", 19));
        teams.add(new Team("Patriotas FC", 20));
        for (Team team : teams) {
            List<Team> aux = new ArrayList<>(teams);
            aux.remove(team);
            team.setNextMatches(aux);
        }
    }

    public void updateTeamPositions() {
        Collections.sort(teams, (firstTeam, secondTeam) -> Integer.compare(secondTeam.getStats().getPoints(), firstTeam.getStats().getPoints()));
        int actualPosition = 1;
        int previousPoints = teams.get(0).getStats().getPoints();

        for (Team actualTeam : teams) {
            if (actualTeam.getStats().getPoints() != previousPoints) {
                actualPosition += 1;
                previousPoints = actualTeam.getStats().getPoints();
            }
            actualTeam.setPositionTeam(actualPosition);
        }
    }

    public void initJourneys() {
        actualJourney = 0;
        journeys = buildEmptyJourneys();
        List<Team> rotation = new ArrayList<>(teams);
        for (Journey journey : journeys) {
            fillJourney(journey, rotation);
            Collections.rotate(rotation, -1);
        }
    }

    private List<Journey> buildEmptyJourneys() {
        List<Journey> result = new ArrayList<>();
        for (int i = 1; i <= JOURNEY_COUNT; i++) {
            result.add(new Journey(i));
        }
        return result;
    }

    private void fillJourney(Journey journey, List<Team> pool) {
        for (Team copyTeam : pool) {
            if (journey.getMatches().size() >= MATCHES_PER_JOURNEY) {
                return;
            }
            for (Team rival : pool) {
                if (canPair(journey, copyTeam, rival)) {
                    journey.addMatch(new Match(rival, copyTeam));
                    copyTeam.removeNextMatchTeamOption(rival);
                }
            }
        }
    }

    private boolean canPair(Journey journey, Team copyTeam, Team rival) {
        return copyTeam.getNextMatches().contains(rival)
                && journey.isAvailableTeam(copyTeam)
                && journey.isAvailableTeam(rival);
    }
    
    public boolean isFinalized(){
        return getActualJourney() == null;
    }
            

    public Journey getActualJourney() {
        if (actualJourney >= getJourneys().size()) {
            return null;
        }
        return getJourneys().get(actualJourney);
    }

    public void incrementActualJourney() {
        actualJourney += 1;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

}
