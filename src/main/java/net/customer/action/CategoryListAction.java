package net.customer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.customer.action.ActionForward;
import net.movie.db.movieDAO;
import net.movie.db.movieListBean;

public class CategoryListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		movieDAO mdao = new movieDAO(); // DAO 쿼리문을 날릴 객체 생성
		movieListBean bean = new movieListBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		List<movieListBean> list = new ArrayList();
		 
		
		
		
		String category = request.getParameter("category");
		
		
		System.out.println(category);
//		bean = (movieListBean) mdao.getCategoryMovie(category);
		list = mdao.getCategoryMovie(category);
		if(bean==null){
			System.out.println("bean값이 null");
		return null;
	}
		System.out.println("bean값 넘어옴");
		request.setAttribute("bean",bean);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
   		forward.setPath("./MovieCategoryList.jsp");
   		return forward;
		
		
	}

	
	
}
