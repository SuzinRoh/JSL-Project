/*
 * sort 정렬
 * 
 * 1 선택 selection sort
 * 	 x=0 n-1 
 * 2 거품
 * 3 삽입
 * 
 * 
 */
public class Exam_05 {

	public static void main(String[] args) {
	
		int[] val = {70,90,60,50,77,88,95,77};
		System.out.print("Source Data :");
		for(int x=0;x<val.length; x++) {
			System.out.print(val[x]+" ");
		}
		System.out.println();
		//selection sort
		for(int x=0; x<val.length-1; x++) {
			int n=x+1;
			for(int y=n;y<val.length;y++) {
				System.out.println(y);
				if(val[x]>val[y]) {//내림차순일땐 val[x]<val[y]
					int temp =val[x];
					val[x]=val[y];
					val[y]=temp;
				}
			}
		}
		//출력
		System.out.print("Sort Data :");
		for(int x=0;x<val.length;x++) {
			System.out.print(val[x]+" ");
		}
	}

}
