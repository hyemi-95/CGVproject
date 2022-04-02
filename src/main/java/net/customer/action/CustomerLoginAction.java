package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.customer.db.CustomerBean;
import net.customer.db.CustomerDAO;
import net.customer.action.ActionForward;
import net.customer.db.CustomerBean;
import net.customer.db.CustomerDAO;

public class CustomerLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
	
		// 로그인 액션은 빈즈에서 끌어올 값은 없을거라고 판단. 
		CustomerDAO cdao = new CustomerDAO(); // DAO 쿼리문을 날릴 객체 생성
		CustomerBean cbean = new CustomerBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		ActionForward forward = new ActionForward(); // actionforward의 객체를 생성하면 안의 변수를 사용가능함.
		
		boolean result = false;
		try {
			
		String id = request.getParameter("id");
			session.setAttribute(id, id);
		
		String pass1 = request.getParameter("pass1");

		cbean.setId(id);
		cbean.setPass1(pass1);
			
			result = cdao.CustomerLogin(cbean);
			
			
			if(result == false) {
				System.out.println("Action : 로그인 실패");
				forward.setRedirect(false);
				forward.setPath("./CustomerLoginForm.jsp");
				return forward;
			}
			System.out.println("Action : 로그인 성공");
			session.setAttribute("id", cbean.getId());
//			String user = (String)session.getAttribute("id");
			
			
			// admin인지 일반 사용자인지 확인 게시판으로 이동...
 			forward.setRedirect(true);
			forward.setPath("./LoginMain.cu");
			return forward;
			
			
		}catch(Exception e) {
			System.out.println("데이터 등록 실패");
			e.printStackTrace();
		}
		return null;
	}

}

