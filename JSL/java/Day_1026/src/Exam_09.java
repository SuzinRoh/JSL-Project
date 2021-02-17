import java.io.*;
public class Exam_09 {

	public static void main(String[] args) throws Exception{
		File f =new File("E:\\abc.txt");
		FileReader fr =new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String str="";
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
		br.close();
	}

}
