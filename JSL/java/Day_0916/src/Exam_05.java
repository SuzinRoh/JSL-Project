//�̱���
//����Ʈ������ ������
class DD{
	int x=100;
	
	private DD() {}//�ܺλ������ DD d1=new DD() ����
	
	private static DD instance =new DD();//dd��ü����
	             //v ����Ÿ�� class ����
	public static DD getInstance(){
		
		return instance;
		//Ŭ���� ��ü instance�� ���� 
	}
}
public class Exam_05 {
	public static void main(String[] args) {
		/*
		DD d1=new DD();//������ ����
		DD d2=new DD();
		*/
		DD d1=DD.getInstance();//�޼ҵ� ȣ�� > �޼ҵ� �ȿ��ִ� return �� instance ��ü�� ������
		DD d2=DD.getInstance();
		if(d1==d2) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		}//�̱���
	
		
		
	}

}
