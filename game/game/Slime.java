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
		Thread slimeThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("It looks like a green liquid");
				try {
					for(int i= 0; i< 3; i++) {
						System.out.println(name + " is bouncing");
						if (hp <=0) {
							break;
						}
						
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e) {
					System.out.println(name + "has been interrupted!");
				}
				System.out.println(name + "has been summoned");
			}
			
		});
		slimeThread.start();
		
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
