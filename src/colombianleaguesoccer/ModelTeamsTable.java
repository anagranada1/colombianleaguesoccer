package colombianleaguesoccer;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTeamsTable extends AbstractTableModel {

    List<Team> teams;
    String[] COLUMNS = {"Position", "Name", "Match Played", "Won Matches", "Lost Matches",
        "Draw Matches", "Goals Scored", "Goals Conceded", "Points"};

    public ModelTeamsTable(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public int getRowCount() {
        return this.teams.size();
    }

    @Override
    public int getColumnCount() {
        return this.COLUMNS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var team = this.teams.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                team.getPositionTeam();
            case 1 ->
                team.getName();
            case 2 ->
                team.getStats().getMatchPlayed();
            case 3 ->
                team.getStats().getWonMatches();
            case 4 ->
                team.getStats().getLostMatches();
            case 5 ->
                team.getStats().getDrawMatches();
            case 6 ->
                team.getStats().getGoalsScored();
            case 7 ->
                team.getStats().getGoalsConceded();
            case 8 ->
                team.getStats().getPoints();
            default ->
                team;
        };
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return this.COLUMNS[column];
    }

}
