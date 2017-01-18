package commands;

import marse_rover.MarsRover;

public class RotateRightCommand implements ICommand{

	@Override
	public void execute(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.turnRight();
	}

}
