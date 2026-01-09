package h1;

public class H1_Main {

	public static void main(String[] args) {
		Cell[] cells = {new Cell(0,3), new Cell(0,4), new Cell(0,5), new Cell(1,1), new Cell(1,3), new Cell(2,1), new Cell(2,4)};
		Grid spiel = new Grid(cells,3,6);
		Cell[][] grid = spiel.getGridArray();
		spiel.computeGeneration(4);
		for(int i = 0; i < grid.length; i++) {
			System.out.println();
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j].isAlive()) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
		}
	}
	
}
