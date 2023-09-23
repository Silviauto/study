package studyhalf;

public class kadaiC_Change {
	public static int[] formula_06(String formula) {		//入力された数式を0から6の数式配列で表す。 (String→int[])
		int i,j,l=formula.length();							//また、
		int[] form_06=new int[l];
		
		int kakko=0;
		form_06=change_06(formula);						//文字列数式を0から6で表す。
		for(i=0;i<l;i++) {	
			if(form_06[i]==5) {
				kakko++;
			}
		}
		if(kakko==0) {									//()が数式にない場合はこの時点で返す。
			return form_06;
		}
		
		int count56=count56(form_06);					//A(B+C)の場合、Aと(の間には*が必要→*の必要数を数える。
		int g=count56;									//gは*の必要数。

		int[] addplace=new int[g];	//*を入れる位置
		addplace=id_place56(count56,form_06);			//加えたいものの場所を特定
		
		int[] reform_06=new int[l+count56];				//3(*)を入れる分の配列スペースを開ける
		reform_06=add_blank(form_06,count56);	
		
		reform_06=add(reform_06,addplace);				//見つけた位置に配列をずらして*(3)を入れたい
		
		return reform_06;
	}

	
	public static int[] change_06(String formula) {		//与えられた文字列を0～6で表す関数。
		int i,l=formula.length();
		int[] form_06=new int[l];
		for(i=0;i<l;i++) {
			if(i!=l-1) {
				if(formula.substring(i,i+1).equals("+")) {
					form_06[i]=1;			
				}
				else if(formula.substring(i,i+1).equals("-")) {
					form_06[i]=2;
				}
				else if(formula.substring(i,i+1).equals("*")) {	
					form_06[i]=3;
				}
				else if(formula.substring(i,i+1).equals("/")) {
					form_06[i]=4;
				}
				else if(formula.substring(i,i+1).equals("(")) {
					form_06[i]=5;
				}
				else if(formula.substring(i,i+1).equals(")")) {
					form_06[i]=6;
				}
				else {
					form_06[i]=0;
				}
			}
			if(i==l-1) {
				if(formula.substring(i)=="+") {
					form_06[i]=1;			
				}
				else if(formula.substring(i).equals("-")) {
					form_06[i]=2;
				}
				else if(formula.substring(i).equals("*")) {		
					form_06[i]=3;
				}
				else if(formula.substring(i).equals("/")) {
					form_06[i]=4;
				}
				else if(formula.substring(i).equals("(")) {
					form_06[i]=5;
				}
				else if(formula.substring(i).equals(")")) {
					form_06[i]=6;
				}
				else {
					form_06[i]=0;
				}
			}
		}
		return form_06;
	}
	
	
	public static int count56(int[] form_06) {		//A(B+C)の場合、Aと(の間には*が必要→*の必要数を見る
		int count=0;
		int l=form_06.length;
		int h;
		for(h=0;h<l;h++) {
			if(h!=l-1) {				
				if(form_06[h]==0) {
					if(form_06[h+1]==5) {
						count=count+1;
					}
				}
				else if(form_06[h]==6) {
					if(form_06[h+1]==0) {
						count=count+1;
					}
				}
			}
		}
		return count;
	}
	
	public static int[] id_place56(int count56,int[] form_06) {	//加えたいものの場所を特定
		int place56[]=new int[count56];
		int j,m=0,l=form_06.length;
		for(j=0;j<l;j++) {
			if(j!=l-1) {									
				if(form_06[j]==0) {
					if(form_06[j+1]==5) {
						place56[m]=j;
						m=m+1;
					}
				}
				else if(form_06[j]==6) {
					if(form_06[j+1]==0) {			////j+1に変更 ()A→()*Aの位置
						place56[m]=j;
						m=m+1;
					}
				}
			}
		}
		return place56;
	}
	
	public static int[] place56(String formula) {		//文字列から（）の位置を返す (String→int[])
		int i,j,l=formula.length();						//5は( 6は)を表す。その位置を特定し返す。
		int[] form_06=new int[l];
		int kakko=0;
		form_06=change_06(formula);						
		for(i=0;i<l;i++) {	
			if(form_06[i]==5) {
				kakko++;
			}
		}
		if(kakko==0) {
			return form_06;
		}
		int count56=count56(form_06);					
		int g=count56;									

		int[] addplace=new int[g];						//*を入れる位置
		addplace=id_place56(count56,form_06);			
		int a;
		for(a=0;a<addplace.length;a++) {
			addplace[a]=addplace[a]+1;
		}
		return addplace;
	}
	
	
	public static int[] add_blank(int[] form,int add_target) {	//加えたい分の枠を増やした配列を返す。
		int i,j,l=form.length;
		int[] reform=new int[l+add_target];
		for(i=0;i<l;i++) {
			reform[i]=form[i];
		}
		return reform;
	}
	
	public static int[] add(int[] form,int[] targetplace) {		//与えられた配列に3(*)を加える関数
		int target=3;
		int[] reform=form;
		int i,j=0,L=form.length;
		if(targetplace.length==0) {
			return form;
		}
		
		for(i=0;i<L;i++) {
			if(i==targetplace[j]) {
				System.arraycopy(form,targetplace[j]+1,form,targetplace[j]+2,form.length-(targetplace[j]+2));
				form[targetplace[j]+1]=3;
				if(i!=targetplace[targetplace.length-1]) {
					j=j+1;
					targetplace[j]=targetplace[j]+1;
				}
				else {
				}
			}
		}
		return reform;
	}
}
