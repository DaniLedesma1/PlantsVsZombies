package p3.rols.zombies;

import p3.gameLogic.Game;
import p3.rols.zombies.types.BucketHeadZombie;
import p3.rols.zombies.types.CommonZombie;
import p3.rols.zombies.types.SportZombie;

public class ZombieFactory {

	private static Zombie[] availableZombies = {
			new CommonZombie(),
			new BucketHeadZombie(),
			new SportZombie()
		
	};
	
	//-------------------FUNCIONES DEL PROGRAMA-----------------
	public static Zombie getZombie(String zombieName, int x, int y, Game game){
		Zombie newZombie = null;
		
		switch(zombieName) {
		case "SPORTZOMBIE": case "X": newZombie = new SportZombie(x, y, game);
		break;
		case "COMMONZOMBIE": case "N": newZombie = new CommonZombie(x, y, game);
		break;
		case "BUCKETHEADZOMBIE": case "B": newZombie = new BucketHeadZombie(x, y, game);
		break;
		}
		
		
		return newZombie;
	}
	
	
}
