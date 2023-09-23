package studyhalf;
public class kadaiC_proto {
	public static double proto(String formula) {		//()の優先度から計算まですべて行うファイル
		System.out.println("考える数式は"+formula);
		int[] formula_06=kadaiC_Change.formula_06(formula);
		int[] place5=kadaiC_divide.target_place(formula_06,5);		//"(" の場所特定
		
		if(place5.length!=0) {										//数式に()がなければelseに行き計算開始
			String[] div=div56(formula,formula_06);					//()とそれ以外で文字列を分ける
			String newproto=emit(formula,div);						//分けた文字列が合っているか確認
			
			String[] jdiv=new String[div.length];					//最外()を抜いた分の文字列配列を用意
			jdiv=blank(div);										//()で分けられた文字列は最外の()を外す
			double[] dansweri=new double[div.length];
			String[] danswers=new String[div.length];
			int i;
			for(i=0;i<div.length;i++) {
				dansweri[i]=kadaiC_proto.proto(jdiv[i]);			//分けた()文字列1つずつ今いるファイルに落とし、さらに()があれば分解or計算する
				danswers[i]=Double.toString(dansweri[i]);			//出た各()の解をint→String型にする。
			}
			String reformula=inmit(formula,danswers,div);			//元の数式が()無しで表せれる。()の各解を連結。
			double answer=kadaiC_calc.calc(reformula);					//()がない数式を計算
			return answer;											//答え
		}
		else {
			double answer;
			return answer=kadaiC_calc.calc(formula);
		}
	}
	
	public static String[] div56(String formula,int[] formula_06) {
		int[] place5=kadaiC_divide.target_place(formula_06,5);			//"(" の場所
		int[] place6=kadaiC_divide.target_place(formula_06,6);			//")" の場所

		String[] divform=new String[place5.length];
		int i,j=0,k=0,count=0,count5=0;
		for(i=0;i<place5.length;i++) {
			if(formula.substring(place5[j]+1,place6[j]+1).contains("(")) {
				count5=count5(formula.substring(place5[j]+1,place6[j]+1));
				divform[k]=formula.substring(place5[j],place6[j+count5]+1);
				j=j+1+count5;
				k++;
				i=i+count5;
				count=count+count5;
			}
			else {
				divform[k]=formula.substring(place5[j],place6[j]+1);
				j++;
				k++;
			}															//もともとi++
		}
		String[] finform=new String[place5.length-count];
		int m;
		for(m=0;m<place5.length-count;m++) {
			finform[m]=divform[m];
		}
		return finform;
	}
	
	public static int count5(String partform) {
		int count=0;
		int i;
		for(i=0;i<partform.length();i++) {
			if(i!=partform.length()-1) {
				if(partform.substring(i,i+1).equals("(")) {
					count++;
				}
			}
		}
		return count;
	}
	public static String emit(String formula,String[] divform) {
		String newproto=null;
		int h=0,i,j,k=0,m=0;
		for(i=0;i<formula.length();i++) {
			for(j=h;j<formula.length();j++) {
				if(formula.substring(i,j).equals(divform[m])) {
					formula=formula.substring(k,i)+divform[m]+formula.substring(j,formula.length());
					i=j;
					h=j;
					m++;
				}
				if(m==divform.length) {
					i=formula.length()-1;
					j=formula.length()-1;
				}
			}
			h++;
			if(i==formula.length()-1) {
				newproto=formula;
			}
		}
		return newproto;
	}
	
	public static String inmit(String formula,String[] danswers,String[] divform) {
		String newproto=null;
		
		int h=0,i,j,k=0,m=0;
		for(i=0;i<formula.length()+1;i++) {
			for(j=h;j<formula.length()+1;j++) {
				if(formula.substring(i,j).equals(divform[m])) {
					formula=formula.substring(k,i)+danswers[m]+formula.substring(j,formula.length());
					j=j-(divform[m].length()-danswers[m].length());
					i=j;
					h=j;
					m++;
				}
				
				if(m==danswers.length) {
					i=formula.length();
					j=formula.length();
				}
			}
			h++;
			if(i==formula.length()) {
				newproto=formula;
			}
		}
		System.out.println("\n計算後、前式と合わせて"+newproto);
		String corrected=correct(newproto);						//+-,-+を-にする関数
		return corrected;
	}
	
	public static String[] blank(String[] div) {
		String[] jdiv=new String[div.length];
		
		int i,j=0;
		for(i=0;i<div.length;i++) {
			jdiv[j]=div[j].substring(1,div[j].length()-1);
			j++;		
		}
		return jdiv;
	}
	
	public static String correct(String formula) {
		String corrected=null;
		int i,j=0,f=formula.length();
		for(i=0;i<f;i++) {
			if(formula.substring(i,i+2).equals("+-")) {
				formula=formula.substring(0,i)+"-"+formula.substring(i+2,formula.length());
				f=f-1;
			}
			else if(formula.substring(i,i+2).equals("-+")) {
				formula=formula.substring(0,i)+"-"+formula.substring(i+2,formula.length());
				f=f-1;
			}
			
			if(i==f-2) {
				i=f
;			}
		}
		corrected=formula;
		return corrected;
	}

}
