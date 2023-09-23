package study11;

public class Slime extends Creature{
	
	//モンスター　スライム
	Slime() {
		super("スライム");
		birth_a();
	}
	
	public void attack() {
		System.out.println(name+"の体当たり!");
		System.out.println(name+"は"+attack+"のダメージを与えた。");
	}
	public void deffense() {
		System.out.println(name+"は震えている。");
	}
	public void birth_a() {
		deffense=0;
		System.out.println("スライムの防御力は0だ。\n防御力 0");
	}
	
}
