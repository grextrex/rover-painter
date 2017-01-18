package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.ICommand;
import commands.InstallColor;
import commands.MoveCommand;
import commands.RotateLeftCommand;
import commands.RotateRightCommand;

public class StringCommandParser {
	public static final String BY_EACH_CHARACTER = "";
	public static final int START_INDEX = 1;

	private static Map<String, ICommand> stringToCommandMap = new HashMap<String, ICommand>() 
	{{
		put("L", new RotateLeftCommand());
		put("R", new RotateRightCommand());
		put("M", new MoveCommand());
		put("I", new InstallColor());
	}};

	private String commandString;

	public StringCommandParser(final String commandString) {
		this.commandString = commandString;
	}

	public List<ICommand> toCommands() {
		
		if(isNullOrEmpty(commandString)) return new ArrayList<ICommand>();
		return buildCommandsList(commandString);
	}


	private List<ICommand> buildCommandsList(final String commandString) {
		List<ICommand> commands = new ArrayList<ICommand>();

		for(String commandCharacter : commandCharactersFrom(commandString)) {
			if (commandCharacter == null) break;
			ICommand mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
			commands.add(mappedCommand);
		}

		return commands;
	}

	private boolean isNullOrEmpty(final String commandString) {
		return (null == commandString || commandString.trim().length() == 0);
	}


	private String[] commandCharactersFrom(final String commandString) {
		return Arrays.copyOfRange(commandString.split(BY_EACH_CHARACTER), START_INDEX, commandString.length()+1);
	}

	private ICommand lookupEquivalentCommand(final String commandString) {
		return stringToCommandMap.get(commandString);
	}

}
