package study12;

import java.util.Scanner;

public class Story_sp2 {
	
	public static Creature focus(Creature[] anemy) {
		int i,focus;
		Scanner scan=new Scanner(System.in);
		do {
		System.out.println("攻撃対象を選択してください。");
		for(i=0;i<anemy.length;i++) {
			System.out.print(i+","+anemy[i].getName()+" ");
		}
		focus=scan.nextInt();
		if((0>focus)||(focus>=anemy.length)){
			System.out.println("対象が見つかりません。");
		}
		}while((0>focus)||(focus>=anemy.length));
		
		return anemy[focus];
	}
	
	public static Character h_focus(Character[] Ow) {
		int i,focus;
		Scanner scan=new Scanner(System.in);
		do {
		System.out.println("攻撃対象を選択してください。");
		for(i=0;i<Ow.length;i++) {
			System.out.print(i+","+Ow[i].getName()+" ");
		}
		focus=scan.nextInt();
		if((0>focus)||(focus>=Ow.length)){
			System.out.println("対象が見つかりません。");
		}
		}while((0>focus)||(focus>=Ow.length));
		
		return Ow[focus];
	}
	
	public static Character a_focus(Character[] Ow) {
		int i;
		
		for(i=0;i<Ow.length;i++) {
			if(Ow[i] instanceof Warrior) {
				if(Ow[i].gethp()!=0) {
					return Ow[i];
				}
			}
		}
		for(i=0;i<Ow.length;i++) {
			if(Ow[i] instanceof Hero) {
				if(Ow[i].gethp()!=0) {
					return Ow[i];
				}
			}
		}
		for(i=0;i<Ow.length;i++) {
			if(Ow[i] instanceof Magician) {
				if(Ow[i].gethp()!=0) {
					return Ow[i];
				}
			}
		}
		System.out.println("勇者たちはすでに全滅している。");
		return null;
	}
	
	public static int oa_finish(Character[] Ow,Creature[] an) {
		int i,finish=0;	
		int acount=0,ocount=0;
		for(i=0;i<an.length;i++) {//敵軍
			if(an[i].gethp()==0) {
				acount++;
			}
		}
		if(acount==an.length) {
			finish=2;
		}
		for(i=0;i<Ow.length;i++) {//自軍
			if(Ow[i].gethp()==0) {
				ocount++;
			}
		}
		if(ocount==Ow.length) {
			finish=1;
		}
		return finish;
	}
	
	public static void display(Character[] Ow,Creature[] an) {
		int i;
		System.out.println("自軍");
		for(i=0;i<Ow.length;i++) {
			Ow[i].display();
		}
		System.out.println("魔物たち");
		for(i=0;i<an.length;i++) {
			an[i].display();
		}
		System.out.println("");
	}
	
}
