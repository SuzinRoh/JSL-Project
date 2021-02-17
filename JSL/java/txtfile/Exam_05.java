package test01;
import java.util.*;
/*  키보드 입력
 *  입력 : id,name,age(user01,홍길동,35)
 *  
 *  출력
 *  아이디      이름    나이
 *  user01 홍길동  35
 *    .      .   .
 *  처리조건
 *  1.id 중복시 "중복된 id 입니다" 경고 출력 후 재입력
 *  2.id가 end 이면 전체자료를 출력하고 종료
 */
class Mem{
	private String id;
	private String name;
	private int age;
	public Mem() {}
	public Mem(String id,String name, int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Mem) {
			Mem m = (Mem)obj;
			return m.id.equals(id);
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+age;
	}
}
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<Mem> mList = new ArrayList<Mem>();
		while(true) {
			System.out.print("입력:");
			String[] str=scn.nextLine().split(",");
			if(str[0].equalsIgnoreCase("end"))
				break;
			Mem m = new Mem(str[0],str[1],Integer.parseInt(str[2]));
			//중복체크
			boolean bool=mList.contains(m);
			if(bool) {
				System.out.println("id 중복");
			}else {
				mList.add(m);
			}
		}
		
		System.out.println("아이디\t이름\t나이");
		for(Mem m : mList) {
			System.out.println(m);
		}
	}

}
