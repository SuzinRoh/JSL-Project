/*
 * 검색
 * 1. 선형 검색//순서대로 다 찾음
 * 2. 2진 검색(정렬)
 */
public class Exam_03 {
	public static void main(String[] args) {
		
		int data[]= {1,5,7,3,10,23,53,40,30,2,7};
		int search=100;//7을 검색
		boolean b=true;
		System.out.print(search+"는\t");
		for(int x=0;x<data.length;x++) {
			if(data[x]==search) {
				System.out.print(x+"번 째\t");
				//break;
				b=false;
			}
		}
		if(b) {
			System.out.print("값이 없음");
		}
		
	}//----------------------------------------------------------
}
