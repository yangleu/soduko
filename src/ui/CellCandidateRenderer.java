package ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellCandidateRenderer extends JLabel
implements TableCellRenderer {
	CellCandidateRenderer () {
		super("", JLabel.CENTER);
	}
    public Component getTableCellRendererComponent(
            JTable table, Object isCandidate,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
    	
    	this.setText(String.valueOf(row*3 + column + 1));
    	if ((Boolean) isCandidate) this.setForeground(Color.BLUE);
    	else this.setForeground(Color.BLACK);
    	
    	return this;
    }

}
