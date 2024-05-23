package game;

public class Octopus extends Monster {
	public Octopus() {
		name = "octopus";
		region = "shadowcity";
		hp = 200;
		holdGold = 700;
		monsterAdd();		
		
	}
	
	public void monsterAdd() {
		Thread octopusThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("It looks like a octopus");
				try {
					for(int i= 0; i< 3; i++) {
						System.out.println(name + " is going to kill you");
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
		octopusThread.start();
	}
	public void monsterDie() {
		System.out.println("The monster dropped "+holdGold);
		this.holdGold = 0;
		this.hp = 0;
	}
	public void monsterAttack() {
		System.out.println("Octopus leg attack!!");
		System.out.println("it stoled your money for 700");
		this.holdGold += 700;
	}
	public void monsterAttack2() {
		System.out.println("The octopus moved your region to ferrion");
		
	}
}


