package testpackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import misc.LeoLog;
import ui.game.CellCandidateTable;
import ui.game.CellPanel;
import ui.game.GamePanel;
import ui.game.GameSpringPanel;
import ui.game.GameTable;
import data.CellCandidateTableModel;
import data.Game;
import data.GameCell;

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
		
		class CellPanelTest extends JPanel implements ActionListener {
			CellPanel panel1;
			CellPanel panel3;
			GameCell mycell1;
			GameCell mycell3;
			JPanel   rPanel;
			public CellPanelTest() {
				super();
		        Dimension panelsize = new Dimension(200,200);
		        
				mycell1 = new GameCell();
				mycell1.setGameValue(1);
				panel1 = new CellPanel (mycell1,panelsize);
				panel1.setPreferredSize(panelsize);
				panel1.setBorder(BorderFactory.createLineBorder(Color.GREEN));
				
				mycell3 = new GameCell();
				mycell3.deselectCandidate(3);
				panel3 = new CellPanel (mycell3,panelsize);
				panel3.setPreferredSize(panelsize);
				panel3.setBorder(BorderFactory.createLineBorder(Color.GREEN));

				JButton cmdButton = new JButton ("Click me!!");
				cmdButton.setActionCommand("printInfo");
				cmdButton.addActionListener(this);

				JButton cPosition = new JButton ("Move Child Componnet");
				cPosition.setActionCommand("moveChild");
				cPosition.addActionListener(this);
				
				JPanel bPanel = new JPanel(new GridLayout(2,1));
				bPanel.add(cmdButton);
				bPanel.add(cPosition);
				
				this.setLayout(new GridLayout(1,2));
				this.add(bPanel);
				
				rPanel = new JPanel (new GridLayout(2,1));
				rPanel.add(panel1);
				rPanel.add(panel3);
				this.add(rPanel);

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				if ("printInfo".endsWith(e.getActionCommand())) {
					LeoLog.println("printInfo is clicked");
					
					printcontainerConstraints(panel1, "Panel 1");
					printcontainerConstraints(panel3, "Panel 3");
				}
				
				if ("moveChild".endsWith(e.getActionCommand())) {
					LeoLog.println("moveChild is clicked");

					SpringLayout.Constraints cCons = new SpringLayout.Constraints(panel1.getComponent(0));
					cCons.setX(Spring.constant(0));
					cCons.setY(Spring.constant(0));
					
					cCons = new SpringLayout.Constraints(panel3.getComponent(0));
					cCons.setX(Spring.constant(0));
					cCons.setY(Spring.constant(0));

				}
			}
			
			void printcontainerConstraints(Container parent, String pName) {
				
				SpringLayout.Constraints pCons = new SpringLayout.Constraints(parent);
				LeoLog.printConstraint(pCons, pName);
				int children = parent.getComponentCount();
				int i=0;
				while (i< children) {
					SpringLayout.Constraints cCons = new SpringLayout.Constraints(parent.getComponent(i));
					LeoLog.printConstraint(cCons, pName + "::Comp(" +i + ")");
					
					i++;
				}

				
			}

		}
		JFrame frame = new JFrame("CellPanel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel contentPanel = new JPanel();
		contentPanel.add(new CellPanelTest());

		// Add button to print dynamic information
		
		contentPanel.setOpaque(true);
		contentPanel.setBackground(Color.red);
		frame.setContentPane(contentPanel);

		// Display the window.
		frame.pack();
		frame.setVisible(true);


	}

	private static void testGameSpringPanel() {
		JFrame frame = new JFrame("Game Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Game game = new Game(1);
		GameCell mycell = game.get(1, 2);
		mycell.setCurrentValue(4);
		game.set(mycell, 1, 2);
		
		GameSpringPanel panel = new GameSpringPanel(game);
		frame.setContentPane(panel);
		panel.setOpaque(true);
		

		frame.setContentPane(panel);

		// Display the window.
		frame.pack();

	}

	
	private static void testTestGameSpringPanel() {
		JFrame frame = new JFrame("Game Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Game game = new Game(1);
		GameCell mycell = game.get(1, 2);
		mycell.setCurrentValue(4);
		game.set(mycell, 1, 2);
		
		TestGameSpringPanel panel = new TestGameSpringPanel(game);
		frame.setContentPane(panel);
		panel.setOpaque(true);
		

		frame.setContentPane(panel);

		// Display the window.
		frame.pack();

	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//          	testCellPanel();
            	testGameTable();
//            	testGamePanel();
//            	testGameSpringPanel();
         //            	testTestGameSpringPanel();
            }
        });
 
    }



}
