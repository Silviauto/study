package study12;

public class Magician extends Character {
	
	//職業 魔導士
	protected int Mp;
	protected int MaxMp;
	
	Magician(String n,int h,int a,int d,int m) {
		super("魔導士",n,h,a,d);
		job();
		birth_a(m);
	}
	
	////////////////////////////////////////////
	//行動
	public void option(Character[] Own,Creature[] anemy) {
		if(Hp<=0) {
			System.out.println(name+"はすでに倒れている。");
		}
		else {
			int option=0;
			int count=0;
			do {
				System.out.println(name+"の行動を選択してください");
				System.out.println("[1,攻撃 2,防御 3,回復魔法]");
				option=scan.nextInt();
				if(option==1) {
					attack(anemy);
				}
				else if(option==2) {
					deffense();
				}
				else if(option==3) {
					Character focus=Story_sp2.h_focus(Own);
					live(focus);
				}
				else {
					System.out.println("行動が見つかりません。");
					count++;
					if(count==2) {
						System.out.println(name+"は混乱した。");
						option=1;
					}
				}
			}while((option!=1)&&(option!=2)&&(option!=3));
		}
	}
	
	public void attack(Creature[] anemy) {
		int se;
		do {
		System.out.println("行動を選択してください");
		System.out.println("0,通常攻撃 1,単体魔法 2全体魔法");
		se=scan.nextInt();
		if(se==0) {
			Creature focus=Story_sp2.focus(anemy);
			n_attack(focus);
		}
		else if(se==1) {
			Creature focus=Story_sp2.focus(anemy);
			magic_attack(focus);
		}
		else if(se==2) {
			a_magic(anemy);
		}
		else {
			System.out.println("対象の敵が見つかりません。");
		}
		}while((se<0)||(se>3));
	}
	public void deffense() {
		System.out.println(name+"が防御した");
	}
	public void n_attack(Creature focus) {
		System.out.println(name+"の攻撃!");
		System.out.println(name+"は5のダメージを与えた。");
		focus.damege(5);
	}
	public void magic_attack(Creature focus) {
		System.out.println(name+"のサンダーレイン!");
		Mp=Mp-15;
		if(Mp<=0) {
			Mp=0;
			System.out.println(name+"はMpを使い果たしてしまった。");
		}
		System.out.println(name+"はMpを15消費した。 Mp"+Mp+"/"+MaxMp);
		int givdm=(4*MaxMp)/5;
		System.out.println(name+"は"+givdm+"のダメージを与えた。");
		focus.damege(givdm);
	}
	public void a_magic(Creature[] anemy) {
		System.out.println(name+"のメテオフォール!");
		Mp=Mp-30;
		if(Mp<=0) {
			Mp=0;
			System.out.println(name+"はMpを使い果たしてしまった。");
		}
		System.out.println(name+"はMp30消費した。 Mp"+Mp+"/"+MaxMp);
		int i,givdm=(3*MaxMp)/4;
		System.out.println("敵全体に"+givdm+"のダメージ!");
		for(i=0;i<anemy.length;i++) {
			anemy[i].damege(givdm);
		}
	}
	public void live(Character focus) {
		System.out.println(name+"は回復魔法を唱えた。");
		Mp=Mp-15;
		if(Mp<=0) {
			Mp=0;
			System.out.println(name+"はMpを使い果たしてしまった。");
		}
		System.out.println(name+"はMp15消費した。 Mp"+Mp+"/"+MaxMp);
		int givp=MaxMp/2;
		focus.heal(givp);
	}
	
	public void birth_a(int m) {
		System.out.println(type+"クラスよりステータス'Mp'を得た。");
		Mp=m;
		MaxMp=Mp;
		if(Mp<0) {
			System.out.println("異常な設定値のためMpを0に設定しました。");
			Mp=0;
			MaxMp=0;
		}
	}

}
