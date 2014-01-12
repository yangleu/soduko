package ui.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

import data.CellCandidateTableModel;
import data.GameCell;

public class CellCandidateTable extends JTable {
//	private CellCandidateTableModel cellCandidateTableModel;
	Color bgColor ;
	private void setDefaultConfig() {
		this.setDefaultRenderer(Boolean.class, new CellCandidateRenderer(bgColor));
		this.setRowMargin(0);
		this.setIntercellSpacing(new Dimension (0,0));
		//setBackground(bgColor);
		//this.setBorder(BorderFactory.createLineBorder(Color.red));
	}
	
	public CellCandidateTable(CellCandidateTableModel cellCandidateTableModel) {
		super(cellCandidateTableModel);
		setDefaultConfig();
	}	

	public CellCandidateTable( GameCell cell) {
		super(new CellCandidateTableModel (cell));
		setDefaultConfig();
	}

	public CellCandidateTable( GameCell cell, Color bgColor) {
		super(new CellCandidateTableModel (cell));
		this.bgColor = bgColor;
		setDefaultConfig();
		
	}

}
