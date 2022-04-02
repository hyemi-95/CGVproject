package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.customer.action.ActionForward;
import net.movie.db.movieListBean;
import net.movie.db.movieDAO;


public class MovieReserveInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		movieDAO mdao = new movieDAO(); // DAO 쿼리문을 날릴 객체 생성
		movieListBean bean = new movieListBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		
		
		
		

		
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		
		System.out.println(no);
		bean = mdao.getOneMovie(no);
		
		if(bean==null){
			System.out.println("데이터가 널이에요");
		return null;
	}
		System.out.println("데이터가 잘 넘어옴");
		request.setAttribute("bean",bean);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
   		forward.setPath("./MovieReserveInfo.jsp");
   		return forward;
		
		
	}

	
	
}




//	
//BoardDAO boarddao=new BoardDAO();
//	BoardBean boarddata=new BoardBean();
//	
//int num=Integer.parseInt(request.getParameter("num"));
//boarddao.setReadCountUpdate(num);
//	boarddata=boarddao.getDetail(num);
//	
//	if(boarddata==null){
//		System.out.println("�󼼺��� ����");
//		return null;
//	}
//	System.out.println("�󼼺��� ����");
//	
//	request.setAttribute("boarddata", boarddata);
//	ActionForward forward = new ActionForward();
//	forward.setRedirect(false);
//	forward.setPath("./board/qna_board_view.jsp");
//	return forward;
//
//}




//int no = Integer.parseInt(request.getParameter("no"));
//
////데이터베이스에 접근
//movieDAO mdao = new movieDAO();
////영화 하나에 대한 정보를 얻어옴
//movieListBean bean = mdao.getOneMovie(no);
//
//
//
//String category = bean.getCategory();
//String temp="";
//
//if(category.equals("action"))temp="액션";
//else if(category.equals("horror"))temp="호러";
//else if(category.equals("animation"))temp="애니메이션";
//else if(category.equals("thriller"))temp="스릴러";
//