package study10;

public class story_sp1 {
	
	public static int finish(int h1,int h2,int h3,int h4,int d1,int d2) {
		int mark=0;
		if((h1<=0)&&(h2<=0)&&(h3<=0)&&(h4<=0)) {
			mark=1;
		}
		if((d1<=0)&&(d2<=0)) {
			mark=2;
		}
		return mark;
	}
}
