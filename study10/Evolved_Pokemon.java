package study10;

public class Evolved_Pokemon extends Pokemon{

	public void attack() {		//再定義
		super.attack();			//再定義後に継承もとのメソッド(再定義前)を呼び出したいときはsuper.とする。
		super.attack();
	}
	public void heal() {
		System.out.println("進化後の回復");
	}
}
