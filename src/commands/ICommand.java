package commands;

import marse_rover.MarsRover;

public interface ICommand {

	public void execute(final MarsRover rover);
}
