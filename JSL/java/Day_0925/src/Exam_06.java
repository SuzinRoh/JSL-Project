import java.util.Arrays;

//clone() : �ڽ��� ���� ���ο� �ν��Ͻ� ���� 
//cloneable �������̽� �����ؾ� �����Ŭ���� �����ǵ�
public class Exam_06 {

	public static void main(String[] args) {
		int a[]= {10,20,50,40,60,50,66};
		int b[]= new int[a.length];
		
		for(int x=0;x<a.length;x++) {
			b[x]=a[x];
		}
		
		int c[]=a.clone();//����ڰ� ���� Ŭ������ ������ �ȉ�
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		
		String[] str = {"aaa","bbb","ccc"};
		String[] str2=str.clone();
		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString(str2));
	}

}
