package colombianleaguesoccer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeagueTest {

    private League league;

    @BeforeEach
    public void setUp() {
        league = new League();
    }

    @Test
    public void leagueIsBuiltWithTwentyUniqueTeams() {
        List<Team> teams = league.getTeams();
        assertEquals(20, teams.size());

        Set<String> uniqueNames = new HashSet<>();
        for (Team team : teams) {
            uniqueNames.add(team.getName());
        }
        assertEquals(20, uniqueNames.size());
    }

    @Test
    public void scheduleHasNineteenJourneysOfTenMatchesEach() {
        List<Journey> journeys = league.getJourneys();
        assertEquals(19, journeys.size());
        for (Journey journey : journeys) {
            assertEquals(10, journey.getMatches().size());
        }
    }

    @Test
    public void noTeamPlaysTwiceInTheSameJourney() {
        for (Journey journey : league.getJourneys()) {
            Set<Team> seen = new HashSet<>();
            for (Match match : journey.getMatches()) {
                assertTrue(seen.add(match.getFirstTeam()),
                        "first team repeated in journey " + journey.getId());
                assertTrue(seen.add(match.getSecondTeam()),
                        "second team repeated in journey " + journey.getId());
            }
            assertEquals(20, seen.size());
        }
    }

    @Test
    public void updateTeamPositionsRanksByPointsDescending() {
        List<Team> teams = league.getTeams();
        teams.get(0).getStats().setPoints(3);
        teams.get(1).getStats().setPoints(9);
        teams.get(2).getStats().setPoints(6);

        league.updateTeamPositions();

        List<Team> sorted = league.getTeams();
        assertEquals(9, sorted.get(0).getStats().getPoints());
        assertEquals(6, sorted.get(1).getStats().getPoints());
        assertTrue(sorted.get(0).getStats().getPoints() >= sorted.get(sorted.size() - 1).getStats().getPoints());
    }

    @Test
    public void teamsTiedOnPointsShareTheSamePosition() {
        List<Team> teams = league.getTeams();
        teams.get(0).getStats().setPoints(9);
        teams.get(1).getStats().setPoints(6);
        teams.get(2).getStats().setPoints(6);
        teams.get(3).getStats().setPoints(3);

        league.updateTeamPositions();

        List<Team> sorted = league.getTeams();
        assertEquals(1, sorted.get(0).getPositionTeam());
        assertEquals(sorted.get(1).getPositionTeam(), sorted.get(2).getPositionTeam(),
                "teams tied on points must share position");
        assertEquals(2, sorted.get(1).getPositionTeam());
        assertEquals(3, sorted.get(3).getPositionTeam());
    }

    @Test
    public void leagueAdvancesJourneyByJourneyUntilFinalized() {
        assertFalse(league.isFinalized());
        assertEquals(1, league.getActualJourney().getId());

        league.incrementActualJourney();
        assertEquals(2, league.getActualJourney().getId());

        for (int i = 0; i < 18; i++) {
            league.incrementActualJourney();
        }

        assertNull(league.getActualJourney());
        assertTrue(league.isFinalized());
    }
}
