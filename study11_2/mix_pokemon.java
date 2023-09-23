package study11_2;

public class mix_pokemon extends Character implements flame,Thunder{
	//継承+インターフェイスが出来る。
	
	mix_pokemon() {
		super("でんき","ほのお");
	}
	
	public void th_attack() {
		System.out.println(name+"は体にでんきをまとい始めた。");
		System.out.println(name+"の'スパーク'");
	}
	public void f_attack() {
		System.out.println(name+"の'かえんほうしゃ'");
	}
	public void fire() {
		System.out.println(name+"の'にほんばれ'");
		System.out.println("空が'はれ'になった。");
	}
}
