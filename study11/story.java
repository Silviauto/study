package study11;

public class story {
	public static void main(String args[]) {
		
		Hero h1=new Hero();
		Magician m1=new Magician();
		Warrior w1=new Warrior();
		
		Slime s1=new Slime();
		armor a1=new armor();
		
		h1.attack();
		m1.magic_attack();
		w1.attack();
		w1.deffense();
		
		s1.attack();
		a1.attack();
	}
	
}
