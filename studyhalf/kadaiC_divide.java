package studyhalf;

public class kadaiC_divide {
	
	public static int[] target_place(int[] form,int target) {	//配列内で指定した文字の位置を抜き出す。
		int target_count=count(form,target);
		int[] targetplace=new int[target_count];
		int i,j=0;
		for(i=0;i<form.length;i++) {
			if(form[i]==target) {
					targetplace[j]=i;
					j=j+1;
				}
			}
		return targetplace;
	}

	public static int count(int[] form,int target) {			//配列内で指定した文字の個数を記録する。
		int i,count=0;
		for(i=0;i<form.length;i++) {
			if(form[i]==target) {
				count=count+1;
			}
		}
		return count;
	}
	
	public static int[] sort(int forml,int[] target1,int[] target2) {
		int i,j=0,k=0,m=0,l=forml;
		int[] sort=new int[target1.length+target2.length];
		for(i=0;i<l;i++) {
			if(i==target1[j]) {
				sort[m]=5;
				if(j!=target1.length-1) {
					j++; 
					m++;
				}
				else {
					m++;
				}
			}
			if(i==target2[k]) {
				sort[m]=6;
				if(k!=target2.length-1) {
					k++; 
					m++;
				}
				else {
					m++;
				}
			}
		}
		int a;
		for(a=0;a<target1.length+target2.length;a++) {
			System.out.print(sort[a]);
	}
		return sort;
	}

}

