
public class StudentData {
	//��Ʈ�ϴ� �޼ҵ�
	public void stuSort(Student_01[] stu,int cnt) {
		
		int temp;
		for(int i=0;i<cnt-1;i++) {//stu.length �� �ϸ� stu �迭�� �Ѿ�� 10�� > �����Ͱ� ���� �κ��� null�̵� 
			for(int y=i+1;y<cnt;y++) {
				if(stu[i].number>stu[y].number) {
					temp=stu[i].number;
					stu[i].number=stu[y].number;
					stu[y].number=temp;
				}
			}
		}
	}
}
