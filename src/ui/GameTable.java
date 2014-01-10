package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import misc.LeoLog;
import data.Game;
import data.GameCell;
import data.GameTableModel;

public class GameTable extends JTable{
	private static final long serialVersionUID = 1L;

	private Game game;
	private Dimension tableSize; // It's a square, so the width and height is the same
	private Dimension tableCellSize;
	public GameTable(Game game) {
		super(new GameTableModel(game));
		this.game = game;
		Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
		int lenght = ((screen.height> screen.width)?screen.width:screen.height)*2/3;
		int subcellLen = lenght/27;
		tableCellSize = new Dimension(subcellLen*3, subcellLen*3);
		tableSize = new Dimension(subcellLen*27, subcellLen*27);

		setDefaultRenderer(GameCell.class, new GameCellRenderer());
		this.setDefaultEditor(GameCell.class, new GameCellEditor());
		setIntercellSpacing(new Dimension(1,1));
		this.setRowMargin(1);
		setPreferredScrollableViewportSize(tableSize);
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setRowHeight(tableCellSize.height);
		setGridColor(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setShowHorizontalLines(true);
		this.setShowVerticalLines(true);
		
		Enumeration columns = getColumnModel().getColumns();
		TableColumn mycol;

		while (columns.hasMoreElements()) {
			mycol = (TableColumn)columns.nextElement();
			//LeoLog.print("Before: " + mycol.getWidth());
			//mycol.setWidth(tableCellSize.width);
			mycol.setPreferredWidth(tableCellSize.width);
			//LeoLog.println(" Setting: " + tableCellSize.width+ " After: " + mycol.getWidth());
		}
		
		
	}

	public Dimension getTableCellSize() {
		return tableCellSize;
	}
	
	public GameCell getCell (int row, int column) {
		return game.get(row, column);
	} 
}
