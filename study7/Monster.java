package study7;

public class Monster {
	//フィールド
	String name;	//名前
	int hp;			//体力
	int attack;		//攻撃力
	int deffense;	//防御力

	//メソッド;
	void attack() {
		System.out.println(this.name+"の攻撃!");
		System.out.println(this.attack+"のダメージ!");
	}
	
	void bress(String focus,int focushp) {
		System.out.println(this.name+"の炎のブレス!");
		System.out.println("味方全体に"+(this.attack+5)+"のダメージ!");
		System.out.println(focus+" Hp"+(focushp-(this.attack+5))+"/"+focushp);
	}
	
	void deffense() {
		System.out.println(this.name+"は守りを固めた。");
		this.deffense=this.deffense+10;
		System.out.println("防御力が10上がった。");
	}
}
