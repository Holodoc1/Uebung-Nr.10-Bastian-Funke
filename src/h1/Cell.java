package h1;

public class Cell {
	
	private int indexRow;
	private int indexCol;
	private boolean alive;
	private int numLivingNeighbours;
	private boolean isAliveNextGen;
	
	public Cell(int indexRow, int indexCol, boolean alive) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
		setAlive(alive);
	}
	
	public Cell(int indexRow, int indexCol) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
	}
	
	public void countLivingNeighbours(Cell[][] gridArray) {
		int rowLimit = gridArray.length;
		int colLimit = gridArray[0].length;
		Cell zelle = gridArray[indexRow][indexCol];
		int zeile = zelle.getIndexRow();
		int spalte = zelle.getIndexCol();
		int neighbours = 0;
		for(int i = zeile - 1; i <= zeile + 1; i++) {
			for(int j = spalte - 1; j <= spalte + 1; j++) {
				if(i >= 0 && j >= 0 && i < rowLimit && j < colLimit && !(i == zeile && j == spalte)) {
					Cell neighbour = gridArray[i][j];
					if(neighbour.isAlive()) {
						neighbours++;
					}
				}
			}
		}
		numLivingNeighbours = neighbours;
		decideNextStatus();
	}
	
	private void decideNextStatus() {
		if(alive) {
			if(numLivingNeighbours == 2 || numLivingNeighbours == 3) {
				isAliveNextGen = true;
			}else {
				isAliveNextGen = false;
			}
		}else {
			if(numLivingNeighbours == 3) {
				isAliveNextGen = true;
			}else {
				isAliveNextGen = false;
			}
		}
	}
	
	public int getIndexRow() {
		return indexRow;
	}
	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}
	public int getIndexCol() {
		return indexCol;
	}
	public void setIndexCol(int indexCol) {
		this.indexCol = indexCol;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getNumLivingNeighbours() {
		return numLivingNeighbours;
	}
	public void setNumLivingNeighbours(int numLivingNeighbours) {
		this.numLivingNeighbours = numLivingNeighbours;
	}
	public boolean isAliveNextGen() {
		return isAliveNextGen;
	}
	public void setAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}
	
	
}
