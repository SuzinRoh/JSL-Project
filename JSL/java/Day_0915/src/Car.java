
public class Car {
	// �Ӽ� -> ����(�������,����ʵ�)
	String company="����";//������
	int cc=2000;//�ڵ���cc 1500cc 2000cc
	int speed=100;//�ӵ�
	boolean starting=true;//�õ��Ŵ°� �����尪 false 
	
	
	//�ƹ��͵� ���ָ� ����Ʈ �ʱ�ȭ
	//�����尪�� �̸� �ټ�����= ��������ʱ�ȭ
	
	//������� -> �޼ҵ�
	//�õ� �ɱ�/����
	public void startOn() {
		starting =!starting;// false �� �ƴ� =true /true �ϵ� false
	}
	//�ӵ� �ø���
	public void speedUp() {
		speed++;
		System.out.println(speed);
	}
	
	public int speedUp2() {
		speed++;
		return speed;
	}
	//�ӵ� ������
	public void speedDown() {
		speed--;
	}
}
