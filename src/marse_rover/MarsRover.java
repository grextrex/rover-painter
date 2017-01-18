package marse_rover;

import java.util.List;

import commands.ICommand;
import parser.StringCommandParser;
import universe.Color;
import universe.Coordinates;
import universe.Direction;
import universe.Plateau;
import universe.RoverGrid;

public class MarsRover {

    private Coordinates currentCoordinates;
    private Direction currentDirection;
    private Plateau plateau;
    private Color color;
    
    public MarsRover(final Plateau plateau, final Direction direction, final Coordinates coordinates,final Color color) {
        this.plateau = plateau;
        this.currentDirection = direction;
        this.currentCoordinates = coordinates;
        this.color = color;
    }
    
    public void run(final String commandString) {
        List<ICommand> roverCommands = new StringCommandParser(commandString).toCommands();
       
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
    }
    
    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }
    
    public void turnRight() {
        this.currentDirection = this.currentDirection.right();
    }
    
    public void color() {
    	if(plateau.hasWithinBounds(this.currentCoordinates))
    	RoverGrid.installColor(this.currentCoordinates, this.color.toString());

    }

    public void getGlassPattern() {
    	RoverGrid.getRoverGrid();
    }

    
    public void turnLeft() {
        this.currentDirection = this.currentDirection.left();
    }
    
    public void move() {
        Coordinates positionAfterMove = currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());

        //ignores the command if rover is being driven off plateau
        if(plateau.hasWithinBounds(positionAfterMove))
            currentCoordinates = currentCoordinates.newCoordinatesFor(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());
    }
}
