package test02;
import java.util.*;
/*키보드로 번호 이름 점수 입력받아 학생객체 (번호이름) 생성 treemap저장
 * 
 * 1,홍길동,95
 * 
 * 입력 0 >종료
 * 
 * 동일번호 입력시 이미등록된번호입니다
 * 
 * 
 * 출력 번호 ㄴ이름 점수
 * 
 * 총점 편균
 * 
 */
class Student implements Comparable<Student>{
	private int number;
	private String name;
	
	Student(){}
	Student(int number,String name){
		this.number=number;
		this.name=name;
	}
	
	@Override
	public String toString() {
		
		return number+"\t"+name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student ) {
			Student s=(Student)obj;
			return number==number;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return number;
	}
	@Override
	public int compareTo(Student o) {
		return Integer.compare(number, o.number);
	}
}
public class Exam_04 {

	public static void main(String[] args) {
			TreeMap<Student, Integer> map = new TreeMap<Student, Integer>();
			
			Scanner s=new Scanner(System.in);
			
			while(true) {
				System.out.print("번호,이름,점수 입력 :");
				
				String tmp=s.nextLine();
				StringTokenizer st=new StringTokenizer(tmp,",");
				
				int number = Integer.parseInt(st.nextToken());
				if (number==0)
					break;
				
				String name = st.nextToken();
				Integer score = Integer.parseInt(st.nextToken());
				
				Student stu=new Student(number,name);
				if(!map.isEmpty()) {
					if(map.containsKey(stu)) {
						System.out.println("이미 입력된 번호입니다.");
						continue;
					}
				}
				map.put(stu,score);
			}
			
			System.out.println("번호\t이름\t점수");
			int tot=0;
			Set<Student> set=map.keySet();
			for(Student st : set) {
				System.out.println(st+"\t"+map.get(st));
				tot+=map.get(st);
			}
			System.out.println("총점 :"+tot+" 평균 :"+(tot/map.size()));
	}

}
