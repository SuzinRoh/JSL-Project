import java.io.*;
public class Exam_02 {

	public static void main(String[] args) {
		File file = new File("E:\\a.txt");
		if(file.exists()) {
			file.deleteOnExit();//이프로그램이 종료될때 저 파일을 삭제한다 (자동삭제)
			System.out.println("파일명 :"+file.getName());
			System.out.println("파일 경로 :"+file.getPath());
			System.out.println("파일 경로 :"+file.getParent());
			System.out.println("파일크기 :"+file.length()+"Kb");
			System.out.println("최종수정일 :"+file.lastModified());
			
		}else {
			System.out.println(file.getName()+" is Not exists.");
		}
	}

}
