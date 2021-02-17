/*
 * 키보드로 금액을 입력 화폐단위별 매수 계산
 */
public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pay=178958;
		int money=50000;
		boolean bool=true;//== int bool=1;
		for(int x=1; x<=10; x++) {
			System.out.print(money+":");
			int mok=pay/money;
			System.out.print(mok+"\n");
			pay=pay%money;
			if(bool) {
				money= money/5;
				bool=false;
			}else {
				money= money/2;
				bool=true;
			}
		}
	}

}
