import java.io.*;
public class Exam_02 {

	public static void main(String[] args) {
		File file = new File("E:\\a.txt");
		if(file.exists()) {
			file.deleteOnExit();//�����α׷��� ����ɶ� �� ������ �����Ѵ� (�ڵ�����)
			System.out.println("���ϸ� :"+file.getName());
			System.out.println("���� ��� :"+file.getPath());
			System.out.println("���� ��� :"+file.getParent());
			System.out.println("����ũ�� :"+file.length()+"Kb");
			System.out.println("���������� :"+file.lastModified());
			
		}else {
			System.out.println(file.getName()+" is Not exists.");
		}
	}

}
