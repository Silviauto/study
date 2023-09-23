package study12;

public class Story_sp {
	
	public static Character[] battle(Character[] Ow,Creature[] an) {
		System.out.println("\n!!敵に遭遇した!!");
		Character[] member=null;
		int i=0,j=0;
		for(i=0;i<an.length;i++) {
			System.out.println(an[i].getName()+"が現れた。");
		}
		int finish=0,turn=1;
		int memberL=Math.max(Ow.length,an.length);
		
		do {
		System.out.println("\n[ターン"+turn+"]");
		Story_sp2.display(Ow,an);
		j=0;
			for(i=0;i<memberL;i++) {
				if(i<Ow.length) {
					if(Ow[i] instanceof Magician) {
						Magician m=(Magician) Ow[i];
						m.option(Ow,an);
					}
					else if(Ow[i] instanceof Warrior) {
						Warrior w=(Warrior) Ow[i];
						w.option(Ow,an);
					}
					else {
						Ow[i].option(Ow,an);
					}
				}
				if(j<an.length) {
					if(an[j] instanceof Slime) {
						Slime s=(Slime) an[j];
						s.option(Ow,turn);
						}
					else if(an[j] instanceof armor) {
						armor a=(armor) an[j];
						a.option(Ow, turn);
					}	
				}
				j++;
				finish=Story_sp2.oa_finish(Ow,an);
			}
		}while((finish!=1)&&(finish!=2));
		if(finish==1) {
			System.out.println("勇者たちは全滅してしまった。");
			return null;
		}
		else if(finish==2){
			System.out.println("魔物たちは全滅した。");
			return Ow;
		}
				
		//消費したHpを引き継ぐのを作るならここ
		return member;
	}
	
}