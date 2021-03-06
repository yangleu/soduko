package ui.game;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Enumeration;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.table.TableColumn;

import data.GameCell;

public class CellPanel extends JPanel{
	GameCell cell;
	JLabel cellLabel;
	CellCandidateTable candidateTable;
	public CellPanel(GameCell tCell, Dimension tDimension, Color bgColor) {
		super(new SpringLayout());
		this.cell = tCell;

		this.setBounds(0, 0, tDimension.width, tDimension.height);
		this.setOpaque(true);
		this.setPreferredSize(tDimension);
		// this.setBorder(BorderFactory.createLineBorder(Color.red));

		if ((0 != cell.gameValue) || (0 != cell.currentValue)) {
			// In these two cases, need show cellLabel. Create it first
			cellLabel = new JLabel("", JLabel.CENTER);
			cellLabel.setOpaque(true);
			cellLabel.setBackground(bgColor);
			//cellLabel.setBounds(0, 0, tDimension.width, tDimension.height);
			cellLabel.setPreferredSize(tDimension);
			cellLabel.setAlignmentX(CENTER_ALIGNMENT);
			cellLabel.setAlignmentY(CENTER_ALIGNMENT);
			// cellLabel.setBorder(BorderFactory.createLineBorder(Color.red));
			cellLabel.setFont(getFont().deriveFont((float) 24.0));
			add(cellLabel);
			// Adjust the start position
			SpringLayout.Constraints cons = new SpringLayout.Constraints(cellLabel);
			cons.setX(Spring.constant(0));
			cons.setY(Spring.constant(0));
			
			
			// Deal with two different situation
			if (0 != cell.gameValue) { // If the cell is know game value, show
										// Label
				cellLabel.setText(String.valueOf(cell.gameValue));
				cellLabel.setForeground(Color.BLACK);
			} else {
				cellLabel.setText(String.valueOf(cell.currentValue));
				cellLabel.setForeground(Color.RED);
			}

		} else { // Unknown cell, need show available candidates
			candidateTable = new CellCandidateTable(tCell, bgColor);
			// candidateTable.setBounds(0,0,tDimension.width,tDimension.height);
			//candidateTable.setPreferredScrollableViewportSize(tDimension);
			candidateTable.setRowHeight(tDimension.height / 3);
			add(candidateTable, 0);

			Enumeration columns = candidateTable.getColumnModel().getColumns();
			TableColumn mycol;
			while (columns.hasMoreElements()) {
				mycol = (TableColumn) columns.nextElement();
				mycol.setPreferredWidth(tDimension.width / 3);

			}

		}

	}
	

	public CellPanel(GameCell tCell, Dimension tDimension) {
		super(new SpringLayout());
		this.cell = tCell;

		this.setBounds(0, 0, tDimension.width, tDimension.height);
		this.setOpaque(true);
		this.setPreferredSize(tDimension);
		// this.setBorder(BorderFactory.createLineBorder(Color.red));

		if ((0 != cell.gameValue) || (0 != cell.currentValue)) {
			// In these two cases, need show cellLabel. Create it first
			cellLabel = new JLabel("", JLabel.CENTER);
			cellLabel.setOpaque(true);
			//cellLabel.setBackground(this.getBackground());
			//cellLabel.setBounds(0, 0, tDimension.width, tDimension.height);
			cellLabel.setPreferredSize(tDimension);
			cellLabel.setAlignmentX(CENTER_ALIGNMENT);
			cellLabel.setAlignmentY(CENTER_ALIGNMENT);
			// cellLabel.setBorder(BorderFactory.createLineBorder(Color.red));
			cellLabel.setFont(getFont().deriveFont((float) 24.0));
			add(cellLabel);
			// Adjust the start position
			SpringLayout.Constraints cons = new SpringLayout.Constraints(cellLabel);
			cons.setX(Spring.constant(0));
			cons.setY(Spring.constant(0));
			
			
			// Deal with two different situation
			if (0 != cell.gameValue) { // If the cell is know game value, show
										// Label
				cellLabel.setText(String.valueOf(cell.gameValue));
				cellLabel.setForeground(Color.BLACK);
			} else {
				cellLabel.setText(String.valueOf(cell.currentValue));
				cellLabel.setForeground(Color.RED);
			}

		} else { // Unknown cell, need show available candidates
			candidateTable = new CellCandidateTable(tCell);
			// candidateTable.setBounds(0,0,tDimension.width,tDimension.height);
			//candidateTable.setPreferredScrollableViewportSize(tDimension);
			candidateTable.setRowHeight(tDimension.height / 3);
			add(candidateTable, 0);

			Enumeration columns = candidateTable.getColumnModel().getColumns();
			TableColumn mycol;
			while (columns.hasMoreElements()) {
				mycol = (TableColumn) columns.nextElement();
				mycol.setPreferredWidth(tDimension.width / 3);

			}

		}

	}
	
	public CellPanel(GameCell tCell) {
		super(new SpringLayout());
		this.cell = tCell;

		this.setOpaque(true);
		this.setBackground(Color.pink);
		SpringLayout.Constraints panelCons = new SpringLayout.Constraints(this);
		Spring itemSpring = Spring.max(panelCons.getConstraint(SpringLayout.NORTH),
									   panelCons.getConstraint(SpringLayout.WEST));
		
		// this.setBorder(BorderFactory.createLineBorder(Color.red));

		if ((0 != cell.gameValue) || (0 != cell.currentValue)) {
			// In these two cases, need show cellLabel. Create it first
			cellLabel = new JLabel("", JLabel.CENTER);
			cellLabel.setOpaque(true);
			// cellLabel.setBackground(Color.green);
			cellLabel.setAlignmentX(CENTER_ALIGNMENT);
			cellLabel.setAlignmentY(CENTER_ALIGNMENT);
			// cellLabel.setBorder(BorderFactory.createLineBorder(Color.red));
			cellLabel.setFont(getFont().deriveFont((float) 24.0));
			(new SpringLayout.Constraints(cellLabel)).setHeight(panelCons.getHeight());;
			(new SpringLayout.Constraints(cellLabel)).setHeight(panelCons.getWidth());;
			
			add(cellLabel);

			// Deal with two different situation
			if (0 != cell.gameValue) { // If the cell is know game value, show
										// Label
				cellLabel.setText(String.valueOf(cell.gameValue));
				cellLabel.setForeground(Color.BLACK);
			} else {
				cellLabel.setText(String.valueOf(cell.currentValue));
				cellLabel.setForeground(Color.RED);
			}

		} else { // Unknown cell, need show available candidates
			candidateTable = new CellCandidateTable(tCell);
			// candidateTable.setBounds(0,0,tDimension.width,tDimension.height);
			add(candidateTable, 0);
			(new SpringLayout.Constraints(candidateTable)).setHeight(panelCons.getHeight());;
			(new SpringLayout.Constraints(candidateTable)).setHeight(panelCons.getWidth());;
			
			Enumeration columns = candidateTable.getColumnModel().getColumns();
			TableColumn mycol;
			while (columns.hasMoreElements()) {
				mycol = (TableColumn) columns.nextElement();
				// LeoLog.print("Before: " + mycol.getWidth());
				mycol.setWidth(this.getPreferredSize().width/3);

			}

		}

	}
	

}
