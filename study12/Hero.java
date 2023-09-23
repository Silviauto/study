package study12;

import java.util.Scanner;

public class Hero extends Character {

	//職業 勇者
	
	public Hero(String n,int h,int a,int d) {
		super("勇者",n,h,a,d);
		job();
	}
	
	public void attack(Creature[] anemy) {
		Creature focus=Story_sp2.focus(anemy);
		d_attack(focus);	
	}
	
	public void d_attack(Creature focus) {
		System.out.println(name+"のはやぶさ斬り");
		int givedm=attack+15;
		System.out.println(type+"クラスより与えるダメージ+15");
		System.out.println(name+"は"+givedm+"のダメージを与えた。");
		focus.damege(givedm);
	}
	public void deffense() {
		System.out.println(name+"が防御した");
	}
}
