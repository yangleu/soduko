package ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTable;

import testpackage.FakeEditor;
import data.CellCandidateTableModel;
import data.GameCell;

public class CellCandidateTable extends JTable {
//	private CellCandidateTableModel cellCandidateTableModel;

	private void setDefaultConfig() {
		this.setDefaultRenderer(Boolean.class, new CellCandidateRenderer());
		this.setDefaultEditor(boolean.class, new FakeEditor());
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


}
