//2진검색
/*m=low+high/2
 * search>data[m] >low =m+1
 * 
 * search<data[m] >high =m-1
 * 
 * 검색이 불가능하다 = row>high
 */
public class Exam_04 {

	public static void main(String[] args) {
		int[] data= {10,20,30,35,40,60,65,70,80,85,90,95};
		//		   low									high
		int search=30;
		int low=0;
		int high=data.length-1;
		int sw=0;
		
		while(low<=high) {
			int mid=(low+high)/2;
			if(data[mid]==search) {
				System.out.println(mid+"번째");
				sw=1;
				break;
			}
			if(data[mid]<search) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		if(sw==0) {
			System.out.println("값이 없음");
		}
		
	}

}
