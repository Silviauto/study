package study12;

import java.util.Scanner;

public abstract class Creature {
	
	protected String name;
	protected int Hp;
	protected int MaxHp;
	protected int attack;
	protected int deffense;
	
	public Scanner scan=new Scanner(System.in);
	
	public Creature(String n,int h,int a,int d) {
		name=n;
		System.out.println("モンスター名"+name);
		sethp(h);
		setat(a);
		setdf(d);
		birth();
	}
	public void sethp(int h) {
		Hp=h;
		MaxHp=Hp;
		if(Hp<0) {
			System.out.println("異常な設定値のためHpを0に設定しました。");
			Hp=0;
			MaxHp=0;
		}
	}
	public void setat(int a) {
		attack=a;
		if(attack<0) {
			System.out.println("異常な設定値のため攻撃力を0に設定しました。");
			attack=0;
		}
	}
	public void setdf(int d) {
		deffense=d;
		if(deffense<0) {
			System.out.println("異常な設定値のため防御力を0に設定しました。");
			deffense=0;
		}
	}
	public String getName() {
		return name;
	}
	public int gethp() {
		return Hp;
	}
	//////////////////////////////////////////////////////////
	//行動
	public void option(Character[] Ow,int turn) {
		if(Hp<=0) {
			System.out.println(name+"はすでに倒れている。");
		}
		else {
			attack(Ow,turn);
		}
	}
	
	public abstract void attack(Character[] Ow,int turn);
	public abstract void deffense();
	
	public void damege(int point) {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			Hp=Hp-point;
			if(Hp<0) {
				Hp=0;
				System.out.println(name+" Hp"+Hp+"/"+MaxHp);
				System.out.println(name+"は倒れた。");
			}
			else {
				System.out.println(name+" Hp"+Hp+"/"+MaxHp);
			}
		}
	}
	public void birth() {
		System.out.println(name+"が誕生した。");
		System.out.println("["+"Hp "+Hp+" /"+MaxHp+"]");
		System.out.println("[ 攻撃力"+attack+" 防御力"+deffense+"]");
	}
	public void display() {
		System.out.println("["+name+" Hp "+Hp+" /"+MaxHp+"]");
	}
}
