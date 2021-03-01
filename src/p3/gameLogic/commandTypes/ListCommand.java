package p3.gameLogic.commandTypes;

import p3.exceptions.CommandParseException;
import p3.gameLogic.Game;

public class ListCommand extends NoParamCommands{
	private static String commandName = "LIST";
	public static final String helpText = "Prints the list of available plants.";
	
	//Constructor
	public ListCommand() {
		super(commandName, helpText, null);
	}

	//--------------FUNCIONES DEL PROGRAMA--------------------
	//Busca el comando introducido y lo crea si existe uno que coincida, en caso contrario salta un error
	public boolean execute(Game myGame) {
		System.out.println("[S]unflower:  Cost: 20 suncoins Harm: 0");
		System.out.println("[P]eashooter: Cost: 50 suncoins Harm: 1");
		System.out.println("[C]herrybomb: Cost: 50 suncoins Harm: 10");
		System.out.println("[W]allnut: Cost: 50 suncoins Harm: 0");
		return false;
	}

	//Comprueba si el comando introducido es LIST y en ese caso si es correcto, entonces crea el comando
	public Command parse(String[] commandWords) throws CommandParseException{
		Command list = null;
		if(commandWords[0].equals("L") || commandWords[0].equals("LIST")) { 
			if (commandWords.length == 1) {list = new ListCommand(); }
			else throw new CommandParseException("List command has no arguments");		
		}
		return list;
	}
	
}