package h1;

public class Grid {
	
	private Cell[][] gridArray;
	
	public Grid(Cell[] cells, int gridRows, int gridCols) {
		this.gridArray = new Cell[gridRows][gridCols];
		for(int i = 0; i < gridArray.length; i++) {
			for(int j = 0; j < gridArray[i].length; j++) {
				gridArray[i][j] = new Cell(i,j,false);
			}
		}
		for(Cell zelle : cells) {
			int zeile = zelle.getIndexRow();
			int spalte = zelle.getIndexCol();
			if(zeile < gridArray.length && zeile >= 0 && spalte < gridArray[0].length && spalte >= 0) {
				gridArray[zeile][spalte].setAlive(true);
			}
		}		
		for(int i = 0; i < gridArray.length; i++) {
			for(int j = 0; j < gridArray[i].length; j++) {
				gridArray[i][j].countLivingNeighbours(gridArray);
			}
		}
	}
	
	public void computeNextGen() {
		for(int i = 0; i < gridArray.length; i++) {
			for(int j = 0; j < gridArray[i].length; j++) {
				Cell zelle = gridArray[i][j];
				zelle.setAlive(zelle.isAliveNextGen());
			}
		}
		for(int i = 0; i < gridArray.length; i++) {
			for(int j = 0; j < gridArray[i].length; j++) {
				Cell zelle = gridArray[i][j];
				zelle.countLivingNeighbours(gridArray);
			}
		}
	}
	
	public void computeGeneration(int n) {
		while(n > 0) {
			computeNextGen();
			n--;
		}
	}

	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}
	
	
}
