package colombianleaguesoccer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JourneyTest {

    @Test
    public void teamIsAvailableWhenItHasNoMatchYet() {
        Journey journey = new Journey(1);
        assertTrue(journey.isAvailableTeam(new Team("Nacional", 5)));
    }

    @Test
    public void teamIsNotAvailableWhenAlreadyPlayingAsHome() {
        Journey journey = new Journey(1);
        Team home = new Team("A", 1);
        journey.addMatch(new Match(home, new Team("B", 2)));

        assertFalse(journey.isAvailableTeam(home));
    }

    @Test
    public void teamIsNotAvailableWhenAlreadyPlayingAsAway() {
        Journey journey = new Journey(1);
        Team away = new Team("B", 2);
        journey.addMatch(new Match(new Team("A", 1), away));

        assertFalse(journey.isAvailableTeam(away));
    }

    @Test
    public void finalizeJourneyAppliesEveryMatchResult() {
        Journey journey = new Journey(1);
        Team a = new Team("A", 1);
        Team b = new Team("B", 2);
        Team c = new Team("C", 3);
        Team d = new Team("D", 4);

        Match win = new Match(a, b);
        win.setFirstTeamGoals(2);
        win.setSecondTeamGoals(0);
        Match draw = new Match(c, d);
        draw.setFirstTeamGoals(1);
        draw.setSecondTeamGoals(1);
        journey.addMatch(win);
        journey.addMatch(draw);

        journey.finalizeJourney();

        assertEquals(3, a.getStats().getPoints());
        assertEquals(0, b.getStats().getPoints());
        assertEquals(1, c.getStats().getPoints());
        assertEquals(1, d.getStats().getPoints());
        assertEquals(1, a.getStats().getMatchPlayed());
        assertEquals(1, d.getStats().getMatchPlayed());
    }
}
