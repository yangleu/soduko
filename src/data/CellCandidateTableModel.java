package data;

import javax.swing.table.AbstractTableModel;


public class CellCandidateTableModel extends AbstractTableModel {
	GameCell cell;
	int candidates;
	
	public CellCandidateTableModel(GameCell cell) {
		super();
		this.cell = cell;
		
		candidates=0;
		int i = 0;
		while (i < 9) if (cell.candidate[i++]) candidates++;
	}

	@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return cell.candidate[row*3+column];
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		// TODO Auto-generated method stub
		Boolean newValue = (Boolean) value;
		cell.setCandidateStatus(0, (boolean)value, row, column);		
		fireTableCellUpdated(row, column);
	}
	public void setValueAt(int logLevel, Object value, int row, int column) {
		// TODO Auto-generated method stub
		Boolean newValue = (Boolean) value;
		cell.setCandidateStatus(logLevel, (boolean)value, row, column);		
		fireTableCellUpdated(row, column);
	}
	
	@Override
    public boolean isCellEditable(int row, int col) {
		return true;
		
	}
}
