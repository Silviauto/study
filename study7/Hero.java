package study7;

public class Hero {
	
	//フィールド
	String name;	//名前
	int hp;			//体力
	int attack;		//攻撃力
	int deffense;	//防御力
	
	//メソッド;
	void attack() {
		System.out.println(this.name+"の攻撃!");
		System.out.println("敵にダメージを"+this.attack+"与えた");
	}
	
	void deffense() {
		System.out.println("勇者が防御した");
		this.deffense=this.deffense+10;
		System.out.println("防御力が10upし、"+this.deffense+"になった");
	}
	
	void heal() {
		System.out.println("勇者が休憩した");
		this.hp=this.hp+10;
		System.out.println("hpが10回復し"+this.hp+"になった。");
	}
	
}
