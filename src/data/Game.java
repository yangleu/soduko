package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {
	private GameCell cells[][] = new GameCell[9][9];
	boolean validGame=false;
	public static final int COLUMNS=9;
	public static final int ROWS=9;

	public Game(int gameNumber) {
		validGame=false; // set game as invalid in the beginning
		for (int i =0;i<9;i++)
			for (int j=0; j<9; j++)
				{
				cells[i][j] = new GameCell();
				}
		
		try {
			File difficultFile = new File("difficult");
			BufferedReader bw = new BufferedReader(new FileReader(difficultFile));

			String lineBuffer;
			int lines=0;
			while (lines < (gameNumber-1)*9 ) {
				lines ++;
				bw.readLine();
			}
			while (lines < gameNumber*9) {
				lineBuffer = bw.readLine();
				if (9 != lineBuffer.length()) return;
				else {
					int column = 0;
					while (column < 9) {
						cells[lines % 9][column].gameValue = lineBuffer
								.charAt(column) - '0';
						column++;
					}
				}
				lines ++;
			}
			
			validGame = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void print() {
		int row = 0;
		int column = 0;
		System.out.println("Valid Game ?: " + validGame);
		while (row <9) {
			while (column < 9) {
//				System.out.println("row:" + row + " column: " + column);
				System.out.print(cells[row][column].gameValue);
				column ++;
			}
			System.out.println();
			row ++;
			column=0;
		}
	}
	
	public GameCell get(int row, int column) {
		return cells[row][column];
	}
	
	public void set(GameCell value, int row, int column) {
		cells[row][column] = value;
	}
}
