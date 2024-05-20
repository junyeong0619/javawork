package game;

public class Slime extends Monster {
	
	public Slime() {
		name = "slime";
		region = "henesis";
		hp = 50;
		holdGold = 500;
		monsterAdd();		
		
	}
	
	public void monsterAdd() {
		System.out.println("It looks like a green liquid");
	}
	public void monsterDie() {
		System.out.println("The monster dropped "+holdGold);
		this.holdGold = 0;
		this.hp = 0;
	}
	public void monsterAttack() {
		System.out.println("Slime attack your face!");
		System.out.println("Slime stole your money for 200");
		this.holdGold += 200;
	}
	public void monsterAttack2() {
		System.out.println("Slime reset your game byebye!");
		
	}
}
