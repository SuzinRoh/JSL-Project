import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

	public static void main(String[] args) {
		AccountDAO dao =AccountDAO.getInstance();
		//dao.createTable();
		
		AccountVO vo=new AccountVO();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		System.out.println("일자,카테고리,내용,수입금액,지출금액");
		String[] tmp;
		
		try {
			tmp = br.readLine().split(",");

			vo.setIndate(tmp[0]);
			if(tmp[0].equals("end"))break;
			vo.setKategorie(tmp[1]);
			vo.setContents(tmp[2]);
			vo.setIncome(Integer.parseInt(tmp[3]));
			vo.setExpenditure(Integer.parseInt(tmp[4]));
			
			dao.insertData(vo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
		}
	}

	

}
