package study11;

import java.util.Scanner;

public class Hero extends Character {

	//職業 勇者
	
	public Hero() {
		super("勇者");
		job();
	}
	
	public void attack() {
		System.out.println(name+"の攻撃!");
		int givedm=attack+5;
		System.out.println(type+"クラスより与えるダメージ+5");
		System.out.println(name+"は"+givedm+"のダメージを与えた。");
		
	}
	public void deffense() {
		System.out.println(name+"が防御した");
	}
}
