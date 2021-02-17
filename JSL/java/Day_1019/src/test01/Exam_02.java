package test01;
import java.util.*;
class Student{
	private int sno;
	private String sname;
	
	public Student() {}
	public Student(int sno,String sname) {
		this.sno=sno;
		this.sname=sname;
	}
	@Override
	public String toString() {
		return sno+"\t"+sname;
	}
	@Override
	public  boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s=(Student)obj;
			return sno==sno && s.sname.equals(sname);
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return sno;
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		Map<Student,Integer> sMap = new HashMap<Student,Integer>();
		sMap.put(new Student(1,"홍길동"), 100);
		sMap.put(new Student(5,"김길동"), 88);
		sMap.put(new Student(3,"박길동"), 70);
		sMap.put(new Student(2,"장길동"), 90);
		sMap.put(new Student(9,"오길동"), 95);
		sMap.put(new Student(7,"황길동"), 70);
		sMap.put(new Student(1,"홍길동"), 100);
		//키보드로 번호 , 이름을 입력 Student 객체를 생성
		//map 에 저장된 객체를 찾아서 출력 찾는 객체가 없을경우 "등록된 자료 없음"
		Scanner s= new Scanner (System.in);
		
		while(true) {
			System.out.print("찾는 사람의 번호,이름 :");
			String tmp=s.nextLine().trim();
			
			StringTokenizer st=new StringTokenizer(tmp,",");
			int num= Integer.parseInt(st.nextToken());
			String name= st.nextToken();
			
			Student tmpStu =new Student(num,name);

			if(sMap.containsKey(tmpStu)) {
				for(Object o: sMap.keySet()) { 
					if(sMap.get(o).equals(sMap.get(tmpStu))) {
							System.out.print(o+"\t");
							System.out.print(sMap.get(o));
							System.out.println();
					} 
				} 
				break;
			}else {
				System.out.println("데이터 없음");
				continue;
			}
			
		}
		System.out.println();
		//2. 점수 합계를 구하여 출력
		
		int tot=0;
		
		Iterator it = sMap.keySet().iterator();
		Collection Values = sMap.values();
		
		it=Values.iterator();
		
        while (it.hasNext()) {
            Integer a =(Integer) it.next();
            tot+=a.intValue();
        }
        System.out.println("총점 :"+tot);
		
		//3. 점수의 최대값, 최소값을 찾아서 출력
        System.out.println("총점 :"+tot);
		System.out.println("평균 :"+(float)tot/sMap.size());
		System.out.println("최고점수 :"+Collections.max(Values));
		System.out.println("최소점수 :"+Collections.min(Values));
	}
}
