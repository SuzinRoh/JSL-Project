//tree map
import java.util.*;
public class Exam_01 {

	public static void main(String[] args) {
			TreeMap<Integer, String> score=new TreeMap<Integer,String>();
			score.put(100,"aaa");
			score.put(70,"bbb");
			score.put(60,"ccc");
			score.put(30,"ddd");
			score.put(70,"eee");
			score.put(83,"fff");
			score.put(54,"ggg");
			
			System.out.println(score);
			Map.Entry<Integer, String> entry = null;
			
			entry = score.firstEntry();
			System.out.println("���峷������ :"+entry.getKey()+"-"+entry.getValue());
			entry = score.lastEntry();
			System.out.println("����������� :"+entry.getKey()+"-"+entry.getValue());
			
			entry = score.higherEntry(80);
			System.out.println("80�� ���� ���� :"+entry.getValue());
			entry = score.floorEntry(65);
			System.out.println("70�� �̰ų� �ٷ� �Ʒ� :"+entry.getValue());
			entry = score.ceilingEntry(65);
			System.out.println("65�� �̰ų� �ٷ� �� :"+entry.getValue());
			
			while(!score.isEmpty()) {
				entry = score.pollFirstEntry();
				System.out.print(entry.getKey()+"-"+entry.getValue()+"\t");
				System.out.println("���� ��ü �� :"+score.size());
			}
	}

}
