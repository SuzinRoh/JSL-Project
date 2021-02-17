import java.io.IOException;

//예외처리 (Exception), Error

public class Exam_06_1 {

	public static void main(String[] args) {
		
		System.out.println("1문자 입력 :");
		
		try {//예외가 날 가능성이 있는부분
			int a = System.in.read();
		}catch(IOException e) {//실제 에러가난 부분 처리 //캐치 작은 오류부터 큰오류 순으로 걸어야댐
			e.printStackTrace();
		}catch(Exception ee) {
			ee.printStackTrace();
		}finally {//발생하던 안하던 작업해야할경우 파이널리 씀
			
		}
	}

}
