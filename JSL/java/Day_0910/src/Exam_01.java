/*
 * 순위 구하기 
 * 60>7
 * 90>1
 * 77>
 */
public class Exam_01 {

	public static void main(String[] args) {
		int score[]= {60,90,77,80,85,55,79,80};
		//int rank[]=new int[10];
		for(int x =0;x<score.length;x++) {
			int r=1;
			System.out.print(score[x] + "->");
			for(int y=0;y<score.length;y++) {
				if(score[x]<score[y]) {
					r++;
				}
			}
			System.out.println(r);
		}
	}
}
