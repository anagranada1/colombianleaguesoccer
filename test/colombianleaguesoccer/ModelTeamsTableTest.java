package colombianleaguesoccer;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTeamsTableTest {

    private Team buildPopulatedTeam() {
        Team team = new Team("Once Caldas", 19);
        team.getStats().setMatchPlayed(5);
        team.getStats().setWonMatches(3);
        team.getStats().setDrawMatches(1);
        team.getStats().setGoalsScored(8);
        team.getStats().setGoalsConceded(4);
        team.getStats().setPoints(10);
        return team;
    }

    @Test
    public void valueAtMapsEachColumnToTheCorrespondingTeamField() {
        Team team = buildPopulatedTeam();
        ModelTeamsTable model = new ModelTeamsTable(List.of(team));

        assertEquals(team.getPositionTeam(), model.getValueAt(0, 0));
        assertEquals(team.getName(), model.getValueAt(0, 1));
        assertEquals(team.getStats().getMatchPlayed(), model.getValueAt(0, 2));
        assertEquals(team.getStats().getWonMatches(), model.getValueAt(0, 3));
        assertEquals(team.getStats().getLostMatches(), model.getValueAt(0, 4));
        assertEquals(team.getStats().getDrawMatches(), model.getValueAt(0, 5));
        assertEquals(team.getStats().getGoalsScored(), model.getValueAt(0, 6));
        assertEquals(team.getStats().getGoalsConceded(), model.getValueAt(0, 7));
        assertEquals(team.getStats().getPoints(), model.getValueAt(0, 8));
    }

    @Test
    public void lostMatchesColumnReflectsDerivedValueNotAStoredField() {
        Team team = buildPopulatedTeam();
        ModelTeamsTable model = new ModelTeamsTable(List.of(team));

        assertEquals(1, model.getValueAt(0, 4));
    }

    @Test
    public void unknownColumnFallsBackToTheTeamItself() {
        Team team = buildPopulatedTeam();
        ModelTeamsTable model = new ModelTeamsTable(List.of(team));

        assertSame(team, model.getValueAt(0, 42));
    }

    @Test
    public void rowsAreNeverEditableSoTheTableIsReadOnly() {
        Team team = buildPopulatedTeam();
        ModelTeamsTable model = new ModelTeamsTable(List.of(team));

        for (int column = 0; column < model.getColumnCount(); column++) {
            assertFalse(model.isCellEditable(0, column));
        }
    }
}
