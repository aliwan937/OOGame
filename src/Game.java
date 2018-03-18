
import java.util.ArrayList;

public class Game {
	Player player;
	ArrayList<Monster> monsters;

	public Game() {
		player = new Player();
		monsters = new ArrayList<Monster>();

		Monster first = new Monster("first", new Position(0,1), 15, 2);
		Monster second = new Monster("second", new Position(2, 3), 25, 4);
		Monster third = new Monster("third", new Position(2, 3), 35, 6);

		monsters.add(first);
		monsters.add(second);
		monsters.add(third);

	}

	public static void main(String args[]){
		Game newGame = new Game();
		newGame.playGame();
	}
	public Monster findMonster(Position pos) {
		for (Monster search : monsters) {
			if (pos.equals(search.getPosition())) {
				return search;
			}
		}
		return null;
	}

	public boolean playTurn() {
		player.move();
		Monster foundedMonster = findMonster(player.getPosition());
		if (foundedMonster == (null)) {
			return true;
		} else {
			System.out.println(player.getName() + " finds a " + foundedMonster.getName());
		}
		while (player.isAlive() && foundedMonster.isAlive()) {
			foundedMonster.receiveDamage(player.attackPower());
			player.receiveDamage(foundedMonster.attackPower());
		}
		if (foundedMonster.isAlive()) {
			System.out.println(foundedMonster.getName() + " killed " + player.getName());
		} else if (player.isAlive()) {
			System.out.println(player.getName() + " killed " + foundedMonster.getName());	
		} else{
			System.out.println("Everyone is dead");
		}
		if(player.isAlive()){
			return true;
		}
		return false;
	}
	public boolean anyMoreMonsters(){
		for(Monster search: monsters){
			if(search.isAlive()){
				return true;
			}
		}
		return false;
	}
	public void playGame(){
		while(player.isAlive() && anyMoreMonsters()){
			playTurn();
		}
		if(!(player.isAlive())){
			System.out.println(player.getName() + "Lost");
		}
		else{
			System.out.println(player.getName() + "Won");
		}
	}

}
