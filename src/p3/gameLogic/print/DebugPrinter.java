package p3.gameLogic.print;

import p3.gameLogic.Game;

public class DebugPrinter extends BoardPrinter {
	
	//Constructor
	public DebugPrinter(String board[][], String information) {
		super(board, information);
	}

	//--------------FUNCIONES DEL PROGRAMA--------------------
	//Codifica un String con la información del juego en modo Debug
	public void encodeGame(Game myGame) {
		
		int i,j;
		int contador = 0;
		
		for (i = 0; i < myGame.getPlantCount(); i++) {
			this.board[i][0] = myGame.getPlantByPos(contador, true);
			contador++;
		}
		contador = 0;
		for (j = i; contador < myGame.getZombieCount(); j++) {
			this.board[j][0] = myGame.getZombieByPos(contador, true);
			contador++;
		}
		
		information = myGame.gameInformation();
	}
	
	//Muestra que modo de juego pintará y hace el encode 
	public String printGame(Game myGame) {
		encodeGame(myGame);
		int aux = myGame.getPlantCount() + myGame.getZombieCount();
		return this.boardToString(myGame, 27, aux, 1, true);
	}
	
	
}