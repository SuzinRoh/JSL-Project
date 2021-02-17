import java.util.Scanner;

/*data[] 배열에 정수가 n개 오름차순으로 정렬되어 있다.
 * 키보드로 찾을 값을 입력하면 위치를 찾아 되돌려주는 메소드를 만들어
 * 추ㅡㄹ력하는 프로그램을 작성
 * 찾고자 하는 값의 범위는 1~100이어야 한다 (범위예는 입력오류 처리)
 * 입력예시
 * 찾는 값입력(1~100):77
 * 찾는 값 77은 없습니다
 * 찾는값 입력(1~100):30
 * 찾는값 30은 4번째에 있음
 * -99입력
 * 프로그램을 종료합니다
 */
public class Exam_05 {
	static int search(int searchNum,int data[]) {//검색메소드
		int search=searchNum;
		int low=0,
			high=data.length-1,
			mid=0;
		
		while(low<=high) {
			mid=(low+high)/2;
			if(data[mid]==search) {
				return mid;
			}
			if(data[mid]<search) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return -1;//메소드 문에서 return 을만나면 break랑 같은 의미 프로그램 종료 
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int data[]= {5,10,20,25,30,35,40,45,50,60,65,70,75,80,85,90};
		
		while(true) {
			System.out.print("찾는값 입력(1~100) :");
			int searchNum=s.nextInt();
			
			if(searchNum==-99) {
				System.out.println("*프로그램을 종료합니다.*");
				System.exit(1);
			}
			if(searchNum<1 || searchNum>100) {
				System.out.println("*입력 값 범위오류*");
				continue;
			}
			
			int a=search(searchNum,data);//search메소드 return값 a에저장
			
			if(a==-1) {
				System.out.println("찾는 값 "+searchNum+" 은 없습니다.\n");
			}else {
				System.out.println("찾는 값 "+searchNum+" 은 "+a+"번 째에 있습니다. \n");
			}
		}
	}

}
