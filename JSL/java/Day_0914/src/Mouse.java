
public class Mouse {
	//������� ���� =��������,����ʵ�(�Ӽ�)
	String mColor;//���콺����Ӽ�
	int mButtons;//���콺 ��ư�Ӽ�
	String mSystem;//���콺���(��,����)
	
	//����� �޼ҵ�
	public void onClick() {
		System.out.println(mColor + "���콺�� Ŭ���Ǿ����ϴ�");
	}
	public String onDoubleClick() {
		String str= mColor+"Mouse Duble Click";
		return str;
	}
	public int onDrag() {
		int x =100;
		return x+5;
	}
	
}
