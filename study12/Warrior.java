package study12;

import java.util.Scanner;

public class Warrior extends Character {

	//職業 戦士
    protected int shild;	
    protected int up;
		
	public Warrior(String n,int h,int a,int d) {
		super("戦士",n,h,a,d);
		job();
		birth_a();
	}
	
	public void attack(Creature[] anemy) {
		Creature focus=Story_sp2.focus(anemy);
		c_attack(focus);
	}
	public void c_attack(Creature focus) {
		System.out.println(name+"の兜割り");
		int givedm=attack;
		System.out.println(name+"は"+givedm+"のダメージを与えた。");
		focus.damege(givedm);
	}
	
	public void deffense() {
		System.out.println(name+"は守りを固めた");
		deffense=deffense+10;
		shild=deffense;
		if(shild>=up) {
			shild=up;
		}
		System.out.println(type+"クラスよりシールドを獲得 シールド"+shild+"/"+up);
	}
	public void damege(int point) {
		if(Hp<=0) {
			System.out.println(name+"は既に倒れている。");
		}
		else { 						//残飯作成
			if(shild>=point) {
				shild=shild-point;
			}
			else if(shild<point) {
				int rem=point-shild;
				shild=0;
				Hp=Hp-rem;
			}
			if(Hp<0) {
				Hp=0;
				System.out.println(name+" Hp"+Hp+"/"+MaxHp);
				System.out.println(name+"は倒れた。");
			}
			else {
				System.out.println(name+" Hp"+Hp+"/"+MaxHp+" shild"+shild+"/"+up);
			}
		}
	}
	
	public void birth_a() {
		System.out.println(type+"クラスよりステータス'シールド'を得た。");
		up=MaxHp/2;
	}
	
}
