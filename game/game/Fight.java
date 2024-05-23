package game;

public class Fight extends World{
	private Monster monster;
	public Fight(String name, String stats, String jobtype) {
		super(name,stats,jobtype);
		
	
	}
	public void fight(String name,int HP,int attackDamage) {
		super.getDamage(attackDamage);
		System.out.println(name+"'s HP decreased for "+attackDamage);
		
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	public Monster getmonster() {
		return monster;
	}
}
