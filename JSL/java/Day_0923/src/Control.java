
public interface Control {
	int MAX_VOLUME =10;//�ڵ����� static final �� ��
	int MIN_VOLUME =0;
	//�߻� �޼ҵ� ����
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	//����Ʈ �޼ҵ� 
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("����");
		}else {
			System.out.println("���� ����");
		}
	}
	//�����޼ҵ�
	static void changeBattery() {
		System.out.println("�������� ��ü�մϴ�");
	}
}
