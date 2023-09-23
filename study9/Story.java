package study9;

import java.util.Scanner;

public class Story {
	
	public static void main(String[] args) {
		
		
		Hero h1=new Hero();
		
		System.out.println("勇者が誕生した");
		System.out.println("名前"+h1.getName());		//標準入力で得た各ステータスを呼び出せる。
		System.out.println("体力"+h1.gethp());
		System.out.println("攻撃力"+h1.getat());
		System.out.println("防御力"+h1.getdf());
		
		///////////////////////////////////////////////////
		
		Monster D=new Monster();
		
		System.out.println("モンスターが誕生した");
		System.out.println("名前"+D.getName());
		System.out.println("体力"+D.gethp());
		System.out.println("攻撃力"+D.getat());
		System.out.println("防御力"+D.getdf());
		
		////////////////////////////////////////////////////////
		
		Magician m=new Magician();
		
		System.out.println("魔法使いが誕生した");
		System.out.println("名前"+m.getName());
		System.out.println("体力"+m.gethp());
		System.out.println("マジックポイント"+m.getmp());
		
		System.out.println("\n"+D.getName()+"が現れた\n");
		D.bress(h1.getName(),h1.gethp());
		h1.damege(D.getbressat());
		m.damege(D.getbressat());
		System.out.println();
		h1.attack(D.getName());
		D.damege(h1.getat());
		m.heal(h1.getName());
		System.out.println();
		D.bress(h1.getName(),h1.gethp());
		h1.damege(D.getbressat());
		m.damege(D.getbressat());
	}
}
