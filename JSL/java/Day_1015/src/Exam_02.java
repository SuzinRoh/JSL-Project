import java.util.*;

//stack
public class Exam_02 {

	public static void main(String[] args) {
		//���� pushdown ����popup
		Stack stack =new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");

		String str = (String)stack.peek();
		System.out.println(str);
		System.out.println("���û����� :"+stack.size());
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
		System.out.println("���û����� :"+stack.size());
	}

}
