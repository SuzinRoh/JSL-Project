package test01;
/* 키보드 입력 
 * 입력 : id,name,age(user01,길동,25)
 * 
 * 출력
 * 아이디 이름 나이
 * user01 길동 25
 *  .       . .
 *  처리조건 
 *  1.id 중복시 "이미사용중인아이디"
 *  2.id 가 end 이면 전체자료 출력하고 종료
 */
import java.util.*;
class Mem{
	private String id;
	private String name;
	private int age;
	
	Mem(){}
	Mem(String id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+age;
	}
}

public class Exam_05 {
	public static void main(String[] args) throws Exception{
		List<Mem> list =new ArrayList<Mem>();
		Scanner sc=new Scanner(System.in);
		
		int cnt=0;
		
		while(true) {
			System.out.print("아이디,이름,나이 :");
			String tmp=sc.nextLine();
			StringTokenizer tn=new StringTokenizer(tmp,",");
			
			String id=tn.nextToken();
			if(id.equals("end"))
				break;
			
			if(list.isEmpty()!=true) {
				Mem tm=list.get(cnt-1);
				if(tm.getId().equals(id)) {
					System.out.println("중복된 아이디 입니다");
					break;
				}
				Object ob=id;
				if(list.contains(id)) {
					System.out.println("중복");
				}
			}
			String name=tn.nextToken();
			int age=Integer.parseInt(tn.nextToken());
			list.add(new Mem(id,name,age));
			
			//System.out.println(list.get(cnt));
			
			cnt++;
		}
		System.out.println("아이디\t이름\t나이");
		for(int i=0;i<list.size();i++) {//==Mem m:mList
			System.out.println(list.get(i));
		}
	
	}
}
