package survlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exDay_1229.model.GuestDTO;
import exDay_1229.model.guestDAO;
import util.PageIndex;

@WebServlet("/guest_list")//.뒤는 지맘대로 해도댐
public class guestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public guestListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//검색 + 페이지 처리 추가
		
		guestDAO dao = guestDAO.getInstance();
		String s_query ="" , search="", key="";
		
		int totcount = 0; //게시글 총수 계산용 
		
		//검색이 있을 경우 검색판단
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%' ";
			totcount =dao.guestCount(s_query);
			
		} else {
			totcount =dao.guestCount();
		}
		
		int nowpage =1;//현재페이지
		int maxlist =10;//페이지당 글수 초기화
		int totpage =1;//총 페이지 초기화
		
		//총페이지수 계산 
		
		if(totcount % maxlist == 0) {
			totpage =totcount/maxlist;
		} else {
			totpage =(totcount/maxlist)+1;
		}
		
		//페이지 번호가 입력될 경우
		if(request.getParameter("page") !=null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		
		
		//페이지 별 출력될 시작, 끝번호 찾기
		int startpage = (nowpage-1) * maxlist+1;
		int endpage = nowpage * maxlist;
		//중간중간 빠진 숫자 대비
		int listcount = totcount-((nowpage-1)*maxlist);
		//다시확인 listcount
		
		List<GuestDTO> list = null;
		
		if(key.equals("")) {//검색이안들어올떄
			list = dao.guestList(startpage , endpage);
		} else {//검색이들어올때
			list = dao.guestList(s_query,startpage,endpage);
		}
		
		//페이지 번호 출력
		String pageSkip ="";
		if(key.equals("")) {// 서블릿이름
			pageSkip = PageIndex.pageList(nowpage, totpage, "guest_list", "");
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "guest_list", search , key);
		}
		
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_list.jsp");
		dispatcher.forward(request, response);
	}
	//검색은 포스트 다 위로올림
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
