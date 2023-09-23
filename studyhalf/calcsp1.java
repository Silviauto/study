package studyhalf;
public class calcsp1 {  								//calcの裏方
	public static int[] place1234(int[] form) {			//配列内で指定した文字の位置を抜き出す。
		int target_count=count1234(form);
		int[] targetplace=new int[target_count];
		int i,j=0;
		for(i=0;i<form.length;i++) {
			if(form[i]!=0) {
					targetplace[j]=i;
					j=j+1;
				}
			}
		return targetplace;
	}
	public static int count1234(int[] form) {			//配列内で指定した文字の個数を記録する。
		int i,count=0;
		for(i=0;i<form.length;i++) {
			if(form[i]!=0) {
				count=count+1;
			}
		}
		return count;
	}
	
	public static int count2target(int[] form,int target1,int target2) {	//配列内で指定した文字の個数を記録する。
		int i,count=0;
		for(i=0;i<form.length;i++) {
			if(form[i]==target1) {
				count=count+1;
			}
			else if(form[i]==target2) {
				count=count+1;
			}
		}
		return count;
	}
	
	
	public static String[] line(String formula) {				//数式を数字と演算子で分けた配列にする。
		int[] formula_06=kadaiC_Change.formula_06(formula);
		int[] place3=kadaiC_divide.target_place(formula_06,3);	//"*" の場所
		int[] place4=kadaiC_divide.target_place(formula_06,4);	//"/" の場所
		int[] place1234=calcsp1.place1234(formula_06);
		
		if(place1234.length==0) {								//式に演算子がない場合
			String[] answer=new String[1];
			answer[0]=formula;
			return answer;
			}
		if(place1234.length==1) {								//式が-Aで終わっている場合
			if(formula.substring(0,1).equals("-")) {
				String[] answer=new String[1];
				answer[0]=formula;
				return answer;
			}
		}
			String[] divformula=new String[2*place1234.length+1];
			int h=0,g=0,f=0,finish=0;
			for(h=0;h<formula.length();h++){
				if(h!=place1234[g]) {
					if(h!=formula.length()-1) {
						if(finish!=1) {
							divformula[f]=formula.substring(h,place1234[g]);
								h=h+place1234[g]-h-1;
								f++;
						}
						else {
							divformula[f]=formula.substring(h,formula.length());
							h=formula.length();
						}
					}
					else if(h==formula.length()-1) {											
						divformula[f]=formula.substring(h,formula.length());
					}
					}
				
				else {
					if(g!=place1234.length-1) {
						divformula[f]=formula.substring(place1234[g],place1234[g]+1);
						g++;
						f++;
					}
					else {
						divformula[f]=formula.substring(place1234[g],place1234[g]+1);
						f++;
						finish++;
					}
				}
			}
			int a,count=0;
			for(a=0;a<divformula.length;a++) {
				if(divformula[a]==null) {
					count++;
				}
			}
			String[] redivform=new String[divformula.length-count];
			int b;
			for(b=0;b<redivform.length;b++) {
				redivform[b]=divformula[b];
			}
			return redivform;

	}
	
	public static int count234(String[] formula) {			//演算子の重なっている場所の個数を確認(*/と-)
		int count=0,i;
		for(i=0;i<formula.length;i++) {
			if(formula[i].equals("-")) {
				if(formula[i+1].equals("*")) {
					count++;
				}
			}
			else if(formula[i].equals("*")) {
				if(formula[i+1].equals("-")) {
					count++;
				}
			}
			if(formula[i].equals("-")) {
				if(formula[i+1].equals("/")) {
					count++;
				}
			}
			else if(formula[i].equals("/")) {
				if(formula[i+1].equals("-")) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static int count12(String[] formula) {		//+-を-に　--を+に変える関数
		int count=0,i;
		for(i=0;i<formula.length;i++) {
			if(formula[i].equals("+")) {
				if(formula[i+1].equals("-")) {
					count++;
				}
			}
			else if(formula[i].equals("-")) {
				if(formula[i+1].equals("+")) {
					count++;
				}
			}
			if(formula[i].equals("-")) {
				if(formula[i+1].equals("-")) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static String[] confirm23(String[] formula) {		//演算子の重なり(*/と-)を整える関数
		int i,a;
		int count=count234(formula);
		String[] reform=new String[formula.length-count];
		int j;
		for(j=0;j<reform.length;j++) {
			if(formula[j].equals("-")) {
				if(formula[j+1].equals("*")) {
					formula[j]=formula[j-1];
					formula[j-1]="-";
					formula[j+1]="*";
				}
			}
			else if(formula[j].equals("*")) {
				if(formula[j+1].equals("-")) {
					formula[j]=formula[j-1];
					formula[j-1]="-";
					formula[j+1]="*";
				}
				}
			if(formula[j].equals("-")) {
				if(formula[j+1].equals("/")) {
					formula[j]=formula[j-1];
					formula[j-1]="-";
					formula[j+1]="/";
				}
			}
			else if(formula[j].equals("/")) {
				if(formula[j+1].equals("-")) {
					formula[j]=formula[j-1];
					formula[j-1]="-";
					formula[j+1]="/";
				}
				}
			}
		System.out.print("演算子順番変更 ");
		reform=corrected12(formula);
		for(a=0;a<reform.length;a++) {
			System.out.print(reform[a]);
		}
		System.out.print("\n");
		return reform;
	}
	
	public static String[] corrected12(String[] formula) {		//演算子の重なり(+-と--)を整える関数
		int i,count=0,a;
		String[] reform;
		for(i=0;i<formula.length;i++) {
			if(formula[i].equals("+")) {
				if(formula[i+1].equals("-")) {
					formula[i]="-";
					System.arraycopy(formula,i+2,formula,i+1,formula.length-(i+2));
					count++;
				}
			}
			if(formula[i].equals("-")) {
				if(formula[i+1].equals("+")) {
					formula[i]="-";
					System.arraycopy(formula,i+2,formula,i+1,formula.length-(i+2));
					count++;
				}
			}
			
			if(formula[i].equals("-")) {
				if(formula[i+1].equals("-")) {
					formula[i]="+";
					System.arraycopy(formula,i+2,formula,i+1,formula.length-(i+2));
					count++;
				}
			}
			}
		reform=new String[formula.length-count];
		for(a=0;a<reform.length;a++) {
			reform[a]=formula[a];
		}
		return reform;
		}
	
	public static String[] confirm2(String[] formula) {		//数式の初めが-のとき、初めの数字を負の数として計算するため
		String[] reform=new String[formula.length-1];
		reform[0]="-"+formula[1];
		int i;
		for(i=1;i<reform.length;i++) {
		reform[i]=formula[i+1];	
		}
		return reform;
	}
	
	public static String[] check(String[] divformula) {				//式中の*-,-*の演算子の重なりと整える	
		int count234=count234(divformula);
		int count12=count12(divformula);
		System.out.println("-*,/-などの重なり回数="+count234);
		
		if(count234!=0) {
			divformula=calcsp1.confirm23(divformula);				//重なりがあれば順番を整える
		}
		if(count12!=0) {
			divformula=corrected12(divformula);
		}
		
		return divformula;
	}
	
	
	public static int[] formula_06(String[] formula) {			//配列を文字列に直し06で表す
		String reformula=String.join("",formula);
		int[] reformula_06=kadaiC_Change.formula_06(reformula);
		return reformula_06;
	}
}



