class Sawon{
	int sabun;//�������
	String name;
	int age;
	//������ - ��ü ������ �ʱ�ȭ :Ŭ�����̸��ϰ�Ȱ����޼ҵ� �װ� �����ڶ���� , ����Ʈ������
	Sawon(){
		this(1);//�ڱ��ڽ��� �����ڸ� ȣ���Ҷ� ��
		//�Ű������� 1���� �����ڸ� ȣ��
	}//��kƮ�� ����Ҽ����� �⺻�������ʱ�ȭ , �����ڸ޼ҵ�
	Sawon(int sabun){//�����ȣ�� �ʱⰪ���� ���������
		this(sabun,"�̻��");
		this.sabun=sabun; //this.sabun =class �ڱ��ڽ��� �ǹ� 
		//�������           ��������
	}
	Sawon(int sabun,String name){
		this(sabun,name,35);//this �� ù�ٿ� �Ѱ��ۿ� ����
		this.sabun=sabun;
		this.name=name;
	}
	Sawon(int s,String n,int a){
		sabun = s;
		name = n;
		age = a;
	}
	//������ �����ε� (Ÿ���ϰ� ������ �޸�) int ���� �� �ΰ��� ������ �޼ҵ尡 ������ �������� Ÿ�԰� ������ �޶�ߴ�
	//�����ε� �ִ����� ��ü�� �����ϴ� ����� �������� >������������ 
	
	//������� ���
	
	public void sawonPrint() {
		System.out.println(sabun+"\t"+name+"\t"+age);
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		Sawon s1=new Sawon(1,"����",30);//������ �żҵ� d�̺κ�>>Sawon()
		Sawon s2=new Sawon(2,"�ڻ��",33);
		Sawon s3=new Sawon();
		s1.sawonPrint();
		s2.sawonPrint();
		s3.sawonPrint();
	}

}
