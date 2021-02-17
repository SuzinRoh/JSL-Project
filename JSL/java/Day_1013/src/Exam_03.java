/* ID  : xxx
 * 이름  : xxx
 * 전화  : xxx
 */
import java.text.*;

public class Exam_03 {

	public static void main(String[] args) {
		String id = "user01";
		String name ="김학생";
		String tel = "010-1111-1111";
		
		String str = "ID :" + id +"  이름 :"+ name + "  전화 :" + tel;
		System.out.println(str);
		
		String message = "ID :{0}   이름 :{1}    전화 :{2}";
		String result = MessageFormat.format(message,id,name,tel);
		//배열일때 for 문
		System.out.println(result);
	}

}
