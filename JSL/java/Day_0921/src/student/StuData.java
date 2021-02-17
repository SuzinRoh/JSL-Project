package student;

public class StuData extends Student{
	StuData(){}
	int kor;
	int eng;
	int mat;
	int tot;
	double avg;
	
	StuData(int bun, String name,int age,int kor,int eng,int mat,int tot,double avg){
		super.bun=bun;
		super.name=name;
		super.age=age;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		this.tot=tot;
		this.avg=avg;
	}
	public void studentPrint() {
		super.studentPrint();
		System.out.print(kor+"\t");
		System.out.print(eng+"\t");
		System.out.print(mat+"\t");
		System.out.print(tot+"\t");
		System.out.print(avg+"\n");
	}
}
