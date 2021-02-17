/* ID  : xxx
 * 이름  : xxx
 * 전화  : xxx
 */
import java.text.*;

public class Exam_03_01 {

	public static void main(String[] args) {
		String msg ="Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}" ;
		
		Object[] arguments = {
				"이자바","02-123-1234","27","07-09"
		};
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);
	}

}
