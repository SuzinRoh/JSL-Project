import java.util.Scanner;

class Tv{
	String inch;//크기25" , 65"
	boolean power;// on / off
	int channel;//현재채널번호
	
	void power() {
		power = !power;
		
	}
	void channelUp() {
		if(power) {
			channel++;
			if(channel>999) {
				channel=1;
			}
		}else {
			System.out.println("tv전원을 켜세요");
		}
	}
	void channelDown() {
		if(power) {
			channel--;
			if(channel<1) {
				channel=999;
			}
		}else {
			System.out.println("tv전원을 켜세요");
		}
	}
}
public class Exam_02 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
				int onoff=0;
				Tv tv1 =new Tv();
				System.out.println("tv 전원상태 :"+ tv1.power);
				if(!tv1.power) {
					System.out.print("전원을 켜시겠습니까 y/n :");
					
					String answer=sc.next();
					if(answer.equals("y")) {
						onoff=1;
					}else {
						onoff=0;
					}
					if(onoff==1) {
						tv1.power();
					}
				}
				if(tv1.power) {
					tv1.channelUp();
					System.out.println("tv 채널상태 :"+ tv1.channel);
					tv1.channelDown();
					tv1.channelDown();
					System.out.println("tv 채널상태 :"+ tv1.channel);
				}
				/*
				*/
	}

}
