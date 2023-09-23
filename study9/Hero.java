package study9;

import java.util.Scanner;

public class Hero {
	
	//フィールド
	private String name;	//名前
	private int Hp;			//体力
	private int MaxHp;
	private int attack;		//攻撃力
	private int deffense;	//防御力
	
	private Scanner scan=new Scanner(System.in);			//標準入力用
	//キャラ生成
	Hero() {
		System.out.println("勇者の名前を入力してください");
		setname(scan.nextLine());				//引数は標準入力で						
		System.out.println("勇者の体力を設定してください");
		sethp(scan.nextInt());							
		System.out.println("勇者の攻撃力を設定してください");
		setat(scan.nextInt());
		System.out.println("勇者の防御力を設定してください");
		setdf(scan.nextInt());
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
	public void attack(String focus) {
		System.out.println(name+"の攻撃!");
		System.out.println(focus+"にダメージを"+attack+"与えた");
	}
	
	public void deffense() {
		System.out.println("勇者が防御した");
		this.deffense=this.deffense+10;
		System.out.println("防御力が10upし、"+this.deffense+"になった");
	}
	
	public void heal(int healp) {
		Hp=Hp+healp;
		System.out.println(name+" "+Hp+"/"+MaxHp);
	}
	
	public void damege(int damege) {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			Hp=Hp-damege;
			System.out.println(name+" "+Hp+"/"+MaxHp);
			if(Hp<0) {
				System.out.println(name+"は倒れた。");
			}
		}
	}
	
	public void atak(Monster m) {	//ええええええええええええええええええええ
		String NN=m.getName();
	}
	
	public void status() {
		System.out.println(name);
		System.out.println("Hp "+Hp+"/"+MaxHp);
		System.out.println("攻撃力 "+attack);
		System.out.println("防御力 "+deffense);
	}
}
