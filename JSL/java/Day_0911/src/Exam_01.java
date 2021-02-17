//2차원 배열
public class Exam_01 {

	public static void main(String[] args) {
		int a[][] =new int[5][5];
		int cnt=0;
		for(int x=0; x<a.length;x++) {
		
			for(int y=0;y<a[x].length;y++) {
				cnt++;
				a[x][y]=cnt;
			}
		}
		
		//출력
		for(int x=0;x<a.length;x++) {
			for(int y=0;y<a[x].length;y++) {
				System.out.print(a[x][y]+"\t");
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
