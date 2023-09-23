package study12;

import java.util.Scanner;

public abstract class Character {
	
	protected int Hp;
	protected int MaxHp;
	protected String name;
	protected int attack;
	protected int deffense;
	protected String type;
	
	public Scanner scan=new Scanner(System.in);
	
	public Character(String job,String n,int h,int a,int d) {
		type=job;
		setname(n);
		sethp(h);
		setat(a);
		setdf(d);
		birth();
	}
	
	public void setname(String n) {	
		if(n==null) {										
			throw new IllegalArgumentException("名前がnullです。");	
		}
		if(n.length()<3) {
			throw new IllegalArgumentException("名前が3文字未満です。");
		}
		if(n.length()>10) {
			throw new IllegalArgumentException("名前が10文字を超えています。");
		}
		name=n;
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
	/////////////////////////////////////////////
	//行動
	public void option(Character[] Own,Creature[] anemy) {
		if(Hp<=0) {
			System.out.println(name+"はすでに倒れている。");
		}
		else {
			int option=0;
			int count=0;
			do {
				System.out.println(name+"の行動を選択してください");
				System.out.println("[1,攻撃 2,防御]");
				option=scan.nextInt();
				if(option==1) {
					attack(anemy);
				}
				else if(option==2) {
					deffense();
				}
				else {
					System.out.println("行動が見つかりません。");
					count++;
					if(count==2) {
						System.out.println(name+"は混乱した。");
						option=1;
					}
				}
			}while((option!=1)&&(option!=2));
		}
	}
	
	public abstract void attack(Creature[] anemy);
	public abstract void deffense();
	public void birth() {
		System.out.println(name+"が誕生した。");
		System.out.println("["+"Hp "+Hp+" /"+MaxHp+"]");
		System.out.println("[ 攻撃力"+attack+" 防御力"+deffense+"]");
	}
	
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
	public void heal(int point) {
		System.out.println(name+"は回復した。");
		Hp=Hp+point;
		if(Hp>MaxHp) {
			Hp=MaxHp;
		}
		System.out.println(name+" Hp"+Hp+"/"+MaxHp);
	}
	
	
	public void job() {
		System.out.println(name+"は'"+type+"'になった。");
	}
	public void display() {
		System.out.println("["+name+" Hp "+Hp+" /"+MaxHp+"]");
	}
}
