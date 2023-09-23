package studyhalf;
public class kadaiC_calc {
	public static double calc(String formula) { 							//文字列計算式を計算する。()を含んでいない場合
		System.out.println("\ncalc内部 計算式は"+formula);
			String[] divformula=calcsp1.line(formula);
		if(divformula.length==1) {											//演算子がなければ終了
			double answer=Double.parseDouble(divformula[0]);
			return answer;
		}
		else {	
			divformula=calcsp1.check(divformula);							//演算子の重なりを処理(-+や-*)
			int[] formula_06=kadaiC_Change.formula_06(formula);
			
			int calc34count=calcsp1.count2target(formula_06,3,4);
			String[][] formula34=new String[calc34count+1][];
			formula34[0]=divformula;
			int a;
			int i=0,m=1;
			double A;
			String B;
			while(m<calc34count+１){											//掛け算割り算は先に
				if(formula34[m-1][i].equals("*")) {
					A=Double.parseDouble(formula34[m-1][i-1])*Double.parseDouble(formula34[m-1][i+1]);
					B=Double.toString(A);
					formula34[m-1][i-1]=B;
					System.arraycopy(formula34[m-1],i+2, formula34[m-1],i, formula34[m-1].length-(i+2));	
					formula34[m]=new String[formula34[m-1].length-2];
					System.arraycopy(formula34[m-1],0, formula34[m],0, formula34[m-1].length-2);
					i=i-1;
					m++;
				}
				else if(formula34[m-1][i].equals("/")) {
					A=Double.parseDouble(formula34[m-1][i-1])/Double.parseDouble(formula34[m-1][i+1]);
					if(Double.parseDouble(formula34[m-1][i+1])==0) {
						System.out.println("割り算エラー");
					}
					B=Double.toString(A);
					formula34[m-1][i-1]=B;
					System.arraycopy(formula34[m-1],i+2, formula34[m-1],i, formula34[m-1].length-(i+2));	
					formula34[m]=new String[formula34[m-1].length-2];
					System.arraycopy(formula34[m-1],0, formula34[m],0, formula34[m-1].length-2);
					i=i-1;
					m++;
				}
				i++;
			}
			
			int[] reformula_06=calcsp1.formula_06(formula34[calc34count]);		//足し算引き算
			int calc12count=calcsp1.count2target(reformula_06,1,2);	
			
			if(reformula_06[0]==2) {
				formula34[calc34count]=calcsp1.confirm2(formula34[calc34count]);//計算式の戦闘が-の場合、戦闘の数字を負の数として計算を行う。
				calc12count--;
			}
			String[][] formula12=new String[calc12count+1][];
			formula12[0]=formula34[calc34count];				
			int k=0,n=1;
			double C;
			String D;
			while(n<calc12count+１){	
				if(formula12[n-1][k].equals("+")) {
					C=Double.parseDouble(formula12[n-1][k-1])+Double.parseDouble(formula12[n-1][k+1]);
					D=Double.toString(C);
					formula12[n-1][k-1]=D;
					System.arraycopy(formula12[n-1],k+2, formula12[n-1],k, formula12[n-1].length-(k+2));	
					formula12[n]=new String[formula12[n-1].length-2];
					System.arraycopy(formula12[n-1],0, formula12[n],0, formula12[n-1].length-2);
					k=k-1;
					n++;
				}
				else if(formula12[n-1][k].equals("-")) {
					C=Double.parseDouble(formula12[n-1][k-1])-Double.parseDouble(formula12[n-1][k+1]);
					D=Double.toString(C);
					formula12[n-1][k-1]=D;
					System.arraycopy(formula12[n-1],k+2, formula12[n-1],k, formula12[n-1].length-(k+2));	
					formula12[n]=new String[formula12[n-1].length-2];
					System.arraycopy(formula12[n-1],0, formula12[n],0, formula12[n-1].length-2);
					k=k-1;
					n++;
				}
				k++;
			}
			System.out.print("計算後　");
			for(a=0;a<formula12[calc12count].length;a++) {
				System.out.print(formula12[calc12count][0]);
			}
			double answer=Double.parseDouble(formula12[calc12count][0]);
			return answer;
		}
	}

}


