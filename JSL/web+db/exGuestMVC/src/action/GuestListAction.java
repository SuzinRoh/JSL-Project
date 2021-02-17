package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestDAO;
import model.GuestVO;
import util.PageIndex;

public class GuestListAction implements Action {

	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		   
		   System.out.print("list test");
		   
		   GuestDAO dao = GuestDAO.getInstance();
		   String searchQuery = "" , search = "", key = "" ;
		   int totcount = 0;
		   
		   if(request.getParameter("key") != null) {
			   key = request.getParameter("key");
			   search = request.getParameter("search");
			   searchQuery = search +" like '%"+ key +"%' ";
			   totcount =dao.GuestSearchCount(searchQuery);
		   } else {
			   totcount = dao.GuestListCount();
		   }
		   
		  int nowpage = 1 ;
		  int maxlist = 10;
		  int totpage =1;
		  
		  if(totcount % maxlist ==0 ) {
			  totpage =totcount/maxlist;
		  } else {
			  totpage = (totcount/maxlist)+1;
		  }
		  
		  if(request.getParameter("page") != null ) {
			  nowpage =Integer.parseInt(request.getParameter("page"));
		  }
		  
		  int startpage = (nowpage-1) * maxlist +1;
		  int endpage = nowpage * maxlist;
		  int listcount = totcount-((nowpage-1)*maxlist);
		  
		   
		   List<GuestVO> list = null;
		   if(key.equals("")) {
			   list =dao.GuestSelect(startpage, endpage);
		   } else {
			   list =dao.GuestSearch(searchQuery, startpage, endpage);
		   }
		   
		   String pageSkip = "";
		   if(key.equals("")) {
			   pageSkip = PageIndex.pageList(nowpage, totpage, "Guest?cmd=guest_list", "");
		   } else {
			   pageSkip = PageIndex.pageListHan(nowpage, totpage, "Guest?cmd=guest_list" , search, key);
		   }
		   
		   	request.setAttribute("page", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("totcount", totcount);
			request.setAttribute("listcount", listcount);
			request.setAttribute("pageSkip", pageSkip);
			request.setAttribute("page", nowpage);
			request.setAttribute("list", list);
			request.setAttribute("search", search);
			request.setAttribute("key", key);
		   
		   RequestDispatcher dispatcher =request.getRequestDispatcher("Guest/guest_list.jsp");
		   dispatcher.forward(request, response);
	   }

	}
