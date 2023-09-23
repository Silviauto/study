package study7;

public class store {
	private static String[] allname;
	private static int[] allHp;
	private static int charactercount=0;
	
	public static void addedit(String name) {
		charactercount++;
		String[] sortname=new String[charactercount];
		if(allname==null) {
			sortname[0]=name;
			allname=sortname;
		}
		else {
			System.arraycopy(allname,0,sortname,0,allname.length);
			sortname[allname.length]=name;
			allname=sortname;
		}
	}
	
	public static void addhp(int at) {
		int[] sorthp=new int[charactercount];
		if(charactercount==1) {
			allHp[0]=at;
		}
		else {
			System.arraycopy(allHp,0,sorthp,0,allHp.length);
			sorthp[allHp.length]=at;
			allHp=sorthp;
		}
	}
}
