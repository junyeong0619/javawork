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
		Thread pigThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("It looks like a pig");
				try {
					for(int i= 0; i< 3; i++) {
						System.out.println(name + " is crying sadly");
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
		pigThread.start();
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


