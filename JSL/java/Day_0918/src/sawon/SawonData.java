package sawon;

public class SawonData {
	//static int n=0;
	static int count=0;
	Sawon sw=new Sawon();
	static Sawon[] part=new Sawon[100];
	static Sawon[] sawon=new Sawon[100];
	
	
	public void sawonPrint() {
		boolean b=true;
		int y=0;
		for(int x=0;x<count;x++) {
			if(x<count-1) {
				y=x+1;
			}
			if(y!=0) {
				if(b) {
					System.out.print(part[x].getPart()+"\t");
					if(part[x].getPart().equals(part[y].getPart())) {
						b=false;
					}
				}else {
					System.out.print(" "+"\t");
					if(!part[x].getPart().equals(part[y].getPart())) {
						b=true;
					}
				}
					
			}
			
			System.out.print(sawon[x].getWokerNum()+"\t");
			System.out.print(sawon[x].getWorkerName()+"\t");
			System.out.print(sawon[x].getPay()+"\t");
			System.out.println();
		}
	}
}
