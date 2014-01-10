package data;

import org.junit.Test;

public class GameCell {
	public int currentValue = 0;
	public int gameValue = 0;
	Boolean candidate[] = {true,true,true,true,true,true,true,true,true};
	int candidates = 9;
	
	public GameCell() {
		super();
	}

	public void print() {
		System.out.println(this.toString());
	}
	
	public String toString(){
		return ("current: " + currentValue + " game: " + gameValue);
	}
	
	public void setCurrentValue(int value) {
		if ( (0 <= value) || ( 9 > value) ) { 
			currentValue = value;
			gameValue = 0;
		}
		
	}
	
	public void setGameValue(int value) {
		if ( (0 <= value) || ( 9 > value) ) { 
			gameValue = value;
			currentValue = 0;
		}
	}
	
	public void selectCandidate(int value) {
		if ( (0 <= value) || ( 9 > value) ) { 
			candidate[value] = true;
		}
		
	}
	public void deselectCandidate(int value) {
		if ( (0 <= value) || ( 9 > value) ) { 
			candidate[value] = false;
		}
		
	}
	@Test
	public void test () {
		GameCell mycell = new GameCell();
		mycell.print();
	}
}
