package ui.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.Game;

public class GameGridPanel extends JPanel{
	Game game;
	Dimension tableCellSize;
	Dimension tableSize;
	int pad =2;
	public GameGridPanel(Game game) {
		super(new GridLayout(9,9));
		this.game = game;
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(Color.green);
		
		Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
		int lenght = ((screen.height> screen.width)?screen.width:screen.height)*2/3;
		int subcellLen = lenght/27;
		tableCellSize = new Dimension(subcellLen*3, subcellLen*3);
		tableSize = new Dimension(subcellLen*27, subcellLen*27);

		GridLayout layout = (GridLayout) this.getLayout();
		layout.setHgap(pad);
		layout.setVgap(pad);

		
		for(int row=0; row<9; row++)
			for (int column=0; column<9; column++) {
				add(new CellPanel(game.get(row, column), tableCellSize));
			}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame ();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game newGame = new Game(2);
		JPanel contentPane = new JPanel();
		GameGridPanel gpanel = new GameGridPanel(newGame);
		contentPane.add(gpanel);
		
		contentPane.setOpaque(true);
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);

	}

}
