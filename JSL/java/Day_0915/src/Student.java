
public class Student {
	int bun;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	String by;
	
	Student(){}//����Ʈ ������
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
		by="��";

		if(ave>=90) {
			by="��";
		}else if(ave>=80) {
			by="��";
		}else if(ave>=70) {
			by="��";
		}else if(ave>=60) {
			by="��";
		}else {
			by="��";
		}
	}
	public void stuPrint() {
		System.out.print(bun+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+ave+"\t"+by);
	}
	
}
