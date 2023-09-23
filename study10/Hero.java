package study10;

import java.util.Scanner;

public class Hero {
	
	//フィールド
	private final String type="勇者";	
	
	protected String name;	//名前
	protected int Hp;		//体力
	protected int MaxHp;
	protected int attack;	//攻撃力
	protected int deffense;	//防御力
	
	protected int poison=0;
	
	private Scanner scan=new Scanner(System.in);			//標準入力用
	//キャラ生成
	public Hero() {
		System.out.println(this.type+"の名前を入力してください");
		setname(scan.nextLine());							
		System.out.println(this.type+"の体力を設定してください");
		sethp(scan.nextInt());							
		System.out.println(this.type+"の攻撃力を設定してください");
		setat(scan.nextInt());
		System.out.println(this.type+"の防御力を設定してください");
		setdf(scan.nextInt());
		
		System.out.println(this.type+"が誕生した");
		System.out.println("名前"+getName());		
		System.out.println("体力"+gethp());
		System.out.println("攻撃力"+getat());
		System.out.println("防御力"+getdf());
	}
	public Hero(String t) {
		System.out.println(t+"の名前を入力してください");
		setname(scan.nextLine());									
		System.out.println(t+"の体力を設定してください");
		sethp(scan.nextInt());							
		System.out.println(t+"の攻撃力を設定してください");
		setat(scan.nextInt());
		System.out.println(t+"の防御力を設定してください");
		setdf(scan.nextInt());
		
		System.out.println(t+"が誕生した");
		System.out.println("名前"+getName());		//標準入力で得た各ステータスを呼び出せる。
		System.out.println("体力"+gethp());
		System.out.println("攻撃力"+getat());
		System.out.println("防御力"+getdf());
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
	
	//兵種
	public String gettype() {
		return type;
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
		if(at<0) {
			System.out.println("異常な設定値のため攻撃力を0に設定しました。");
			attack=0;
		}
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
	
	
	//行動
	//通常攻撃
	public void attack(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
		System.out.println(name+"の攻撃!");
		System.out.println(focus+"にダメージを"+attack+"与えた");
		}
	}
	public int attack_damege() {
		int damege=attack;
		return damege;
	}
	
	public void deffense() {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
		System.out.println("勇者が防御した");
		this.deffense=this.deffense+10;
		System.out.println("防御力が10upし、"+this.deffense+"になった");
		}
	}
	
	public void heal(int healp) {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			Hp=Hp+healp;
			if(Hp>=MaxHp) {
				Hp=MaxHp;
			}
			System.out.println(name+" "+Hp+"/"+MaxHp);
		}
	}
	
	public void damege(int damege) {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			Hp=Hp-damege;
			if(Hp<=0) {
				Hp=0;
			}
			System.out.println(name+" "+Hp+"/"+MaxHp);
			if(Hp<=0) {
				System.out.println(name+"は倒れた。");
			}
		}
	}
	
	public void poison() {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			if(poison!=0) {
				System.out.println("毒状態が続いている。");
				Hp=Hp-(MaxHp/10);
				if(Hp<=0) {
					Hp=0;
				}
				int poison=MaxHp/10;
				System.out.println("毒ダメージ"+poison);
				System.out.println(name+" "+Hp+"/"+MaxHp);
				if(Hp<=0) {
					System.out.println(name+"は倒れた。");
				}
			}
		}
	}
	
	public void repoison() {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			if(poison==0) {
				System.out.println(getName()+"は毒状態が付与された。");
				poison=2;
			}
		}
	}
	
	public void display() {
		System.out.println("["+name+" Hp"+Hp+"/"+MaxHp+"]");
	}
	}

