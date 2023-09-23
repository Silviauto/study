package study11;

public class armor extends Creature{
	
	//モンスター さまよう鎧
	armor() {
		super("さまよう鎧");
	}
	
	public void attack() {
		System.out.println(name+"の攻撃");
		System.out.println(name+"の'2段切り'");
	}
	public void deffense() {
		System.out.println(name+"が防御した");
	}
}
