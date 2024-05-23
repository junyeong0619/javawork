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
		Thread stumpThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("It looks like a wood");
				try {
					for(int i= 0; i< 3; i++) {
						System.out.println(name + " is crawling to you");
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
		stumpThread.start();
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


