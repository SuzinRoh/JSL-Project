//2차원 배열
public class Exam_03 {

	public static void main(String[] args) {
		int a[][] =new int[5][5];
		int cnt=0;
		for(int x=0; x<a.length-1;x++) {
			for(int y=0;y<a[x].length-1;y++) {
				cnt++;
				System.out.print(cnt+" ");
				a[x][y]=cnt;
				a[x][4]+=cnt;
				a[4][y]+=cnt;
				a[4][4]+=cnt;
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
