abstract class Student{
	int num;
	String name;
	int[] score;
	int tot;
	double ave;
	public Student(int num,String name, int[] score) {
		this.num=num;
		this.name=name;
		this.score=score;
	}
	public void print() {
		System.out.println("��ȣ\t�̸�\t����\t���");
		System.out.println(num+"\t"+name+"\t"+tot+"\t"+ave);
	}
	public abstract void account();//���� ��� ���
	public abstract void scoreMax();//�ּ����� : xxx �ִ� ���� xxx
	public abstract void scoreSelectionSort();//���� ��������
	public abstract void scoreBubbleSort();//���� (��������)
}
class StudentExam extends Student{
	public StudentExam(int num,String name, int[] score) {
		super(num,name,score);
	}
	@Override
	public void account() {
		int tot=0;
		for(int x=0;x<score.length;x++) {
			tot+=score[x];
		}
		super.tot=tot;
		super.ave=tot/score.length;
		
	};
	@Override
	public void scoreMax() {
		int max=-99
		   ,min=999,
		   cnt=0;
		while(cnt<score.length) {
			if(max<score[cnt]) {
				max=score[cnt];
			}
			if(min>score[cnt]) {
				min=score[cnt];
			}
			cnt++;
		}
		
		System.out.println("�ִ����� :"+max+" �ּ����� :"+min);
	};
	@Override
	public void scoreSelectionSort() {
		
		for(int x=0;x<score.length-1;x++) {
			for(int y=x+1;y<score.length;y++) {
				if(score[x]>score[y]) {
					int tmp=score[x];
					score[x]=score[y];
					score[y]=tmp;
				}
			}
			
		}
		System.out.print("�������� :");
		for(int i=0;i<score.length;i++) {
			System.out.print(score[i]+"\t");
		}
		
	};
	@Override
	public void scoreBubbleSort() {
		int tmp;
		for(int x=0;x<score.length-1;x++) {
			for(int y=0;y<score.length-1-x;y++) {
				if(score[y]<score[y+1]) {
					tmp=score[y];
					score[y]=score[y+1];
					score[y+1]=tmp;
				}
			}
		}
		//super.score=score;
		System.out.print("�������� :");
		for(int i=0;i<score.length;i++) {
			System.out.print(score[i]+"\t");
		}
	};//���� (��������)
}

public class Exam_04 {

	public static void main(String[] args) {
		int num=1101;
		String name="java";
		int[] score= {90,66,79,89,45,67,79,94,88,67,90,78};
		StudentExam stu=new StudentExam(num,name,score);
		stu.account();
		stu.print();
		stu.scoreMax();
		stu.scoreSelectionSort();
		System.out.println();
		stu.scoreBubbleSort();
	}

}
