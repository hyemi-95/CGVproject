package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.customer.action.ActionForward;
import net.customer.db.CustomerBean;
import net.customer.db.CustomerDAO;

public class CustomerJoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomerDAO cdao = new CustomerDAO(); // DAO 쿼리문을 날릴 객체 생성 
		CustomerBean cbean = new CustomerBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		ActionForward forward = new ActionForward(); // actionforward의 객체를 생성하면 안의 변수를 사용가능함.
		boolean result = false;
		
		
		
		// 빈즈 클래스에 데이터 삽입
		try {
			
			
			cbean.setId(request.getParameter("id"));
			cbean.setPass1(request.getParameter("pass1"));
			cbean.setPass2(request.getParameter("pass2"));
			cbean.setName(request.getParameter("name"));
			cbean.setEmail(request.getParameter("email"));	
			cbean.setPhone(request.getParameter("phone"));
		
			
			
			
			// 멤버 DAO의 Insert 함수에 cbean의 값을 넣어라 (beans 클래스)
			result = cdao.insertCustomer(cbean);
			
			if(result == false) {
				System.out.println("회원등록 실패");
				return null;
			}
			System.out.println("회원 등록 완료");
			
			forward.setRedirect(true);
			forward.setPath("./CustomerLoginForm.cu");
			return forward;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}