
public class HakData extends Hak {
	
	HakData(int num,String name,int grade){
		super(num,name,grade);
	}
	HakData(int num,String name,int[] grade2){
		super(num,name,grade2);
	}
	public void tot() {
		for(int x=0;x<grade2.length;x++) {
			tot+=grade2[x];
		}
		avg=tot/grade2.length;
	}
	@Override
	public void print() {//super
	
		System.out.println("��ȣ\t�̸�\t����\t\t�հ�\t���");
		System.out.println(num+"\t"+name+"\t"+grade+"\t"+tot+"\t"+avg);
	}
	
}
