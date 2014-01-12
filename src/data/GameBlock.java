package data;

public class GameBlock {
	public int row_start=0, row_end=0, column_start=0, column_end=0;
	
	public GameBlock(int row, int column) throws InvalidGameBlock {
		try {
			if ( (0>row) || (8<row) ) throw new InvalidGameBlock("Invalid row: " + row);
			if ( (0>column) || (8<column) ) throw new InvalidGameBlock("Invalid column: " + column);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
		
		row_start=(row / 3) * 3;
		row_end = (row / 3) * 3 + 2;
		column_start=(column / 3) * 3;
		column_end=(column / 3) * 3 + 2;
	// Debug
//		System.err.println(GameCell.getCellName(row, column) + "'s block" 
//				   + "\n\t row_start " + row_start
//				   + "\n\t row_end " + row_end
//				   + "\n\t column_start " + column_start
//				   + "\n\t row_end " + row_end
//						   );
	}

}
