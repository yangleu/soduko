package data;

import javax.swing.table.AbstractTableModel;


public class GameTableModel extends AbstractTableModel {
	Game game;
	
	public GameTableModel(Game theGame) {
		super();
		this.game = theGame;
		
	}

	@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return game.COLUMNS;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return game.ROWS;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return game.get(row, column);
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		// TODO Auto-generated method stub
		game.set((GameCell)value, row, column);
		
		fireTableCellUpdated(row, column);
	}
	
	@Override
    public boolean isCellEditable(int row, int column) {
		if (0 != game.get(row, column).gameValue) return false;
		else return true;
	}
}
