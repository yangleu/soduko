package ui;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import data.GameCell;

public class GameCellRenderer extends JComponent
implements TableCellRenderer {
	
    public Component getTableCellRendererComponent(
            JTable table, Object cell,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
    	GameTable gtable = (GameTable) table;
    	GameCell gcell = gtable.getCell(row, column);
    
    if (table instanceof GameTable) {
     	return new CellPanel(gcell, ((GameTable)table).getTableCellSize());    	
    }

    return null;


    }

}
