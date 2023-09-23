package study11_2;

public class th_pokemon extends Character implements Thunder{

	th_pokemon() {
		super("でんき");
	}
	
	public void th_attack() {
		System.out.println(name+"は体にでんきをまとい始めた。");
		System.out.println(name+"の'スパーク'");
	}
	
}
