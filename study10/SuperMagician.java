package study10;

public class SuperMagician extends Magician{

	SuperMagician() {
		super("ソーサラー");
	}
	
	//強化魔法攻撃
	public void magicII_attack(String focus) {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
		System.out.println(name+"の攻撃!");
		System.out.println(focus+"にダメージを"+magicII_damege()+"与えた");
		System.out.println(name+"はmpを30消費した");
		Mp=Mp-30;
		if(Mp<=0) {
			Mp=0;
		}
		System.out.println(name+" Mp"+Mp+"/"+MaxMp);
		}
	}
	public int magicII_damege() {
		int damege=2*magicI_damege();
		return damege;
	}
	
	//強化回復魔法
	public void relive() {
		if(Hp<=0) {
			System.out.println(name+"は倒れているので行動出来ない。");
		}
		else {
			System.out.println(name+"は全体回復魔法を唱えた");
			Mp=Mp-10;
			System.out.println(name+"はmpを20消費した");
			System.out.println("味方全体の体力が"+healp+"回復した。");
		}
	}
}
