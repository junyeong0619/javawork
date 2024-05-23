package game;

import java.util.Scanner;

public class GameStart {
	public static void main(String[] args) {
		Character character = null;
		Scanner scanner = new Scanner(System.in);
		String food = " ";
		String enterFlag = "";
		String skillType = " ";
		String jobType = " ";
		System.out.println("Enter your Name:");
		String name = scanner.nextLine();
		System.out.println("Enter your Stat among those one [Str,Dex,Int,Luk]:");
		String stats = scanner.nextLine();

		if (stats.equals("Str")) {
			character = new Warrior(name, stats);
			jobType = "warrior";
		} else if (stats.equals("Dex")) {
			character = new Archor(name, stats);
			jobType = "archor";
		} else if (stats.equals("Int")) {
			character = new Magician(name, stats);
			jobType = "magician";
		} else if (stats.equals("Luk")) {
			character = new Thief(name, stats);
			jobType = "thief";
		}

		World world = new World(name, stats, jobType);
		/*
		System.out.println("Enter y/n to go shop:");
		enterFlag = scanner.nextLine();

		if (enterFlag.equals("y")) {
			world.showShop();
		} else {
			System.out.println("Nothing");
		}

		System.out.println("Enter y/n to show your region:");
		enterFlag = scanner.nextLine();

		if (enterFlag.equals("y")) {
			world.regionShow();
		} else {
			System.out.println("Nothing");
		}
		*/
		while (world.hp > 0) {
			if (character != null) {
				world.showHP();
				System.out.println("shop , region, fight, eat");
				skillType = scanner.nextLine();
				if (skillType.equals("shop")) {
					world.showShop();
				} else if (skillType.equals("region")) {
					world.regionShow();
				} else if (skillType.equals("q") || skillType.equals("w") || skillType.equals("e")
						|| skillType.equals("r")) {
					character.useSkill(skillType);
					System.out.println("Enter quit to quit");
				} else if (skillType.equals("fight")) {
					if (world.region.equals("henesis")) {
						Monster monster = new Slime();
						while (monster.hp != 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								monster.monsterDie();
								world.money += 500;
								break;
							} else if (skillType.equals("w")) {
								monster.monsterAttack();
								world.getDamage(10);
								world.money -= 200;
								break;
							} else if (skillType.equals("e")) {
								monster.monsterAttack2();
								world.getDamage(101);
							} else {
								System.out.println("nothing happened");
								break;
							}
						}
					} else if (world.region.equals("ferrion")) {
						Monster monster = new Stump();
						while (monster.hp != 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								monster.monsterDie();
								world.money += 500;
								break;
							} else if (skillType.equals("w")) {
								monster.monsterAttack2();
								world.getDamage(101);

							} else if (skillType.equals("e")) {
								monster.monsterAttack();
								world.getDamage(20);
								world.money -= 500;
								break;

							} else {
								System.out.println("nothing happened");
								break;
							}
						}
					} else if (world.region.equals("elinia")) {
						Monster monster = new Pig();
						while (monster.hp != 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								monster.monsterDie();
								world.money += 10;
								break;
							} else if (skillType.equals("w")) {
								monster.monsterAttack2();
								world.getDamage(40);
								world.region = "henesis";
								break;

							} else if (skillType.equals("e")) {
								monster.monsterAttack();
								world.getDamage(70);
								world.money += 1000;
								break;

							} else {
								System.out.println("nothing happened");
								break;
							}
						}
					} else if (world.region.equals("shadowcity")) {
						Monster monster = new Octopus();
						while (monster.hp != 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								monster.monsterDie();
								world.money += 700;
								break;
							} else if (skillType.equals("w")) {
								monster.monsterAttack2();
								world.getDamage(5);
								world.region = "ferrion";
								break;

							} else if (skillType.equals("e")) {
								monster.monsterAttack();
								world.getDamage(25);
								world.money += -700;
								break;

							} else {
								System.out.println("nothing happened");
								break;
							}
						}

					} else {
						System.out.println("You should move to other region");
					}

				} else if (skillType.equals("eat")) {
					System.out.println("What you want to eat? [bread,water]");
					food = scanner.nextLine();
					world.eatFood(food);

				}

			}

		}
		System.out.println("Game out. You lose the Game. Try again!!");

	}
}
