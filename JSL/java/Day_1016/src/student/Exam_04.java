package student;
import java.io.*;
import java.util.*;
/*studnet.txt 파일 내용
 * 1,aaa,90,80,79
 * 
 * 출력 1 입력받은 순서대로 출력
 * 번호 이름 국어 영어 수학 총점 평균 석차
 * 
 * 입력자료 총수:
 * 중복자료 수:
 * 출력2 석차를 기준으로 오름차순 출력
 * 번호 이름 국어 영어 수학 총점 평균 석차
 * 
 * 처리조건
 * 번호와 이름이 같으면 "중복된 자료입니다"
 * 
 */

class Student implements Comparable<Student>{
	private int bun;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private int rang;
	
	Student() {}
	
	
	Student(int bun,String name,int kor,int eng,int mat,int tot,double avg,int rang){
		this.bun=bun;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		this.tot=tot;
		this.avg=avg;
		this.rang=rang;
	}
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	@Override
	public String toString() {
		return bun+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg+"\t"+rang;
	}
	@Override
	public int compareTo(Student i) {
		if(rang<i.rang) {
			return -1;
		}else if(rang==i.rang) {
			return 0;
		}else {
			return 1;
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s=(Student)obj;
			return bun==bun && s.name.equals(name) ;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return bun;
	}
}
public class Exam_04 {
	public static void print() {
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(new File("//Volumes//sujin//student.txt"));
		Set<Student> sSet =new HashSet<Student>();
		int sameDataTot=0;
		int dataTot=0;
		int rank=1;
		while(sc.hasNextLine()) {
			String tmp=sc.nextLine();
			String[] tmpVar=tmp.split(",");
			
			int tot=Integer.parseInt(tmpVar[2])+
					Integer.parseInt(tmpVar[3])+
					Integer.parseInt(tmpVar[4]);
			
			double avg=Math.round((tot/3)*100)/100.0;
		
			Student st =new Student(Integer.parseInt(tmpVar[0]),
					tmpVar[1],
					Integer.parseInt(tmpVar[2]),
					Integer.parseInt(tmpVar[3]),
					Integer.parseInt(tmpVar[4]),
					tot,avg,rank);
			
			if(sSet.contains(st)) {
				//System.out.println("중복");
				//sSet.remove(st);
				sameDataTot++;
			}else {
				sSet.add(st);
				dataTot++;
			}
			//System.out.println(sSet);
		}
		List<Student> list =new ArrayList(sSet);
		
		for(int i=0;i<list.size();i++) {
			int r=1;
			for(int j=0;j<list.size();j++) {
				if(list.get(i).getAvg()>list.get(j).getAvg()) {
					list.get(i).setRang(r++);
				}
			}
		}
		
		//rank(sSet);
		System.out.println("출력-1 입력받은 순서대로 출력");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("출력-2 석차를 기준으로 오름차순 출력");
	
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("중복된 데이터수 :"+sameDataTot);
		System.out.println(" 데이터수 :"+dataTot);
		
		
	}

}
