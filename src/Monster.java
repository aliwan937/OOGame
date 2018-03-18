import java.util.Random;

public class Monster {
	private String name;
	private Position position;
	private int health;
	private int spellPower;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monster john = new Monster("John", new Position(3,2), 100, 20);
		Monster anna = new Monster("Anna", new Position(1,3), 100, 20);
		System.out.println(john);
		System.out.println(anna);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("\n" +"Loop " + (i + 1) +"\n");
			Random rand = new Random();
			int randomDamage = rand.nextInt(10)+5;
			if (john.isAlive()) {
				john.receiveDamage(randomDamage);
				System.out.println(john);
			}
			if (anna.isAlive()) {
				anna.receiveDamage(randomDamage);
				System.out.println(anna);
			}
		}

	}

	public Monster(String name,
			Position position,
			int health,
			int spellPower){
		this.name = name;
		this.position = position;
		this.health = health;
		this.spellPower = spellPower;

	}

	public String getName(){return name;}
	public Position getPosition(){return position;}

	public String toString(){
		return "Monster: " + name + " health: " + health + ", Power: " + spellPower;
	}

	public int attackPower(){
		return spellPower;
	}

	public boolean isAlive(){
		if (health > 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean receiveDamage(int damage){
		health -= damage;
		if (isAlive()){
			System.out.println(name + " received " + damage + " damage. Current health: " + health);
		}
		else{
			System.out.println(name + " received " + damage + " damage. Current health: " + "DEAD");
			position = null;
		}
		return this.isAlive();
	}


}