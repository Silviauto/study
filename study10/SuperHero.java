package study10;

public class SuperHero extends Hero{
	
	public SuperHero() {
		super("上級勇者");
	}
			
	public void attack(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(getName()+"の2回連続攻撃");
			super.attack(focus);
			super.attack(focus);
		}
	}
	public int attack_damege() {
		int damege=2*attack;
		return damege;
	}
}
