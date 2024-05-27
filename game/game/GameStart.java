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

		Fight world = new Fight(name, stats, jobType);
		while (world.hp > 0) {
			if (character != null) {
				world.showHP();
				System.out.println("shop , region, fight, eat");
				skillType = scanner.nextLine();
				if (skillType.equals("shop")) {
					world.showShop();
				} else if (skillType.equals("region")) {
					world.regionShow();
				} else if (skillType.equals("fight")) {
					if (world.region.equals("henesis")) {

						Monster monster = new Slime();

						while (monster.hp > 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								monster.monsterDie();
								world.money += 500;

							} else if (skillType.equals("w")) {
								monster.monsterAttack();
								world.getDamage(10);
								world.money -= 200;
								monster.hp -= 20;
								System.out.println("Monster's status " + monster.hp);
							} else if (skillType.equals("e")) {
								monster.monsterAttack2();
								world.getDamage(101);
							} else {
								System.out.println("nothing happened");
							}
						}
						System.out.println("The MONSTER DEAD");
					} else if (world.region.equals("ferrion")) {
						Monster monster = new Stump();
						while (monster.hp > 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								monster.monsterDie();
								world.money += 500;

							} else if (skillType.equals("w")) {
								monster.monsterAttack2();
								world.getDamage(101);

							} else if (skillType.equals("e")) {
								monster.monsterAttack();
								world.getDamage(20);
								world.money -= 500;
								monster.hp -= 50;

							} else {
								System.out.println("nothing happened");

							}
						}
						System.out.println("The MONSTER DEAD");
					} else if (world.region.equals("elinia")) {
						Monster monster = new Pig();
						while (monster.hp > 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								System.out.println("Weak attack!");
								monster.hp -= 10;
								world.money += 10;

							} else if (skillType.equals("w")) {
								monster.monsterAttack2();
								world.getDamage(40);
								world.region = "henesis";
								break;

							} else if (skillType.equals("e")) {
								monster.monsterAttack();
								world.getDamage(70);
								world.money += 1000;
								monster.hp -= 70;

							} else {
								monster.monsterDie();
								System.out.println("something happened");

							}
						}
					} else if (world.region.equals("shadowcity")) {
						Monster monster = new Octopus();
						while (monster.hp > 0) {
							System.out.println("You chose to fight with monster press your skill!!");
							skillType = scanner.nextLine();
							character.useSkill(skillType);
							if (skillType.equals("q")) {
								monster.monsterDie();
								world.money += 700;

							} else if (skillType.equals("w")) {
								monster.monsterAttack2();
								world.getDamage(5);
								world.region = "ferrion";
								break;

							} else if (skillType.equals("e")) {
								monster.monsterAttack();
								world.getDamage(25);
								world.money += -700;
								monster.hp -= 50;

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
		scanner.close();
		System.out.println("Game out. You lose the Game. Try again!!");

	}
}
