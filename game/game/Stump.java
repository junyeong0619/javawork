package game;

public class Stump extends Monster {
	public Stump() {
		name = "stump";
		region = "ferrion";
		hp = 100;
		holdGold = 200;
		monsterAdd();		
		
	}
	
	public void monsterAdd() {
		System.out.println("It looks like a wood");
	}
	public void monsterDie() {
		System.out.println("The monster dropped "+holdGold);
		this.holdGold = 0;
		this.hp = 0;
	}
	public void monsterAttack() {
		System.out.println("Stump shoot out its hand");
		System.out.println("Slime stole your money for 500");
		this.holdGold += 500;
	}
	public void monsterAttack2() {
		System.out.println("Stump reset your game byebye!");
		
	}
}


