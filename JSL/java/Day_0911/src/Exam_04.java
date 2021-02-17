
public class Exam_04 {

	public static void main(String[] args) {
		int a[][]=new int[5][5];
		int cnt=0;
		
		for(int x=0;x<5;x++) {
			for(int y=0;y<1+x;y++) {
				cnt++;
				a[x][y]=cnt;
			}
		}for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				if(a[x][y]==0) {
					
				}else {
				System.out.print(a[x][y]+"\t");
				}
			}
			System.out.println();
		}
	}

}
