package study11;

import java.util.Scanner;

public abstract class Creature {
	
	protected String name;
	protected int Hp;
	protected int MaxHp;
	protected int attack;
	protected int deffense;
	
	public Scanner scan=new Scanner(System.in);
	
	public Creature(String n) {
		name=n;
		System.out.println("モンスター名"+name);
		sethp();
		setat();
		setdf();
		birth();
	}
	public void sethp() {
		System.out.println(name+"の体力を設定してください");
		Hp=scan.nextInt();	
		MaxHp=Hp;
		if(Hp<0) {
			System.out.println("異常な設定値のためHpを0に設定しました。");
			Hp=0;
			MaxHp=0;
		}
	}
	public void setat() {
		System.out.println(name+"の攻撃力を設定してください");
		attack=scan.nextInt();
		if(attack<0) {
			System.out.println("異常な設定値のため攻撃力を0に設定しました。");
			attack=0;
		}
	}
	public void setdf() {
		System.out.println(name+"の防御力を設定してください");
		deffense=scan.nextInt();
		if(deffense<0) {
			System.out.println("異常な設定値のため防御力を0に設定しました。");
			deffense=0;
		}
	}
	
	public abstract void attack();
	public abstract void deffense();
	public void birth() {
		System.out.println(name+"が誕生した。");
		System.out.println("["+"Hp "+Hp+" /"+MaxHp+"]");
		System.out.println("[ 攻撃力"+attack+" 防御力"+deffense+"]");
	}
}
