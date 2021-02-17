import java.text.DecimalFormat;

public class Exam_01 {
	public static void main(String[] args) {
		int a =1;
		DecimalFormat df =new DecimalFormat("£Ü#,###.##");
		String s =df.format(a);
		System.out.print(s);
		try {
			Number ss =df.parse(s);
			System.out.println(ss);
		}catch(Exception e) {}
		
	}
}
