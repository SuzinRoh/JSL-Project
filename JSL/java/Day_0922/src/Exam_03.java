abstract class D{
	int m,n;
	public D(int m,int n) {
		this.m=m;
		this.n=n;
	}
	public void print() {
		System.out.println("m="+m+"\tn="+n);
		
	}
	
	public abstract int add();
	public abstract void mul();
}
class DD extends D{
	
	
	public DD(int m, int n) {
		super(m, n);
	}
	@Override
	public int add() {
		int s=0;
		
		for(int x=m;x<=n;x++) {
			s+=x;
		}/*
		while(m<=n) {
			s+=m;
			m++;
		}*/
		return s;
	}
	@Override
	public void mul() {
		
		int s=1;
		
		for(int x=m;x<=n;x++) {
			s*=x;
		}/*
		while(m<=n) {
			s*=m;
			m++;
		}*/
		System.out.println(s);
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		DD dd =new DD(1,5);
		//m=1,n=5
		int s = dd.add();
		System.out.println("s = "+s);//s=15
		dd.mul();//s=120
	}

}
