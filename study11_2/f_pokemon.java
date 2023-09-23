package study11_2;

public class f_pokemon extends Character implements flame{
	
	f_pokemon() {
		super("ほのお");
	}
	
	public void f_attack() {
		System.out.println(name+"の'かえんほうしゃ'");
	}
	public void fire() {
		System.out.println(name+"の'にほんばれ'");
		System.out.println("空が'はれ'になった。");
	}
}
