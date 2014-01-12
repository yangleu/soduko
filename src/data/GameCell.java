package data;

import misc.GameFactory;

import org.junit.Test;

public class GameCell {
	public int currentValue = 0;
	public int gameValue = 0;
	Boolean candidate[] = {true,true,true,true,true,true,true,true,true};
	int candidates = 9;
	
	public GameCell() {
		super();
	}

	
	public String toString(){
		String rslt = "current: " + currentValue + " game: " + gameValue;
		if((0==currentValue) && (0==gameValue) ) {
			rslt = rslt + " Candidates: ";
			for(int i=0;i<9;i++) 
				if (candidate[i]) rslt = rslt + (i+1);
		}

		return (rslt);
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
		if ( (0== gameValue) && ( (0 < value) && ( 9 >= value) ) ){ 
			candidate[value-1] = true;
			candidates++;
			if (2 == candidates)  // The cell becomes not determined from determined
				setCurrentValue(0);
			
		}
		
	}
	
	public static String getCellName(int row, int column) {
		String rslt = "Cell(" + (row +1) + "," + (column+1) +")";
		return rslt;
	}


	public void deselectCandidate(int value) {
		if (! candidate[value-1]) return;
		if ((0==gameValue) && ( (0 < value) && ( 9 >= value) ) ){
			candidate[value-1] = false;
			candidates--;
			if (1 == candidates) { // The cell becomes determined
				int i =0;
				while (! candidate[i]) i++;
				setCurrentValue(i + 1);
			} else if (0==candidates) 
				this.selectCandidate(value-1);
		}
		
	}
	
	public void deselectCandidate(int logLevel, int value, int row, int column) {
		if (! candidate[value-1]) return;
		if ((0==gameValue) && ( (0 < value) && ( 9 >= value) ) ){
			GameFactory.log(logLevel, "Deleting " + value + " from " + this.getCellName(row, column));
			GameFactory.log(logLevel+1, "Old: " + toString());

			candidate[value-1] = false;
			candidates--;
			if (1 == candidates) { // The cell becomes determined
				int i =0;
				while (! candidate[i]) i++;
				setCurrentValue(i + 1);
			} else if (0==candidates) 
				this.selectCandidate(value-1);
			GameFactory.log(logLevel+1, "Now: " + toString());
		}
		
	}
	
	public void setCandidateStatus(int logLevel, boolean select, int row, int column) {
		if (select) selectCandidate(row*3+column+1);
		else deselectCandidate(row*3+column+1);
	}
	
	public int getCurrentValue(){
		if (0!= gameValue) return gameValue;
		if (0!= currentValue) return currentValue;
		else return 0;
	} 
	
}
