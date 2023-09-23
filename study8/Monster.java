package study8;

import java.util.Scanner;

public class Monster {
	//フィールド
	String name;	//名前
	int hp;			//体力
	int attack;		//攻撃力
	int deffense;	//防御力

	//メソッド;
	Monster() {
		Scanner scan2=new Scanner(System.in);
		System.out.println("モンスターの名前を入力してください");
		name=scan2.nextLine();
		System.out.println("モンスターの体力を設定してください");
		hp=scan2.nextInt();							
		System.out.println("モンスターの攻撃力を設定してください");
		attack=scan2.nextInt();
		System.out.println("モンスターの防御力を設定してください");
		deffense=scan2.nextInt();
		
		System.out.println("モンスターが誕生した");
		System.out.println("名前"+name);
		System.out.println("体力"+hp);
		System.out.println("攻撃力"+attack);
		System.out.println("防御力"+deffense);
	}
	
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
