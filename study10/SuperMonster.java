package study10;

public class SuperMonster extends Monster {

	private final String type="魔王";
	protected int poison=0;
	
	SuperMonster() {
		super("魔王");
	}
	
	public void attack(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			super.attack(focus);
			poison(focus);
		}
	}
	
	public void poison() {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			poison=1;
			System.out.println(getName()+"が毒の霧をまといだした。");
			Hp=Hp+30;
			if(Hp>=MaxHp) {
				Hp=MaxHp;
			}
			System.out.println(name+" "+Hp+"/"+MaxHp);
		}
	}
	
	public void poison(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			if(poison==0) {
				poison=1;
				System.out.println(getName()+"が毒の霧をまといだした。");
				Hp=Hp+30;
				if(Hp>=MaxHp) {
					Hp=MaxHp;
				}
				System.out.println(name+" "+Hp+"/"+MaxHp);
			}
			else {
				System.out.println("毒の霧が"+focus+"を襲う");
				poison=0;
			}
		}
	}
}
