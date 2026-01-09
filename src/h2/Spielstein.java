package h2;

public class Spielstein {

	private int currentRow;
	private int currentCol;
	private Spielbrett brett;
	
	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		setCurrentRow(indexRow);
		setCurrentCol(indexCol);
		setBrett(brett);
	}
	
	private boolean movesOut() {
		char curFeldDir = brett.getBrett()[currentRow][currentCol].getDirection();
		if((currentRow == 0 && curFeldDir == 'U') || 
			(currentRow == brett.getDim() - 1 && curFeldDir == 'D') ||
			(currentCol == 0 && curFeldDir == 'L') ||
			(currentCol == brett.getDim() - 1 && curFeldDir == 'R')) {
			return true;
		}else {
			return false;
		}
	}
	
	public void go(int n) {
		while(n > 0) {
			Feld curFeld = brett.getBrett()[currentRow][currentCol];
			char curFeldDir = curFeld.getDirection();
			if(!curFeld.isBoese()) {
				if(!movesOut()) {
					if(curFeldDir == 'U') currentRow -= 1;
					else if(curFeldDir == 'D') currentRow += 1;
					else if(curFeldDir == 'L') currentCol -= 1;
					else if(curFeldDir == 'R') currentCol += 1;
				}
			}
			n--;
		}
	}
	
	public int getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	public int getCurrentCol() {
		return currentCol;
	}
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	public Spielbrett getBrett() {
		return brett;
	}
	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}
	
	
}
