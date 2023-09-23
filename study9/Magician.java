package study9;

import java.util.Scanner;

public class Magician {
	//フィールド
	private String name;	//名前
	private int Hp;			//体力
	private int MaxHp;
	private int Mp;			//マジックポイント
	private int healp;
	private int MaxMp;
	
	private Scanner scan3=new Scanner(System.in);
	//キャラ生成
	Magician() {
		System.out.println("魔法使いの名前を入力してください");
		setname(scan3.nextLine());							
		System.out.println("魔法使いの体力を設定してください");
		sethp(scan3.nextInt());							
		System.out.println("魔法使いのマジックポイントを設定してください");
		setmp(scan3.nextInt());
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
		healp=hp/3;
		if(hp<0) {
			System.out.println("異常な設定値のためhpを0に設定しました。");
			Hp=0;
			MaxHp=0;
			healp=0;
		}
	}
	
	//マジックポイント
	public int getmp() {
		return Mp;
	}
	public void setmp(int mp) {
		Mp=mp;
		MaxMp=mp;
		if(mp<0) {
			System.out.println("異常な設定値のためMpを0に設定しました。");
			Mp=0;
			MaxMp=0;
		}
	}
	public int gethealp() {
		return healp;
	}
	
	//行動
	public void attack() {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(name+"の物理攻撃!");
			System.out.println("敵にダメージを"+5+"与えた");
		}
	}
	
	public void magic_attack() {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
		System.out.println(name+"の攻撃!");
		System.out.println("敵にダメージを"+Mp*(3/5)+"与えた");
		}
	}
	
	public void heal(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(name+"は回復魔法を使用した");
			Mp=Mp-15;
			System.out.println(name+"はmpを15消費した");
			System.out.println(focus+"の体力が"+healp+"回復した。");
		}
	}
	
	public void rest() {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(name+"は休憩した");
			this.Hp=this.Hp+10;
			System.out.println("hpが10回復し"+this.Hp+"になった。");
		}
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
	
	public void status() {
		System.out.println(name);
		System.out.println("Hp "+Hp+"/"+MaxHp);
		System.out.println("MP "+Mp);
	}

}
