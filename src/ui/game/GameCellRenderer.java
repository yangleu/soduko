package ui.game;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import misc.GameFactory;
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
    	// Determine the background color, 4 corner and center cell is base cell color
    	// Cross cell w/o center center is cross color
    	CellPanel theCellPanel = new CellPanel(gcell, ((GameTable)table).getTableCellSize(),
    										    GameFactory.getBackgroundColor(row, column));
     	return    theCellPanel;
    }

    return null;


    }

}
