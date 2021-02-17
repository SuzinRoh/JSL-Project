
public class Exam_06 {

	public static void main(String[] args) {
		
		int[] val = {70,90,60,50,77,88,95,77};
		
		System.out.print("Source Data :");
		for(int x=0;x<val.length; x++) {
			System.out.print(val[x]+" ");
		}
		System.out.println();
		
		
		//Bubble Sort(오름차순)
		for(int x=0;x<val.length-1;x++) {
		boolean b=true;
			for(int  y=0; y<val.length-1-x; y++) {
				if(val[y]>val[y+1]) {
					int temp=val[y];
					val[y]=val[y+1];
					val[y+1]=temp;
					b=false;
				}
				
			}
			if(b) {//sort가 더이상 안돼면 for 문 끝냄
				break;
			}
		}
		
		//출력
				System.out.print("Sort Data :");
				for(int x=0;x<val.length;x++) {
					System.out.print(val[x]+" ");
				}
	}

}
