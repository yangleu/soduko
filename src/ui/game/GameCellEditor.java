package ui.game;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import data.GameCell;

public class GameCellEditor extends AbstractCellEditor
implements TableCellEditor,
ActionListener {
	GameCell currentCell;
    public Component getTableCellEditorComponent(JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {
    	
    	currentCell = (GameCell) value;
    	GameTable gtable = (GameTable) table;
    	CellCandidateTable ctable = new CellCandidateTable(currentCell);
    	ctable.setRowHeight(gtable.getTableCellSize().height/3 + 2);
    	return ctable;
    }

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return currentCell;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
