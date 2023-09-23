package study11;

import java.util.Scanner;

public class Warrior extends Character {

	//職業 戦士
    protected int shild;		
		
	public Warrior() {
		super("戦士");
		job();
		birth_a();
	}
	
	public void attack() {
		System.out.println(name+"の攻撃!");
		System.out.println(name+"は"+attack+"のダメージを与えた。");
	}
	public void deffense() {
		System.out.println(name+"は守りを固めた");
		deffense=deffense+10;
		shild=deffense;
		if(shild>=MaxHp) {
			shild=MaxHp;
		}
		System.out.println(type+"クラスよりシールドを獲得 シールド"+shild+"/"+MaxHp);
	}
	
	public void birth_a() {
		System.out.println(type+"クラスよりステータス'シールド'を得た。");
	}
	
}
