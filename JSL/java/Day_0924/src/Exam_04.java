//�͸���øŬ����
/*���� Ŭ������ Ư¡ �޼ҵ带 �������̵� �Ͽ� �������ؼ� ���
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
			}// �������̵����ǰ� �޼ҵ��߰��� �ȵ�
			
		};
		in4.aaa();
	}

}
