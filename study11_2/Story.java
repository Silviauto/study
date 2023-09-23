package study11_2;

public class Story {
	public static void main(String args[]) {
		
		//ノーマル
		pokemon Eevee=new pokemon();
		//でんき
		th_pokemon volt=new th_pokemon();
		//ほのお
		f_pokemon blaze=new f_pokemon();
		//でんき×ほのお
		mix_pokemon Rotom=new mix_pokemon(); 
		
		System.out.println("\n[ノーマル]");
		Eevee.attack();
		System.out.println("\n[でんき]");
		volt.th_attack();
		System.out.println("\n[ほのお]");
		blaze.f_attack();
		System.out.println("\n[でんき×ほのお]");
		Rotom.f_attack();
		Rotom.th_attack();
		
				
				
	}
}
