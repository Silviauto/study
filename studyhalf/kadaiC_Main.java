package studyhalf;

public class kadaiC_Main {
	public static void main(String args[]) {
		//かっこの位置を特定 ((12*2)+1)-2 を(A+1)-2 → B-2 とグループに分けて、かっこがない状態で計算をしていく。
		
		System.out.println("計算式を入力してください。 使用可能な演算子は(+, -, *, /)です。");
		String formula=kadaiC_Getform.formula();				//数式を入力してもらうファイル
		int[] formula_06;										//数式を0から6で表す
		
		formula_06=kadaiC_Change.formula_06(formula);		//数式全部を0から6で表す。(*を加える前)
		
		String reformula=kadaiC_group.reform(formula,formula_06);	//int[]で3(*)を加えた場所から与えられた文字列にも*を加えるファイル。
																	//A(B)をA*(B)に書き直すファイル　数式に()がなければスルー
		
		double answer=kadaiC_proto.proto(reformula);					//()の優先度から計算まで行うファイル
		
		
		System.out.println("\n計算結果(答え)は"+answer);
		
	}
}
