package colombianleaguesoccer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    @Test
    public void winnerIsHomeTeamWhenItScoresMore() {
        Team home = new Team("Nacional", 5);
        Team away = new Team("Millonarios", 18);
        Match match = new Match(home, away);
        match.setFirstTeamGoals(2);
        match.setSecondTeamGoals(0);

        assertSame(home, match.getWinnerMatch());
    }

    @Test
    public void winnerIsAwayTeamWhenItScoresMore() {
        Team home = new Team("Patriotas", 20);
        Team away = new Team("Santa Fe", 14);
        Match match = new Match(home, away);
        match.setFirstTeamGoals(1);
        match.setSecondTeamGoals(3);

        assertSame(away, match.getWinnerMatch());
    }

    @Test
    public void winnerIsNullOnDraw() {
        Match match = new Match(new Team("Cali", 8), new Team("Pasto", 9));
        match.setFirstTeamGoals(1);
        match.setSecondTeamGoals(1);

        assertNull(match.getWinnerMatch());
    }

    @Test
    public void resultGivesThreePointsAndOneWinToTheWinnerOnly() {
        Team home = new Team("América", 3);
        Team away = new Team("Junior", 16);
        Match match = new Match(home, away);
        match.setFirstTeamGoals(3);
        match.setSecondTeamGoals(1);

        match.setResult();

        assertEquals(3, home.getPoints());
        assertEquals(1, home.getWonMatches());
        assertEquals(0, home.getDrawMatches());
        assertEquals(0, away.getPoints());
        assertEquals(0, away.getWonMatches());
    }

    @Test
    public void resultGivesOnePointAndOneDrawToBothTeamsOnTie() {
        Team home = new Team("Bucaramanga", 4);
        Team away = new Team("Equidad", 17);
        Match match = new Match(home, away);
        match.setFirstTeamGoals(2);
        match.setSecondTeamGoals(2);

        match.setResult();

        assertEquals(1, home.getPoints());
        assertEquals(1, away.getPoints());
        assertEquals(1, home.getDrawMatches());
        assertEquals(1, away.getDrawMatches());
        assertEquals(0, home.getWonMatches());
        assertEquals(0, away.getWonMatches());
    }

    @Test
    public void resultPropagatesGoalsAndAppearancesSymmetrically() {
        Team home = new Team("Medellín", 13);
        Team away = new Team("Envigado", 11);
        Match match = new Match(home, away);
        match.setFirstTeamGoals(4);
        match.setSecondTeamGoals(2);

        match.setResult();

        assertEquals(1, home.getMatchPlayed());
        assertEquals(1, away.getMatchPlayed());
        assertEquals(4, home.getGoalsScored());
        assertEquals(2, home.getGoalsConceded());
        assertEquals(2, away.getGoalsScored());
        assertEquals(4, away.getGoalsConceded());
    }
}
