package example;
/*키보드로 사원번호,이름,나이를 입려ㅑㄱ받아서 Set에 저장후 출력하는 프로그램 작성
 * 사번을 기준으로 오름차순 출력하는 프로그램 작성
 * 입력형식
 * 사원등록  1101 , aaa , 23
 * 
 * 출력형식
 * 사원목록
 * 사원번호 이름 나이
 */
import java.util.*;


public class Exam_03 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		Set<Sawon> set=new HashSet<Sawon>();
		int cnt=0;
		while(true) {
			System.out.print("사원등록 :");
			String tmp=s.nextLine();
			String[] tm=tmp.split(",");
			if(tm[0].equals("9999")) {
				break;
			}
			/*
			if(set.contains(o))
			if(set.isEmpty()==false) {
				boolean b=new Sawon(Integer.parseInt(tm[0]),tm[1],Integer.parseInt(tm[2])));
				if(b==false) {
					System.out.println("중복");
					continue;
				}
				*/
			Sawon aa=new Sawon(Integer.parseInt(tm[0]),tm[1],Integer.parseInt(tm[2]));
			if(set.contains(aa)) {
				System.out.println("중복");
				continue;	
			}
			set.add(aa);
			cnt++;
		}
		
		
		List<Sawon> list=new ArrayList<Sawon>(set);
		System.out.println("**사원목록**");
		System.out.println("사원번호\t이름\t나이");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

		Collections.sort(list);
		System.out.println("**사원 번호순**");
		System.out.println("사원번호\t이름\t나이");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
