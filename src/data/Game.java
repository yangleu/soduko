package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {
	// In all the function, row/column starts from 0,
	private GameCell cell[][] = new GameCell[9][9];
	public static final int COLUMNS=9;
	public static final int ROWS=9;

	public Game(int gameNumber) {
		for (int i =0;i<9;i++)
			for (int j=0; j<9; j++)
				{
				cell[i][j] = new GameCell();
				}
		
		try {
			File difficultFile = new File("hard");
			BufferedReader bw = new BufferedReader(new FileReader(difficultFile));

			String lineBuffer;
			int lines=0;
			while (lines < (gameNumber-1)*10 ) {
				lines ++;
				bw.readLine();
			}
			while (lines < gameNumber*9) {
				lineBuffer = bw.readLine();
				if (9 != lineBuffer.length()) return;
				else {
					int column = 0;
					while (column < 9) {
						cell[lines % 9][column].gameValue = lineBuffer
								.charAt(column) - '0';
						column++;
					}
				}
				lines ++;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void print() {
		int row = 0;
		int column = 0;
		while (row <9) {
			while (column < 9) {
//				System.out.println("row:" + row + " column: " + column);
				System.out.print(cell[row][column].gameValue);
				column ++;
			}
			System.out.println();
			row ++;
			column=0;
		}
	}
	
	public GameCell get(int row, int column) {
		return cell[row][column];
	}
	
	public void set(GameCell value, int row, int column) {
		cell[row][column] = value;
	}
	
	public String toString() {
		String msg = "";
		return msg;
	}

	public boolean validate() throws InvalidGame, InvalidGameBlock {
		boolean isValid = true;
		for (int row=0; row<9; row++)
			for (int column=0; column<9; column++) { 
			   //If this is a known cell, check for duplicated value in the same units
				if ( 0!= cell[row][column].getCurrentValue() ) {
				int cellValue = cell[row][column].getCurrentValue();
				// Check the same row
					for(int i=0;i<9;i++) {
						if ((i != row) && // Skip cell itself
							(cell[i][column].getCurrentValue() == cellValue)) {
							// Find an duplicated, collector information and throw Invalid Game exception
							String msg = GameCell.getCellName(row, column) + " and "
									   + GameCell.getCellName(i, column) + " have the same value " 
									   + cellValue + "\n";
							msg = msg + this.toString();
							throw new InvalidGame(msg);
						}
					}
				// Check the same column
					for(int j=0;j<9;j++) {
						if ((j != column) && // Skip cell itself
							(cell[row][j].getCurrentValue() == cellValue)) {
							// Find an duplicated, collector information and throw Invalid Game exception
							String msg = GameCell.getCellName(row, column) + " and "
									   + GameCell.getCellName(row, j) + " have the same value " 
									   + cellValue + "\n";
							msg = msg + this.toString();
							throw new InvalidGame(msg);
						}
					}
					
				// Check the same block
					GameBlock thisBlock = new GameBlock(row, column);
					for(int i=thisBlock.row_start; i<thisBlock.row_end;i++)
					for(int j=thisBlock.column_start;j<thisBlock.column_end;j++) {
						if ((j != column) && // Skip cell itself
							(i != row) &&
							(cell[i][j].getCurrentValue() == cellValue)) {
							// Find an duplicated, collector information and throw Invalid Game exception
							String msg = GameCell.getCellName(row, column) + " and "
									   + GameCell.getCellName(i, j) + " have the same value " 
									   + cellValue + "\n";
							msg = msg + this.toString();
							throw new InvalidGame(msg);
						}
					}
					
				}
			}
		
		return isValid;
	}
	

}
