

//�޼ҵ� �����ε�
class AA{//�����ε��� �޼ҵ� Ÿ�� ���������� 
	public void add(int a, int b) {
		
	}
	public int add(int a, double b) {
		return 0;
	}
	public void add(int a, int b,int c) {
		int s= a+b+c;
	}
	//�����ؼ� ������> ��������
	public void add2(int ... a) {//a��� �Ű������� ���Ѵ�ο�
		//a ��ü�� �迭 
		int tot =0;
		for(int x=0;x<a.length;x++) {//��� �𸣴ϱ� 
			tot+=a[x];//���������� �հ�
		}
		System.out.println(tot);
	}
		//     v����Ÿ���� ����� �ٵ������� Ŭ�����ǹ��Ǵٴ�
		public void add3(int[] a) {//a��� �Ű������� ���Ѵ�ο�
			//a ��ü�� �迭 
			int tot =0;
			for(int x=0;x<a.length;x++) {//��� �𸣴ϱ� 
				tot+=a[x];//���������� �հ�
			}
			System.out.println(tot);
	}
	
	
	
}
public class Exam_03 {

	public static void main(String[] args) {
		AA a=new AA();
		a.add(1, 2);//�����ε��ϴ�����
		a.add(1, 2, 3);
		a.add2(1, 2, 3, 4,5,6,7,8,9,10);//�������ڷ��ҋ�
		
		int[] x= {1,2,3,4,5,6,7};//�������ڴ�� �迭���Ҷ� �������ؼ� ���� �־���� 
		a.add3(x);
	}

}
