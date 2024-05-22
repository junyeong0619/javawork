package game;

import java.util.Scanner;

public class World extends Character {
	String region;
	Scanner scanner = new Scanner(System.in);
	int num = 0;
	int breadNum = 0;
	int waterNum = 0;

	public World(String name, String stats, String jobtype) {
		super(name, stats);
		this.showInfo();
		this.getJob();
		if (jobtype.equals("warrior")) {
			this.region = "ferrion";
		} else if (jobtype.equals("archor")) {
			this.region = "henesis";
		} else if (jobtype.equals("magician")) {
			this.region = "elinia";
		} else if (jobtype.equals("thief")) {
			this.region = "shadowcity";
		} else {
			String nothing;
		}
		this.bagExtend();
	}

	public void showShop() {
		System.out.println("Enter 1 = bread(1000) , 2 = water(500)");
		num = scanner.nextInt();
		switch (num) {
		case 1:
			if (this.money >= 1000) {
				this.money = this.money - 1000;
				if (this.breadNum < 5) {
					this.breadNum = this.breadNum + 1;
				}
				if (this.bag[0][0] == null) {
					this.bag[0][0] = "bread";
				} else if (this.bag[0][1] == null) {
					this.bag[0][1] = "bread";
				} else if (this.bag[0][2] == null) {
					this.bag[0][2] = "bread";
				} else if (this.bag[0][3] == null) {
					this.bag[0][3] = "bread";
				} else {
					System.out.println("Out of stock");
					this.money += 1000;
				}
				System.out.println("You bought a bread");
				System.out.println("You have " + this.breadNum);
				System.out.println("You have" + this.money);
				break;
			} else {
				System.out.println("Failed to buy");
				break;
			}

		case 2:
			if (this.money >= 500) {
				this.money = this.money - 500;
				if (this.waterNum < 5) {
					this.waterNum = this.waterNum + 1;
				}
				if (this.bag[0][0] == null) {
					this.bag[0][0] = "water";
				} else if (this.bag[0][1] == null) {
					this.bag[0][1] = "water";
				} else if (this.bag[0][2] == null) {
					this.bag[0][2] = "water";
				} else if (this.bag[0][3] == null) {
					this.bag[0][3] = "water";
				} else {
					System.out.println("Out of stock");
					this.money += 500;
				}
				System.out.println("You bought a water");
				System.out.println("You have " + this.waterNum);
				System.out.println("You have= " + this.money);
				break;
			} else {
				System.out.println("Failed to buy");
				break;
			}
		}
		this.showBag();

	}

	public void regionShow() {
		System.out.println("Your region is " + this.region);
		System.out.println("Enter 1 = ferrion , 2 = henesis , 3 = elinia , 4 = shadowcity, 5 = none");
		num = scanner.nextInt();
		switch (num) {
		case 1:
			this.region = "ferrion";
			System.out.println("You now moved to ferrion");
			break;
		case 2:
			this.region = "henesis";
			System.out.println("You now moved to henesis");
			break;
		case 3:
			this.region = "elinia";
			System.out.println("You now moved to elinia");
			break;
		case 4:
			this.region = "shadowcity";
			System.out.println("You now moved to shadowcity");
			break;
		case 5:
			// this.region = this.region;
			System.out.println("You didn't move to anywhere");
			break;
		}

	}

	public void showBag() {
		System.out.println("In my bag water =" + waterNum + " bread = " + breadNum);
		for (int i = 0; i < 4; i++) {
			System.out.println(this.bag[0][i]);
		}
		System.out.println("Your money is =" + this.money);
	}

	public void eatFood() {
		String food;
		System.out.println("What you want to eat? [bread,water]");
		food = scanner.nextLine();
		if (food.equals("bread")) {
			if (this.breadNum > 0) {
				this.breadNum -= 1;
				if (this.bag[0][0] == "bread") {
					this.bag[0][0] = null;
					System.out.println("Successfully eat Bread!");
				} else if (this.bag[0][1] == "bread") {
					this.bag[0][1] = null;
					System.out.println("Successfully eat Bread!");
				} else if (this.bag[0][2] == "bread") {
					this.bag[0][2] = null;
					System.out.println("Successfully eat Bread!");
				} else if (this.bag[0][3] == "bread") {
					this.bag[0][3] = null;
					System.out.println("Successfully eat Bread!");
				} else {
					System.out.println("You don't have any bread");
				}
			}

		} else if (food.equals("water")) {
			if (this.waterNum > 0) {
				this.waterNum -= 1;
				if (this.bag[0][0] == "water") {
					this.bag[0][0] = null;
					System.out.println("Sucessfully eat Water");
				} else if (this.bag[0][1] == "water") {
					this.bag[0][1] = null;
					System.out.println("Sucessfully eat Water");
				} else if (this.bag[0][2] == "water") {
					this.bag[0][2] = null;
					System.out.println("Sucessfully eat Water");
				} else if (this.bag[0][3] == "water") {
					this.bag[0][3] = null;
					System.out.println("Sucessfully eat Water");
				} else {
					System.out.println("You don't have any Water");
				}
			}
		} else {
			System.out.println("You wrote wrong word!");
			this.eatFood();
		}

	}
}