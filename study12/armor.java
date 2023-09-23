package study12;

public class armor extends Creature{
	
	//モンスター さまよう鎧
	armor(int h,int a,int d) {
		super("さまよう鎧",h,a,d);
	}
	
	public void attack(Character[] Ow,int turn) {
		if(turn%2==1) {
			Character focus=Story_sp2.a_focus(Ow);
			b_attack(focus);
		}
		else {
			k_attack(Ow);
		}
	}
	
	public void b_attack(Character focus) {
		System.out.println(name+"の五月雨突き");
		System.out.println(focus.getName()+"に"+attack+"のダメージ!");
		focus.damege(attack);
	}
	
	public void k_attack(Character[] Ow) {
		System.out.println(name+"の'キングダムソード'");
		System.out.println("味方全体にきりかかる!");
		int i,givdm=attack/2;
		for(i=0;i<Ow.length;i++) {
			Ow[i].damege(givdm);
		}
	}
	
	public void deffense() {
		System.out.println(name+"が防御した");
	}
}
