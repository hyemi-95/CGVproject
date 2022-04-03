package net.customer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.db.movieDAO;
import net.movie.db.movieListBean;

public class MovieAllListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		movieDAO mdao = new movieDAO(); // DAO 쿼리문을 날릴 객체 생성
		movieListBean bean = new movieListBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		List<movieListBean> list = new ArrayList<movieListBean>();
		
		
	
		
	
//		bean = (movieListBean) mdao.getCategoryMovie(category);
		list = mdao.getAllMovie();
		if(bean==null){
			System.out.println("bean값이 null");
		return null;
	}
		System.out.println("bean값 넘어옴");
		request.setAttribute("list",list);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
   		forward.setPath("./MovieAllList.jsp");
   		return forward;
		
		
	}

	
	
}
