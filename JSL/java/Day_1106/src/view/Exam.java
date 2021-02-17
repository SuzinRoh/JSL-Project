package view;

import java.util.List;

import dao.EmpDAO;
import domain.EmpVO;

public class Exam {

	public static void main(String[] args) {

		EmpDAO dao =EmpDAO.getInstance();
		
		
		System.out.println("01-----------------------------------------------");
		EmpVO vo = dao.exam_01();
		System.out.println("ENAME\tDNO\tDNAME");
		System.out.println(vo.getEname()+"\t"+vo.getDno()+"\t"+vo.getDname());
		
		System.out.println("02-----------------------------------------------");
		List<EmpVO> list = dao.exam_02();
		System.out.println("ENAME\tDNAME\tLOC");
		for(EmpVO tmp : list){
			System.out.println(tmp.getEname()+"\t"+tmp.getDname()+"\t"+tmp.getLoc());
		}
		

		System.out.println("03-----------------------------------------------");
		list = dao.exam_03();
		System.out.println("DNO\tJOB\tLOC");
		for(EmpVO tmp : list){
			System.out.println(tmp.getDno()+"\t"+tmp.getJob()+"\t"+tmp.getLoc());
		}
		
		System.out.println("04-----------------------------------------------");
		list = dao.exam_04();
		System.out.println("ENAME\tDNAME\tLOC");
		for(EmpVO tmp : list){
			System.out.println(tmp.getEname()+"\t"+tmp.getDname()+"\t"+tmp.getLoc());
		}
		
		System.out.println("05-----------------------------------------------");
		list = dao.exam_05();
		System.out.println("ENAME\tDNAME");
		for(EmpVO tmp : list){
			System.out.println(tmp.getEname()+"\t"+tmp.getDname());
		}
	}

}
