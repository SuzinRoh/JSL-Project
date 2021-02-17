
public class Exam_10 {

	public static void main(String[] args) {
		
		Thread  thread = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int x=0;x<5;x++) {
					System.out.println("NO");
					try {
						Thread.sleep(500);
					}catch(Exception e) {}
				}
			}
			
			});
		thread.start();
		for(int x=0;x<5;x++) {
			System.out.println("OK");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}

}
