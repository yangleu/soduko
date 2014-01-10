package data;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import testpackage.GamePanel;
import ui.CellCandidateTable;
import ui.CellPanel;
import ui.GameTable;

public class MyTest {
	

//	@Test
	public void testClassGame() { // Test GameLoader
		Game mygame = new Game(1);
		mygame.print();
	}


	private static void testCellCandidateTable() {
		JFrame frame = new JFrame("CellTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel(new GridLayout(1, 0));
		GameCell cell = new GameCell();
		CellCandidateTable cellCandidate = new CellCandidateTable( new CellCandidateTableModel(cell));
		
		if (null != cellCandidate )panel.add(cellCandidate);
		panel.setOpaque(true);

		frame.setContentPane(panel);

		// Display the window.
		frame.pack();

	}
	
	private static void testGameTable() {
		JFrame frame = new JFrame("Game Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		
		Game game = new Game(1);
		GameCell mycell = game.get(1, 2);
		mycell.setCurrentValue(4);
		game.set(mycell, 1, 2);
		GameTable gtable = new GameTable (game);
		
		panel.add(gtable);
		panel.setOpaque(true);
		

		frame.setContentPane(panel);

		// Display the window.
		frame.pack();

	}
	
	private static void testGamePanel() {
		JFrame frame = new JFrame("Game Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Game game = new Game(1);
		GameCell mycell = game.get(1, 2);
		mycell.setCurrentValue(4);
		game.set(mycell, 1, 2);
		
		GamePanel panel = new GamePanel(game);
		frame.setContentPane(panel);
		panel.setOpaque(true);
		

		frame.setContentPane(panel);

		// Display the window.
		frame.pack();

	}
	
	private static void testCellPanel() {
		JFrame frame = new JFrame("CellPanel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameCell mycell1 = new GameCell();
		mycell1.setGameValue(1);
		CellPanel panel1 = new CellPanel (mycell1, new Dimension(300,300));
		
		GameCell mycell2 = new GameCell();
		mycell2.setCurrentValue(2);
		CellPanel panel2 = new CellPanel (mycell2, new Dimension(300,300));

		GameCell mycell3 = new GameCell();
		mycell3.deselectCandidate(3);
		CellPanel panel3 = new CellPanel (mycell3, new Dimension(300,300));

		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		
		panel.setOpaque(true);

		frame.setContentPane(panel);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
 //           	testCellPanel();
//            	testGameTable();
            	testGamePanel();
            }
        });
 
    }

}
