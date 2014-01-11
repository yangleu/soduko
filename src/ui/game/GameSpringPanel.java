package ui.game;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import testpackage.SpringLeoUtilities;
import data.Game;

public class GameSpringPanel extends JPanel{
	Game theGame;

	public GameSpringPanel(Game Game) {
		super(new SpringLayout());
		this.theGame = Game;
	CellPanel  tmpCell;
	for (int row=0; row<9; row++) { // Add game cell to panel
		for (int column=0; column<9; column++) {
			tmpCell = new CellPanel(theGame.get(row, column));
			
			add (tmpCell);
		}
	}

//    SpringUtilities.makeGrid(this,
//            9, 9, //rows, cols
//            30, 100, //initialX, initialY
//            5, 5);//xPad, yPad

    SpringLeoUtilities.makeGrid(this,
            9, 9, //rows, cols
            45, 100, //initialX, initialY
            5, 5);//xPad, yPad
	
	}
	
	
	
}
