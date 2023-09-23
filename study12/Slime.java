package study12;

public class Slime extends Creature{
	
	//モンスター　スライム
	Slime(int h,int a,int d) {
		super("スライム",h,a,d);
		birth_a();
	}
	
	public void attack(Character[] Ow,int turn) {
		Character focus=Story_sp2.a_focus(Ow);
		System.out.println(name+"の体当たり!");
		System.out.println(name+"は"+attack+"のダメージを与えた。");
		focus.damege(this.attack);
	}
	public void deffense() {
		System.out.println(name+"は震えている。");
	}
	public void birth_a() {
		deffense=0;
		System.out.println("スライムの防御力は0だ。\n防御力 0");
	}
	
}
