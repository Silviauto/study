package study7;

public class Magician {
	//フィールド
	String name;	//名前
	int hp;			//体力
	int mp;			//マジックポイント
	
	//メソッド;
	void attack() {
		System.out.println(this.name+"の物理攻撃!");
		System.out.println("敵にダメージを"+5+"与えた");
	}
	
	void magic_attack() {
		System.out.println(this.name+"の攻撃!");
		System.out.println("敵にダメージを"+mp*(3/5)+"与えた");
	}
	
	void heal(String focus,int focushp) {
		System.out.println("魔法使いは回復魔法を使用した");
		this.mp=this.mp-15;
		focushp=focushp+20;
		System.out.println("魔法使いは勇者の体力を20回復した");
		System.out.println("魔法使いはmpを15消費した");
	}
	
	void rest() {
		System.out.println("魔法使いは休憩した");
		this.hp=this.hp+10;
		System.out.println("hpが10回復し"+this.hp+"になった。");
	}

}
