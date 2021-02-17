
public class Exam_05 {

	public static void main(String[] args) {
		int a[][]=new int[5][5];
		int cnt=0;
		boolean b=true;
		
		for(int x=0;x<5;x++) {
				if(b) {
					for(int y=0;y<5;y++) {
						cnt++;
						a[x][y]+=cnt;
					}
					cnt+=6;
					b=false;
				}else {
					for(int y=0;y<5;y++) {
						cnt--;
						a[x][y]+=cnt;
					}
					cnt+=4;
					b=true;
				}
			}
		for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				System.out.print(a[x][y]+"\t");
			}
			System.out.println();
		}
		
	}

}
