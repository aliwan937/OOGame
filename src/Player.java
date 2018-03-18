import java.util.Random;
import java.util.Scanner;

public class Player {
	private String playerName;
	private Scanner scan;
	private Position position;
	private int health;
	private int spellPower;
	private int level;
	private int numFight;
	private int numMoves;

	public static void main(String[] args) {
		Player first = new Player();
		Player sec = new Player();
		System.out.println(first);
		System.out.println(sec);

		for (int i = 0; i < 3; i++) {
			System.out.println("\n" +"Loop " + (i + 1) +"\n");
			Random rand = new Random();
			int randomDamage = rand.nextInt(10)+5;
			if (first.isAlive()) {
				first.move();
				first.receiveDamage(randomDamage);
			}
			if (sec.isAlive()) {
				sec.move();
				sec.receiveDamage(randomDamage);
			}

		}
	}

	public Player() {
		health = 40;
		spellPower = 40;
		level = 1;
		numFight = 0;
		numMoves = 0;
		scan = new Scanner(System.in);
		System.out.println("Enter your name:");
		playerName = scan.nextLine();
		position = new Position(1, 1);
	}

	public String getName() {
		return playerName;
	}

	public Position getPosition() {
		return position;
	}

	public int attackPower() {
		return level * spellPower;
	}

	public void newDay() {
		health = 20 * level;
		System.out.println("It's a New Day : " + this.toString());

	}

	public boolean isAlive(){
		if (health > 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean receiveDamage(int damage) {
		health -= damage;
		numFight += 1;
		if (health > 0) {
			System.out.println(playerName + " received " + damage + " damage. Current health: " + health);
			if (numFight % 2 == 0) {
				level += 1;
				System.out.println(playerName + "level up! " + "new attack power " + attackPower());
			}
		} else {
			System.out.println(playerName + " received " + damage + " damage. Dead ");
		}
		return isAlive();
	}

	public void move() {
		numMoves += 1;
		if (numMoves % 3 == 0) {
			newDay();
		}
		System.out.println(playerName + position);
		System.out.println("Enter a how many spaces to move left (-num) or right (+num) ");
		position.moveLeftOrRight(scan.nextInt());
		System.out.println("Enter how many spaces to move down (-num) or up (+num)");
		position.moveUpOrDown(scan.nextInt());

		System.out.println(playerName + " moved to " + position);
	}

	public String toString() {
		return ("Player : " + playerName + " Health : " + health + " level : " + level + " spellPower : " + spellPower
				+ " attackPower : " + attackPower());
	}



}
