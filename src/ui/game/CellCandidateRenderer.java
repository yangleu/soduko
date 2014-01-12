package ui.game;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import misc.GameFactory;

public class CellCandidateRenderer extends JLabel
implements TableCellRenderer {
	Color bgColor= Color.red;
	
	CellCandidateRenderer () {
		super("", JLabel.CENTER);
	}

	CellCandidateRenderer (Color bgColor) {
		super("", JLabel.CENTER);
		this.bgColor = bgColor;
	}
	
    public Component getTableCellRendererComponent(
            JTable table, Object isCandidate,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
    	
    	this.setBackground(bgColor);
    	this.setOpaque(true);
    	this.setText(String.valueOf(row*3 + column + 1));
    	if ((Boolean) isCandidate) this.setForeground(Color.BLUE);
    	else this.setForeground(bgColor);
    	
    	return this;
    }

}
