package net.customer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.db.movieDAO;
import net.movie.db.movieListBean;

public class movieChartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		movieDAO mdao = new movieDAO();
		ActionForward forward= new ActionForward();
		// LIST를 이용하여 movie 를 저장
		List<movieListBean> list = new ArrayList<movieListBean>();
		
		try{
			list= mdao.getSelectmovie();
			System.out.println("다오들어갔다옴");
			
			request.setAttribute("list", list);	
			
			System.out.println(request.getAttribute("list"));
			
			forward.setRedirect(false);
	   		forward.setPath("/MovieChart.cu");
	   		return forward; 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("무비차트 데이터 불러오기 실패");
		return null;
	}

}
