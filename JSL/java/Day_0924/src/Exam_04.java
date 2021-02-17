//익명중첩클래스
/*기존 클래스의 특징 메소드를 오버라이딩 하여 재정의해서 사용
 * 
 */
class Inner3{
	public void aaa() {
		System.out.println("aaaaaa");
	}
	public void bbb() {
		System.out.println("bbbbbb");
	}
}

public class Exam_04 {

	public static void main(String[] args) {
		Inner3 i3=new Inner3();
		i3.aaa();
		i3.bbb();
		Inner3 in4=new Inner3() {
			public void aaa() {
				System.out.println("aaaaaabbbbb");
			}// 오버라이딩만되고 메소드추가는 안됨
			
		};
		in4.aaa();
	}

}
