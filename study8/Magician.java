package study8;

import java.util.Scanner;

public class Magician {
	//フィールド
	String name;	//名前
	int hp;			//体力
	int mp;			//マジックポイント
	
	//メソッド;
	Magician() {
		Scanner scan3=new Scanner(System.in);
		System.out.println("魔法使いの名前を入力してください");
		name=scan3.nextLine();							
		System.out.println("魔法使いの体力を設定してください");
		hp=scan3.nextInt();							
		System.out.println("魔法使いのマジックポイントを設定してください");
		mp=scan3.nextInt();
		
		System.out.println("魔法使いが誕生した");
		System.out.println("名前"+name);
		System.out.println("体力"+hp);
		System.out.println("マジックポイント"+mp);
	}
	
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
