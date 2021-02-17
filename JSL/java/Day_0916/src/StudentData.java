
public class StudentData {
	//소트하는 메소드
	public void stuSort(Student_01[] stu,int cnt) {
		
		int temp;
		for(int i=0;i<cnt-1;i++) {//stu.length 로 하면 stu 배열이 넘어가서 10개 > 데이터가 없는 부분은 null이됨 
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
