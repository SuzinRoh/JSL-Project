




public class Exam_01 {

	public static void main(String[] args) {
		int sum;//�������� >�׳ɺ���
		sum=0;
		String str;//���۷���(��������)
		str="";
		
		Mouse m1;//Ŭ���� =��������������� ���۷���(��������)
 		m1 =new Mouse();//�ν��Ͻ�ȭ >��ü����

 		m1.mColor="black";
 		m1.mButtons=3;
 		m1.mSystem="��";
 		System.out.println("���콺 ���� "+ m1.mColor);
 		
 		m1.onClick();
 	
 		Mouse m2=new Mouse();
 		m2.mColor="white";
 		m2.onClick();
	}

}
