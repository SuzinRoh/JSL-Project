/* ID  : xxx
 * �̸�  : xxx
 * ��ȭ  : xxx
 */
import java.text.*;

public class Exam_03 {

	public static void main(String[] args) {
		String id = "user01";
		String name ="���л�";
		String tel = "010-1111-1111";
		
		String str = "ID :" + id +"  �̸� :"+ name + "  ��ȭ :" + tel;
		System.out.println(str);
		
		String message = "ID :{0}   �̸� :{1}    ��ȭ :{2}";
		String result = MessageFormat.format(message,id,name,tel);
		//�迭�϶� for ��
		System.out.println(result);
	}

}
