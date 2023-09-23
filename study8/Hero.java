package study8;

import java.util.Scanner;

public class Hero {
	
	//フィールド
	String name;	//名前
	int hp;			//体力
	int attack;		//攻撃力
	int deffense;	//防御力
	Scanner scan=new Scanner(System.in);
	
	Hero() {		//引数無し コンストラクタ				
		System.out.println("勇者の名前を入力してください");
		name=scan.nextLine();							
		System.out.println("勇者の体力を設定してください");
		hp=scan.nextInt();							
		System.out.println("勇者の攻撃力を設定してください");
		attack=scan.nextInt();
		System.out.println("勇者の防御力を設定してください");
		deffense=scan.nextInt();
		
		System.out.println("勇者が誕生した");
		System.out.println("名前"+name);
		System.out.println("体力"+hp);
		System.out.println("攻撃力"+attack);
		System.out.println("防御力"+deffense);
	}
	
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
