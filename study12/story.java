package study12;

public class story {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		//magic_atatckは打てない
		//Hero,MagicianをCharacterに格納→Characterの能力しか打てない。
		
		Character[] c=new Character[3];
		c[0]=new Hero("シルヴィ",220,60,45);
		c[1]=new Magician("ミラフ",150,30,30,130);
		c[2]=new Warrior("ドゥードゥー",250,50,80);
		
		Creature[] army1=new Creature[2];	//1部隊目
		army1[0]=new Slime(60,30,20);
		army1[1]=new armor(150,60,50);
		
		Creature[] army2=new Creature[3];	//2部隊目
		army2[0]=new armor(200,80,20);
		army2[1]=new armor(300,80,20);
		army2[2]=new armor(200,80,20);
			
		
		Character[] c2=Story_sp.battle(c,army1);	//戦闘1
		if(c2==null) {
			System.out.println("「GAME OVER!」");
		}
		else {
			Character[] c3=Story_sp.battle(c2,army2);	//戦闘2
			if(c3==null) {
				System.out.println("「GAME OVER!」");
			}
			else {
				System.out.println("魔物たちを全滅させた。");
				System.out.println("勇者たちは帰還した。");
			}
		}
		
		
	}

}
