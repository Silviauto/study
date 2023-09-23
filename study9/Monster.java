package study9;

import java.util.Scanner;

public class Monster {
	//フィールド
	private String name;	//名前
	private int Hp;			//体力
	private int MaxHp;		//最大体力
	private int attack;		//攻撃力
	private int bressat;
	private int deffense;	//防御力
	
	private Scanner scan2=new Scanner(System.in);
	//キャラ生成
	Monster() {
		System.out.println("モンスターの名前を入力してください");
		setname(scan2.nextLine());
		System.out.println("モンスターの体力を設定してください");
		sethp(scan2.nextInt());							
		System.out.println("モンスターの攻撃力を設定してください");
		setat(scan2.nextInt());
		System.out.println("モンスターの防御力を設定してください");
		setdf(scan2.nextInt());	
	}
	
	//体力
	public String getName() {
		return name;
	}
	public void setname(String n) {
		if(n==null) {											//nullに対しては==を使用する。.equals("")は普通の文字だけ。
			throw new IllegalArgumentException("名前がnullです。");	//エラーをだせるらしい
		}
		if(n.length()<3) {
			throw new IllegalArgumentException("名前が3文字未満です。");
		}
		if(n.length()>10) {
			throw new IllegalArgumentException("名前が10文字を超えています。");
		}
		name=n;
	}
	
	//Hp
	public int gethp() {
		return Hp;
	}
	public void sethp(int hp) {
		Hp=hp;
		MaxHp=hp;
		if(hp<0) {
			System.out.println("異常な設定値のためhpを0に設定しました。");
			Hp=0;
			MaxHp=0;
		}
	}
	
	//攻撃力
	public int getat() {
		return attack;
	}
	public void setat(int at) {
		attack=at;
		bressat=attack+10;
		if(at<0) {
			System.out.println("異常な設定値のため攻撃力をを0に設定しました。");
			attack=0;
			bressat=0;
		}
	}
	public int getbressat() {
		return bressat;
	}
	
	//防御力
	public int getdf() {
		return deffense;
	}
	public void setdf(int df) {
		deffense=df;
		if(df<0) {
			System.out.println("異常な設定値のため防御力を0に設定しました。");
			deffense=0;
		}
	}	
	
	//メソッド;
	public void attack() {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(this.name+"の攻撃!");
			System.out.println(this.attack+"のダメージ!");
		}
	}
	
	public void bress(String focus,int focushp) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(name+"の炎のブレス!");
			System.out.println("味方全体に"+bressat+"のダメージ!");
		}
	}
	
	public void deffense() {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(this.name+"は守りを固めた。");
			this.deffense=this.deffense+10;
			System.out.println("防御力が10上がった。");
		}
	}
	
	public void damege(int damege) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			Hp=Hp-damege;
			System.out.println(name+" "+Hp+"/"+MaxHp);
			if(Hp<0) {
				System.out.println(name+"は倒れた。");
			}
		}
	}
	
	public void status() {
		System.out.println(name);
		System.out.println("Hp "+Hp+"/"+MaxHp);
		System.out.println("攻撃力 "+attack);
		System.out.println("防御力 "+deffense);
	}
}
