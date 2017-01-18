import java.util.Scanner;

import marse_rover.MarsRover;
import universe.Color;
import universe.Coordinates;
import universe.Direction;
import universe.Plateau;
import universe.RoverGrid;

public class MarsRoverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("enter rover X axis");

		Scanner rover_gridX = new Scanner(System.in);
		int x = rover_gridX.nextInt();
		
		System.out.println("enter rover y axis");
		
		Scanner rover_gridY = new Scanner(System.in);
		int y = rover_gridY.nextInt();
		
		new RoverGrid(x,y);
		
		System.out.println("enter rover initial X pos");
		
		Scanner initial_posX = new Scanner(System.in);
		int xCoordinate = initial_posX.nextInt();

		System.out.println("enter rover initial Y pos");
		
		Scanner initial_posY = new Scanner(System.in);
		int yCoordinate = initial_posY.nextInt();
		
		System.out.println("enter rover initial Direction");
		
		Scanner direc = new Scanner(System.in);
		String dr = direc.nextLine();

		System.out.println("enter rover color");
		
		Scanner color = new Scanner(System.in);
		String clr = color.nextLine();

		System.out.println("enter rover command");
		
		Scanner command = new Scanner(System.in);
		String cmd = command.nextLine();

		Plateau plateau = new Plateau(x, y);
		

		Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);

		MarsRover rover = new MarsRover(plateau, Direction.valueOf(dr), coordinates, Color.valueOf(clr));

		
		rover.run(cmd);
		
		MarsRover rover2 = new MarsRover(plateau, Direction.N, new Coordinates(1, 2), Color.G);

		rover2.run("MMIRMMMIRMIMMRMMLI");
		
		System.out.println(rover.currentLocation());

		rover2.getGlassPattern();
		
	}

}
