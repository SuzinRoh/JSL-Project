/*
 * 순위 구하기 
 * 60 90 77 80
 * 7  1   3  2
 * 
 */
public class Exam_02 {

	public static void main(String[] args) {
		int score[]= {60,90,77,80,85,55,79,80};
		int rank[]=new int[score.length];
		//int rank[]={1,1,1,1,1}
		for(int x =0;x<score.length;x++) {
			//int r=1;
			rank[x]=1;
			for(int y=0;y<score.length;y++) {
				if(score[x]<score[y]) {
					//r++;
					rank[x]++;
				}
				//rank[x]+=r;
			}
		}
		
		for(int x=0;x<score.length;x++) {
			System.out.print(score[x]+"\t");
		}
		System.out.println();
		for(int x=0;x<rank.length;x++) {
			System.out.print(rank[x]+"\t");
		}
	}
}
