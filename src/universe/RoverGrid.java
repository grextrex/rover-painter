package universe;


public class RoverGrid {


	static String roverGrid[][];
	static int topRow,topCol;


	public RoverGrid(int topRightXCoordinate, int topRightYCoordinate) {
		// TODO Auto-generated constructor stub
		roverGrid = new String[topRightYCoordinate][topRightXCoordinate];

		topRow = topRightYCoordinate;
		topCol = topRightXCoordinate;
		for(int i=0; i< topRow; i++) {

			for(int j=0; j<topCol; j++) {

				roverGrid[i][j] = Color.E.toString();
			}

		}

	}


	public static void installColor(Coordinates coordinate, String color){

		if(roverGrid[(topRow- 1 - coordinate.getYcoordinate())][coordinate.getXcoordinate()] == "E")

			roverGrid[(topRow -1 - coordinate.getYcoordinate())][coordinate.getXcoordinate()] = color;

		else
			roverGrid[(topRow - 1 - coordinate.getYcoordinate())][coordinate.getXcoordinate()] = Color.Y.toString();
	}

	public static void getRoverGrid() {
		for(int i=0; i< topRow; i++) {

			for(int j=0; j<topCol; j++) {

				System.out.print(" "+ roverGrid[i][j]);
			}
			System.out.println();
		}

	}

}
