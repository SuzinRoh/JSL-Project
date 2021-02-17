
abstract class Hak {
	int num;
	String name;
	int grade;
	int[] grade2;
	int tot;
	double avg;
	Hak(){}
	Hak(int num,String name,int grade){
		this.num=num;
		this.name=name;
		this.grade=grade;	
	}
	Hak(int num,String name,int[] grade2){
		this.num=num;
		this.name=name;
		this.grade2=grade2;	
	}
	public void print() {
		System.out.println("번호\t이름\t점수");
		System.out.println(num+"\t"+name+"\t"+grade);
	};
}
