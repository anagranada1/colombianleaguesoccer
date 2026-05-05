package colombianleaguesoccer;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @Test
    public void lostMatchesIsDerivedFromPlayedMinusWonAndDrawn() {
        Team team = new Team("Tolima", 7);
        team.setMatchPlayed(10);
        team.setWonMatches(4);
        team.setDrawMatches(3);

        assertEquals(3, team.getLostMatches());
    }

    @Test
    public void lostMatchesIsZeroWhenAllOutcomesAreWinsOrDraws() {
        Team team = new Team("Pereira", 10);
        team.setMatchPlayed(5);
        team.setWonMatches(2);
        team.setDrawMatches(3);

        assertEquals(0, team.getLostMatches());
    }

    @Test
    public void removeNextMatchOptionRemovesOnlyTheGivenRival() {
        Team team = new Team("Junior", 16);
        Team rivalA = new Team("Cali", 8);
        Team rivalB = new Team("Pasto", 9);
        List<Team> rivals = new ArrayList<>(List.of(rivalA, rivalB));
        team.setNextMatches(rivals);

        team.removeNextMatchTeamOption(rivalA);

        assertFalse(team.getNextMatches().contains(rivalA));
        assertTrue(team.getNextMatches().contains(rivalB));
    }
}
