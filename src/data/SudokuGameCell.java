package data;

import org.junit.Test;

public class SudokuGameCell {
	int currentValue = 0;
	int gameValue = 0;
	Boolean candidate[] = {true,true,true,true,true,true,true,true,true};
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public String toString(){
		return ("current: " + currentValue + " game: " + gameValue);
	}
	
	@Test
	public void test () {
		SudokuGameCell mycell = new SudokuGameCell();
		mycell.print();
	}
}
