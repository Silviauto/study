package study10;

import java.util.Scanner;

public class Magician {
	//フィールド
	protected String name;	//名前
	private final String type="魔術師";
	protected int Hp;			//体力
	protected int MaxHp;
	protected int Mp;			//マジックポイント
	protected int healp;
	protected int MaxMp;
	
	int poison=0;
	
	private Scanner scan3=new Scanner(System.in);
	//キャラ生成
	Magician() {
		System.out.println("魔術師の名前を入力してください");
		setname(scan3.nextLine());							
		System.out.println("魔術師の体力を設定してください");
		sethp(scan3.nextInt());							
		System.out.println("魔術師のマジックポイントを設定してください");
		setmp(scan3.nextInt());
		
		System.out.println(gettype()+"が誕生した");
		System.out.println("名前"+getName());
		System.out.println("体力"+gethp());
		System.out.println("マジックポイント"+getmp());
	}
	public Magician(String t) {
		System.out.println(t+"の名前を入力してください");
		setname(scan3.nextLine());							
		System.out.println(t+"の体力を設定してください");
		sethp(scan3.nextInt());							
		System.out.println(t+"のマジックポイントを設定してください");
		setmp(scan3.nextInt());
		
		System.out.println(t+"が誕生した");
		System.out.println("名前"+getName());
		System.out.println("体力"+gethp());
		System.out.println("マジックポイント"+getmp());
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
		healp=hp/2;
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
	public void attack(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(name+"の物理攻撃!");
			System.out.println(focus+"にダメージを5 与えた");
		}
	}
	public int attack_damege() {
		int damege=5;
		return damege;
	}
	
	public void magicI_attack(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
		System.out.println(name+"の攻撃!");
		System.out.println(focus+"にダメージを"+(MaxMp*3)/5+"与えた");
		System.out.println(name+"はmpを15消費した");
		Mp=Mp-15;
		if(Mp<=0) {
			Mp=0;
		}
		System.out.println(name+" MP"+Mp+"/"+MaxMp);
		}
	}
	public int magicI_damege() {
		int damege=(3*MaxMp)/5;
		return damege;
	}
	
	public void live(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(name+"は回復魔法を使用した");
			Mp=Mp-10;
			if(Mp<=0) {
				Mp=0;
			}
			System.out.println(name+"はmpを10消費した");
			System.out.println(name+" MP"+Mp+"/"+MaxMp);
			System.out.println(focus+"の体力が"+healp+"回復した。");
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
	
	public void repoison() {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			if(poison==0) {
				System.out.println(getName()+"毒状態が付与された。");
				poison=2;
			}
		}
	}
	
	public void poison() {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else {
			}
			if(poison!=0) {
				System.out.println("毒状態が続いている。");
				Hp=Hp-(MaxHp/10);
				if(Hp<=0) {
					Hp=0;
				}
				int poidm=MaxHp/10;
				System.out.println("毒ダメージ"+poidm);
				System.out.println(name+" "+Hp+"/"+MaxHp);
				if(Hp<=0) {
					System.out.println(name+"は倒れた。");
				}
			}
		}

	public void display() {
		System.out.println("["+name+" Hp"+Hp+"/"+MaxHp+" Mp"+Mp+"/"+MaxMp+"]");
	}
}
