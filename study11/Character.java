package study11;

import java.util.Scanner;

public abstract class Character {
	
	protected int Hp;
	protected int MaxHp;
	protected String name;
	protected int attack;
	protected int deffense;
	protected String type;
	
	public Scanner scan=new Scanner(System.in);
	
	public Character(String job) {
		type=job;
		setname();
		sethp();
		setat();
		setdf();
		birth();
	}
	
	public void setname() {
		System.out.println(type+"の名前を[3文字、10文字以下]で入力してください");
		name=scan.nextLine();	
		if(name==null) {										
			throw new IllegalArgumentException("名前がnullです。");	
		}
		if(name.length()<3) {
			throw new IllegalArgumentException("名前が3文字未満です。");
		}
		if(name.length()>10) {
			throw new IllegalArgumentException("名前が10文字を超えています。");
		}
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
	public void job() {
		System.out.println(name+"は'"+type+"'になった。");
	}
}
