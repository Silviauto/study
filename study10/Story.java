package study10;

import java.util.Scanner;

public class Story {
	public static void main(String args[]) {
		//問題10-1
		System.out.println("問題10-1");
		Evolved_Pokemon pika=new Evolved_Pokemon();
		pika.attack();
		pika.deffense();
		pika.heal();
		System.out.println("\n問題10-3\n");
		
		Scanner scan=new Scanner(System.in);
		Hero h1=new Hero("武闘家");
		SuperHero sh1=new SuperHero();
		Magician m1=new Magician();
		SuperMagician spm1=new SuperMagician();
		
		Monster D1=new Monster();
		SuperMonster sD1=new SuperMonster();
		
		int result=0;
		int option;
		int skill;
		int focus;
		int Turn=1;
		
		System.out.println("\n\n"+D1.getName()+"と"+sD1.getName()+"が現れた。");
		do {
		System.out.println("[ターン"+Turn+"]\n");
		System.out.println("<勇者パーティ>");
		sh1.display();
		h1.display();
		spm1.display();
		m1.display();
		System.out.println("\n<魔物>");
		sD1.display();
		D1.display();
		
		sD1.poison();	
		/////////////////////////////////////////////////////////	武闘家
			if(h1.gethp()<=0) {
				System.out.println(h1.getName()+"は既に倒れている。");
			}
			else {
				System.out.println("["+h1.getName()+"]の行動を選択してください");
				System.out.println("1,攻撃 2,防御");
				option=scan.nextInt();
				if(option==1) {
					System.out.println("攻撃対象を選択してください");
					System.out.println("1,"+sD1.getName()+" 2,"+D1.getName());
					focus=scan.nextInt();		//攻撃対象
					if(focus==1) {
						h1.attack(sD1.getName());
						sD1.damege(h1.attack_damege());
					}
					else if(focus==2) {
						h1.attack(D1.getName());
						D1.damege(h1.attack_damege());
					}
					else {
						System.out.println("対象が見つかりません。");
						System.out.println(h1.getName()+"は攻撃を外した。");
					}
				}
				else if(option==2) {
					h1.deffense();
				}
				else {
					System.out.println(h1.getName()+"は混乱した。");
				}
			}
		//////////////////////////////////////////////////////////////////////////	ソーサラー
			if(spm1.gethp()<=0) {
				System.out.println(spm1.getName()+"は既に倒れている。");
			}
			else {
				System.out.println("["+spm1.getName()+"]の行動を選択してください");	//行動選択
				System.out.println("1,通常攻撃 2,魔法攻撃 3,強化魔法攻撃 4,回復魔法");
				option=scan.nextInt();
				if((option==1)||(option==2)||(option==3)) {
					System.out.println("攻撃対象を選択してください");
					System.out.println("1,"+sD1.getName()+" 2,"+D1.getName());	//攻撃対象
					focus=scan.nextInt();
					if((focus==1)||(focus==2)) {
						if(option==1) {
							if(focus==1) {
								spm1.attack(sD1.getName());						
								sD1.damege(spm1.attack_damege());
							}
							else if(focus==2) {
								spm1.attack(D1.getName());						
								D1.damege(spm1.attack_damege());
							}
						}
						else if(option==2) {
							if(focus==1) {
								spm1.magicI_attack(sD1.getName());						
								sD1.damege(spm1.magicI_damege());
							}
							else if(focus==2) {
								spm1.magicI_attack(D1.getName());						
								D1.damege(spm1.magicI_damege());
							}
						}
						else if(option==3) {
							if(focus==1) {
								spm1.magicII_attack(sD1.getName());						
								sD1.damege(spm1.magicII_damege());
							}
							else if(focus==2) {
								spm1.magicII_attack(D1.getName());						
								D1.damege(spm1.magicII_damege());
							}
						}
					}
					else {
						System.out.println("対象が見つかりません。");
						System.out.println(spm1.getName()+"は攻撃を外した。");
					}
				}
				else if(option==4) {
					System.out.println("回復対象を選択してください");
					System.out.println("1,"+sh1.getName()+" 2,"+h1.getName()+" 3,"+m1.getName()+" 4,"+spm1.getName());
					focus=scan.nextInt();
					if(focus==1) {
						spm1.live(sh1.getName());
						sh1.heal(spm1.gethealp());
					}
					else if(focus==2) {
						spm1.live(h1.getName());
						h1.heal(spm1.gethealp());
					}
					else if(focus==3) {
						spm1.live(m1.getName());
						m1.heal(spm1.gethealp());
					}
					else if(focus==4) {
						spm1.live(spm1.getName());
						spm1.heal(spm1.gethealp());
					}
					else {
						System.out.println("対象が見つかりません。");
						System.out.println("詠唱失敗!");
					}
				}
				else {
					System.out.println(spm1.getName()+"は混乱した。");
				}
			}
			/////////////////////////////////////////////////////////////////	魔王
			if(sD1.gethp()<=0) {
				System.out.println(sD1.getName()+"は既に倒れている。");
			}
			else {
				if(Turn%2==1) {					//ヘイト 大勇者→勇者→ソーサラー→メイジ
					if(sh1.gethp()>0) {
						sD1.attack(sh1.getName());
						sh1.damege(sD1.getat());
						sh1.repoison();
						sh1.poison();
					}
					else if(sh1.gethp()<=0) {
						sD1.attack(h1.getName());
						h1.damege(sD1.getat());
						h1.repoison();
						h1.poison();
					}
					else if(h1.gethp()<=0) {
						sD1.attack(spm1.getName());
						spm1.damege(sD1.getat());
						spm1.repoison();
						spm1.poison();
					}
					else if(sh1.gethp()<=0) {
						sD1.attack(m1.getName());
						m1.damege(sD1.getat());
						m1.repoison();
						m1.poison();
					}
					else {
						System.out.println(D1.getName()+"は退屈そうにしている。");
					}
				}
				else {
					sD1.bress();
					h1.damege(sD1.getbressat());
					sh1.damege(sD1.getbressat());
					m1.damege(sD1.getbressat());
					spm1.damege(sD1.getbressat());
				}
			}
			/////////////////////////////////////////////////////////////////小モンスター
			if(D1.gethp()<=0) {
				System.out.println(D1.getName()+"は既に倒れている。");
			}
			else {
				if(Turn%2==1) {
					D1.bress();
					h1.damege(D1.getbressat());
					sh1.damege(D1.getbressat());
					m1.damege(D1.getbressat());
					spm1.damege(D1.getbressat());
				}
				else {
					if(sh1.gethp()>0) {
						D1.attack(sh1.getName());
						sh1.damege(D1.getat());
					}
					else if(sh1.gethp()<=0) {
						D1.attack(h1.getName());
						h1.damege(D1.getat());
					}
					else if(h1.gethp()<=0) {
						D1.attack(sh1.getName());
						sh1.damege(D1.getat());
					}
					else if(sh1.gethp()<=0) {
						D1.attack(m1.getName());
						m1.damege(D1.getat());
					}
					else {
						System.out.println(D1.getName()+"は退屈そうにしている。");
					}
				}
			}
			/////////////////////////////////////////////////////////////////	魔導士
			if(m1.gethp()<=0) {
				System.out.println(m1.getName()+"は既に倒れている。");
			}
			else {
				System.out.println("["+m1.getName()+"]の行動を選択してください");	//行動選択
				System.out.println("1,通常攻撃 2,魔法攻撃 3,回復魔法");
				option=scan.nextInt();
				if((option==1)||(option==2)) {
					System.out.println("攻撃対象を選択してください");
					System.out.println("1,"+sD1.getName()+" 2,"+D1.getName());	//攻撃対象
					focus=scan.nextInt();
					if((focus==1)||(focus==2)) {
						if(option==1) {
							if(focus==1) {
								m1.attack(sD1.getName());						
								sD1.damege(m1.attack_damege());
							}
							else if(focus==2) {
								m1.attack(D1.getName());						
								D1.damege(m1.attack_damege());
							}
						}
						else if(option==2) {
							if(focus==1) {
								m1.magicI_attack(sD1.getName());						
								sD1.damege(m1.magicI_damege());
							}
							else if(focus==2) {
								m1.magicI_attack(D1.getName());						
								D1.damege(m1.magicI_damege());
							}
						}
					}
					else {
						System.out.println("対象が見つかりません。");
						System.out.println(m1.getName()+"は攻撃を外した。");
					}
				}
				else if(option==3) {
					System.out.println("回復対象を選択してください");
					System.out.println("1,"+sh1.getName()+" 2,"+h1.getName()+" 3,"+m1.getName()+" 4,"+spm1.getName());
					focus=scan.nextInt();
					if(focus==1) {
						m1.live(sh1.getName());
						sh1.heal(m1.gethealp());
					}
					else if(focus==2) {
						m1.live(h1.getName());
						h1.heal(m1.gethealp());
					}
					else if(focus==3) {
						m1.live(m1.getName());
						m1.heal(m1.gethealp());
					}
					else if(focus==4) {
						m1.live(spm1.getName());
						spm1.heal(m1.gethealp());
					}
					else {
						System.out.println("対象が見つかりません。");
						System.out.println("詠唱失敗!");
					}
				}
				else {
					System.out.println(m1.getName()+"は混乱した。");
				}
			}
			/////////////////////////////////////////////////////////////////	大勇者
			if(sh1.gethp()<=0) {
				System.out.println(sh1.getName()+"は既に倒れている。");
			}
			else {
				System.out.println("["+sh1.getName()+"]の行動を選択してください");
				System.out.println("1,攻撃 2,防御");
				option=scan.nextInt();
				if(option==1) {
					System.out.println("攻撃対象を選択してください");
					System.out.println("1,"+sD1.getName()+" 2,"+D1.getName());
					focus=scan.nextInt();		//攻撃対象
					if(focus==1) {
						sh1.attack(sD1.getName());
						sD1.damege(sh1.attack_damege());
					}
					else if(focus==2) {
						sh1.attack(D1.getName());
						D1.damege(sh1.attack_damege());
					}
					else {
						System.out.println("対象が見つかりません。");
						System.out.println(sh1.getName()+"は攻撃を外した。");
					}
				}
				else if(option==2) {
					sh1.deffense();
				}
				else {
					System.out.println(sh1.getName()+"は混乱した。");
				}
			}
			/////////////////////////////////////////////////////////////////	
			sh1.poison();	//毒があれば発動
			h1.poison();
			m1.poison();	
			spm1.poison();
		result=story_sp1.finish(h1.gethp(),sh1.gethp(),m1.gethp(),spm1.gethp(),D1.gethp(),sD1.gethp());
		Turn++;
		}while(!((result==1)||(result==2)));

		////////////////////////////////////////////////////
		if(result==1) {
			System.out.println("勇者たちは力尽きてしまった。");
		}
		if(result==2) {
			System.out.println("魔物が全滅した。");
		}
		
		
	}
	
	
	
}
