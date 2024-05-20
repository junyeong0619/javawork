package game;

public class Pig extends Monster {
	public Pig() {
		name = "pig";
		region = "elinia";
		hp = 10;
		holdGold = 10;
		monsterAdd();		
		
	}
	
	public void monsterAdd() {
		System.out.println("It looks like a pig");
	}
	public void monsterDie() {
		System.out.println("The monster dropped "+holdGold);
		this.holdGold = 0;
		this.hp = 0;
	}
	public void monsterAttack() {
		System.out.println("The pig bites you");
		System.out.println("Pig give you extra money for 1000!!");
		this.holdGold += 1000;
	}
	public void monsterAttack2() {
		System.out.println("The pig moved your region to henesis");
		
	}
}


