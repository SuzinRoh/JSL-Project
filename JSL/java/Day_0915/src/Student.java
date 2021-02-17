
public class Student {
	int bun;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	String by;
	
	Student(){}//디폴트 생성자
	Student(int bun, String name, int kor,int eng,int mat){
		this.bun=bun;
		this.name=name;
		this.kor=kor;
		this.mat=mat;
		totAve();
		by();
	}
	void totAve() {
		tot=kor+eng+mat;
		ave=tot/3.;
	}
	void by() {
		by="가";

		if(ave>=90) {
			by="수";
		}else if(ave>=80) {
			by="우";
		}else if(ave>=70) {
			by="미";
		}else if(ave>=60) {
			by="양";
		}else {
			by="가";
		}
	}
	public void stuPrint() {
		System.out.print(bun+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+ave+"\t"+by);
	}
	
}
