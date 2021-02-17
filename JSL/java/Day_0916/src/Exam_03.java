

//메소드 오버로딩
class AA{//오버로딩은 메소드 타입 개수만따짐 
	public void add(int a, int b) {
		
	}
	public int add(int a, double b) {
		return 0;
	}
	public void add(int a, int b,int c) {
		int s= a+b+c;
	}
	//불편해서 등장함> 가변인자
	public void add2(int ... a) {//a라는 매개변수가 무한대로옴
		//a 자체가 배열 
		int tot =0;
		for(int x=0;x<a.length;x++) {//몇갠지 모르니까 
			tot+=a[x];//가변인자의 합계
		}
		System.out.println(tot);
	}
		//     v리턴타임은 뭐든게 다들어갈수있음 클래스건뭐건다댐
		public void add3(int[] a) {//a라는 매개변수가 무한대로옴
			//a 자체가 배열 
			int tot =0;
			for(int x=0;x<a.length;x++) {//몇갠지 모르니까 
				tot+=a[x];//가변인자의 합계
			}
			System.out.println(tot);
	}
	
	
	
}
public class Exam_03 {

	public static void main(String[] args) {
		AA a=new AA();
		a.add(1, 2);//오버로딩하는이유
		a.add(1, 2, 3);
		a.add2(1, 2, 3, 4,5,6,7,8,9,10);//가변인자로할떄
		
		int[] x= {1,2,3,4,5,6,7};//가변인자대신 배열로할때 선언을해서 값을 넣어야함 
		a.add3(x);
	}

}
