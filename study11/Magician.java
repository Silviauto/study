package study11;

public class Magician extends Character {
	
	//職業 魔導士
	protected int Mp;
	protected int MaxMp;
	
	Magician() {
		super("魔導士");
		job();
		birth_a();
	}
	
	public void attack() {
		System.out.println(name+"の攻撃!");
		System.out.println(name+"は5のダメージを与えた。");
	}
	public void deffense() {
		System.out.println(name+"が防御した");
	}
	public void magic_attack() {
		System.out.println(name+"の魔法攻撃!");
		Mp=Mp-15;
		if(Mp<=0) {
			Mp=0;
		}
		System.out.println(name+"はMpを15消費した。 Mp"+Mp+"/"+MaxMp);
		System.out.println(name+"は"+(5*MaxMp)/3+"のダメージを与えた。");
	}
	public void birth_a() {
		System.out.println(type+"クラスよりステータス'Mp'を得た。");
		System.out.println(name+"のMpを入力してください。");
		Mp=scan.nextInt();
		MaxMp=Mp;
	}

}
