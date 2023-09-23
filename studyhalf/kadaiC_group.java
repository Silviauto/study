package studyhalf;

public class kadaiC_group {
	
	public static String reform(String formula,int[] formula_06) {		//与えられた文字列数式とと0から6に()があれば3を加えた配列を比較する。
		String reform;													//文字列と配列の長さが異なるなら文字列にも*を加えに行く。
		reform=add3(formula,formula_06);
		System.out.println("必要な位置に*を加えると"+reform);
		return reform;				     	//*を加えた数式を返す
	}
	
	public static String add3(String formula,int[] formula_06) {
		String reform;
		if(formula.length()!=formula_06.length) {		//*を加えるときのみ発動
			int[] add3=kadaiC_Change.place56(formula);
			System.out.println("*が必要な個数は"+add3.length);

			String kakeru="*";	
			int i=0,m=0,move=0;
			while(m<add3.length) {
				if(i==add3[m]) {
					if(m!=add3.length-1) {
						formula=formula.substring(0,add3[m])+"*"+formula.substring(add3[m],formula.length());
						add3[m+1]=add3[m+1]+1+move;
						m++;
						move++;
					}
					else {
						formula=formula.substring(0,add3[m])+"*"+formula.substring(add3[m],formula.length());
						m++;						//バグる要因の可能性
					}
				}
				i++;
			}
			return formula;
		}
		return formula;
	}
}
