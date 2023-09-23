package study7;

import java.util.Scanner;

public class Story {
	
	public static void main(String[] args) {
		
		//T0D0
		Scanner scan=new Scanner(System.in);
		
		Hero h=new Hero();
		System.out.println("勇者の名前を入力してください");
		h.name=scan.nextLine();							//StringはLine
		
		System.out.println("勇者の体力を設定してください");
		h.hp=scan.nextInt();							//int型はInt
		
		System.out.println("勇者の攻撃力を設定してください");
		h.attack=scan.nextInt();
		
		System.out.println("勇者の防御力を設定してください");
		h.deffense=scan.nextInt();
		
		System.out.println("勇者が誕生した");
		System.out.println("名前"+h.name);
		System.out.println("体力"+h.hp);
		System.out.println("攻撃力"+h.attack);
		System.out.println("防御力"+h.deffense);
		
		///////////////////////////////////////////////////
		Scanner scan2=new Scanner(System.in);
		
		Monster D=new Monster();
		System.out.println("モンスターの名前を入力してください");
		D.name=scan2.nextLine();
		
		System.out.println("モンスターの体力を設定してください");
		D.hp=scan2.nextInt();							
		
		System.out.println("モンスターの攻撃力を設定してください");
		D.attack=scan2.nextInt();
		
		System.out.println("モンスターの防御力を設定してください");
		D.deffense=scan2.nextInt();
		
		System.out.println("モンスターが誕生した");
		System.out.println("名前"+D.name);
		System.out.println("体力"+D.hp);
		System.out.println("攻撃力"+D.attack);
		System.out.println("防御力"+D.deffense);
		
		////////////////////////////////////////////////////////
		Scanner scan3=new Scanner(System.in);
		
		Magician m=new Magician();
		System.out.println("魔法使いの名前を入力してください");
		m.name=scan3.nextLine();							
		
		System.out.println("魔法使いの体力を設定してください");
		m.hp=scan3.nextInt();							
		
		System.out.println("魔法使いのマジックポイントを設定してください");
		m.mp=scan3.nextInt();
		
		System.out.println("魔法使いが誕生した");
		System.out.println("名前"+m.name);
		System.out.println("体力"+m.hp);
		System.out.println("マジックポイント"+m.mp);
		
		System.out.println("\n"+D.name+"が現れた\n");
		D.bress(h.name,h.hp);
		m.heal(h.name,h.hp);
		h.attack();
		D.deffense();
		m.attack();
		
	}
}
