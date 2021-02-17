package test02;
/* 키보드로 사원아이디 , 이름 나이를 입력받아 사원객채를 생성
 * set 에 저장 후 출력
 * 
 * 입력형식 
 * 사원등록 :aaa,김사원,30
 * 
 * 2출력형식
 * 아이디 이름 나이
 * 
 * 3처리조건 
 * 동일한 사원아이디 = "중복된 아이디 입니다" 재입력
 * 사원아이디가 end(대소문자구분업음) 면 전체사원 출력 후 종료 
 * 
 */
import java.util.*;
class Sawon{
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private int age;
	
	Sawon() {}
	Sawon(String id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sawon) {
			Sawon s=(Sawon)obj;
			return s.id.equals(id);
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
	
		return id.hashCode();
	}
}
public class Exam_08 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		Set<Sawon> sSet= new HashSet<Sawon>();
		Sawon sawon=new Sawon();
		
		
		//int cnt=0;
		
		while(true) {
			String tmp=s.nextLine();
			
			StringTokenizer st=new StringTokenizer(tmp,",");
			String id=st.nextToken();
			if (id.equalsIgnoreCase("end")) {
				break;
			}
			if(sSet!=null) {
				System.out.println("1");
				
			}
			String name=st.nextToken();
			int age=Integer.parseInt(st.nextToken());
			
			sawon=new Sawon(id,name,age);
			sSet.add(sawon);
			
			boolean b=sSet.add(sawon);
			
			
		
		
			
		}
		System.out.println("아이디\t이름\t나이");
		Iterator iter = sSet.iterator();
		while(iter.hasNext())
			System.out.println(iter.next()+" ");
	}

}
