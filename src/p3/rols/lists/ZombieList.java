package p3.rols.lists;

import p3.PlantsVsZombies;
import p3.rols.plants.types.CherryBomb;
import p3.rols.zombies.Zombie;

public class ZombieList {

	//Inicializar array de zombies
	Zombie[] zList = new Zombie[PlantsVsZombies.MAX_ZOMBIES];
	private int zombiesNumber;
	
	//Constructor
	public ZombieList(){
		zombiesNumber = 0;
		
	}
	
	//-------------------FUNCIONES DEL PROGRAMA-----------------
	//Update de todos los zombies
	public void update(){
		for(int i = 0; i < zombiesNumber; i++){
			zList[i].update();
			
		}
	}
	
	//Parece que no lo necesitamos, devuelve la posicion dadas las coordenadas
	public int isHere(int x, int y){
		int pos = -1;
		int cont = 0;
		boolean found = false;
		while ((cont < this.zombiesNumber) && (!found)) {
			if((this.getZombieByPos(cont).getX() == x) && (this.getZombieByPos(cont).getY() == y))
			{found = true; pos = cont;}
			cont++;
		}
		return pos;
	}
		



	//Daño de peashooter
	public void takeShoot(int x, int y) {
		int pos = 0;
		boolean found = false, dead;
		while((pos < this.zombiesNumber) && !found) {
			if((this.zList[pos].getX() == x) && (this.zList[pos].getY() > y)) {
				dead = this.zList[pos].damaged(1);
				if(dead) {
					for(int i = pos; i < this.zombiesNumber - 1; i++){
						this.zList[i] = this.zList[i + 1];
					}
					this.zombiesNumber--;
				}
				found = true;
			}
			pos++;
		}
	}
	
	//Daño de petacereza
	public void takeXplosion(int x, int y) {
		int pos = 0;
		boolean dead;
		CherryBomb aux = new CherryBomb(); //para coger el daño, esto solo funciona con cherrybomb
		

		while((pos < this.zombiesNumber)) {
			//La unica manera de que funcione correctamente es comprobar todas las posiciones por separado
			if((this.zList[pos].getX() == x-1) && (this.zList[pos].getY() == y)) {dead = this.zList[pos].damaged(aux.getDamage()); if(dead) {deleteZombie(this.zList[pos], pos);}} //ESTO TIENE QUE SER DELETEZOMBIE Y ENTONCES CREO QUE VA EN GAME
			if((this.zList[pos].getX() == x) && (this.zList[pos].getY() == y-1)) {dead = this.zList[pos].damaged(aux.getDamage()); if(dead) {deleteZombie(this.zList[pos], pos);}}
			if((this.zList[pos].getX() == x) && (this.zList[pos].getY() == y+1)) {dead = this.zList[pos].damaged(aux.getDamage()); if(dead) {deleteZombie(this.zList[pos], pos);}}
			if((this.zList[pos].getX() == x+1) && (this.zList[pos].getY() == y)) {dead = this.zList[pos].damaged(aux.getDamage()); if(dead) {deleteZombie(this.zList[pos], pos);}}
			pos++;
		}
	}
	
	//Elimina un zombie de una lista
	void deleteZombie(Zombie z, int pos) {
		for(int j = pos; j < this.zombiesNumber - 1; j++){
			this.zList[j] = this.zList[j + 1];
		}
		this.zombiesNumber--;	
	}
	
	public boolean checkLoose() {
		
		int pos = 0;
		boolean found = false;
		while(pos < (this.zombiesNumber) && !found) {
			found = (this.zList[pos].getY() == 0);
			pos++;
		}
		
		return found;
	}
	
	public Zombie getZombieByCoord(int x, int y) {
		
		Zombie found = null;
		for(int pos = 0; pos < this.zombiesNumber; pos++) {
			if((this.zList[pos].getX() == x) && (this.zList[pos].getY() == y)) {found = this.zList[pos];}
		}
		return found;
	}
	
	public void loadZombie(int i, int life, int x, int y, int remCycles) {
		this.zList[i].setLife(life);
		this.zList[i].setX(x);
		this.zList[i].setY(y);
		this.zList[i].setRemainingCycles(remCycles);
	}

	//-------------------AUXILIAR-----------------
	public void setNewZombie(Zombie z1) {
		this.zList[this.zombiesNumber] = z1;
		this.zombiesNumber++;
		
	}

	public int getPosX(int pos) {
		return zList[pos].getX();
	}
	
	public int getPosY(int pos) {
		return zList[pos].getY();
	}
	
	public String toString(int i, boolean isDebug) {
		
		return this.zList[i].toString(isDebug);
		
	}
	
	public int getZNumber() {
		return this.zombiesNumber;
	}
	
	public Zombie getZombieByPos(int pos) {
		return this.zList[pos];
	}
	
	public String externalise(int i) {
		return this.zList[i].externalise();
	}



}
