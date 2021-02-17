package sawon;

public class Sawon {
	private String part;
	private int workerNum;
	private String workerName;
	private int pay;
	
	public Sawon(){}
	public Sawon(String part){
		this.part=part;
		
	}
	public Sawon(int wokerNum,String workerName,int pay){
		this.workerNum=wokerNum;
		this.workerName=workerName;
		this.pay=pay;
	}
	
	
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public int getWokerNum() {
		return workerNum;
	}
	public void setWokerNum(int wokerNum) {
		this.workerNum = wokerNum;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
}
