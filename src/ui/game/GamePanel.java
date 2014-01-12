package ui.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import misc.GameFactory;
import data.Game;

public class GamePanel extends JPanel implements ActionListener{
	Game game;
	GameTable gtable;

	public GamePanel(Game game) {
		super();
		this.game = game;
		gtable = new GameTable(game);
		
//		
		JButton infoCmd = new JButton ("Click me: haha");
		infoCmd.setActionCommand("printInfo");
		infoCmd.addActionListener(this);
		
		add(infoCmd);
		add(gtable);
		
		this.setBackground(Color.GREEN);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("printInfo".endsWith(e.getActionCommand())) {
			GameFactory.println("Table column width " + gtable.getColumnModel().getColumn(0).getWidth());
			GameFactory.println("Cell dimention: " + gtable.getTableCellSize());
			GameFactory.println("Table height: " + gtable.getRowHeight());
			GameFactory.println("Row Margin: " + gtable.getRowMargin());
			
			GameFactory.println("Real Cell size ");
		}
	};
	

}
