package study11_2;

import java.util.Scanner;
public abstract class Character {

	
	protected String name;
	protected int Hp;
	protected int MaxHp;
	protected String type1;
	protected String type2;
	
	public Scanner scan=new Scanner(System.in);
	
	Character(String t1) {
		type1=t1;
		setname();
		sethp();
		display();
	}
	Character(String t1,String t2) {
		type1=t1;
		type2=t2;
		setname();
		sethp();
		display();
	}
	
	public void setname() {
		System.out.println("名前を[2文字以上、6文字以下]で入力してください");
		name=scan.nextLine();
		if(name==null) {											
			throw new IllegalArgumentException("名前がnullです。");
		}
		if(name.length()<2) {
			throw new IllegalArgumentException("名前が2文字未満です。");
		}
		if(name.length()>6) {
			throw new IllegalArgumentException("名前が6文字を超えています。");
		}
	}
	public void sethp() {
		System.out.println(name+"のHpを入力してください");
		Hp=scan.nextInt();
		MaxHp=Hp;
		if(Hp<0) {
			System.out.println("異常な設定値のためHpを0に設定しました。");
			Hp=0;
			MaxHp=0;
		}
	}
	
	public void attack() {
		System.out.println(name+"の'たいあたり'");
	}
	public void deffense() {
		System.out.println(name+"の'守る'。");
	}
	public void display() {
		System.out.println(name+"が誕生した。");
		if(type2==null) {
			System.out.println("タイプ "+type1);
		}
		else {
			System.out.println("タイプ "+type1+", "+type2);
		}	
		}
}
