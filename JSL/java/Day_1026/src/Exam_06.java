import java.io.*;
//�⺻�ڷ����� ���� ���
public class Exam_06 {

	public static void main(String[] args) throws Exception{
		DataOutputStream dos =
				new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(
										new File("E:\\abc.txt"))));
		
		dos.writeInt(23);
		dos.writeDouble(3.14);
		dos.writeBytes("ABCDEF");
		dos.close();

	}

}
