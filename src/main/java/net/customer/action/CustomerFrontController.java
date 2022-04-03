package net.customer.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class MemberFrontController
 */

public class CustomerFrontController extends HttpServlet implements Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String RequestURI=request.getRequestURI();// url 주소 가 뜨고
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		// 로그인 양식 화면으로 보내주기
		if(command.equals("/CustomerLoginForm.cu")) { 
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./CustomerLoginForm.jsp");
		}
		
		else if(command.equals("/LoginMain.cu")) { 
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./LoginMain.jsp");
		}
		
		else if(command.equals("/Main.cu")) { 
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./Main.jsp");
		}
		else if(command.equals("/MovieChartAction.cu")) { 
			action = new movieChartAction(); System.out.println("무비차트액션탔다");
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/MovieChart.cu")) { System.out.println("무비차트페이지 탐");
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./MovieChart.jsp");
		}
		else if(command.equals("/OptionSelect.cu")) { 
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./OptionSelect.jsp");
		}//관리자 로그인시 관리자페이지 넘어가는 ..
		else if(command.equals("/Admin.cu")) { 
			forward = new ActionForward(); System.out.println("관리자페이지 탔다");
			forward.setRedirect(false);
			forward.setPath("./Admin.jsp");
		}//관리자페이지에서 무비차트업로드
		else if(command.equals("/movieUpload.cu")) { 
			action = new movieUploadAction(); System.out.println("무비차트업로드 탔다");
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//관리자페이지에서 스토어업로드
		else if(command.equals("/storeUpload.cu")) { 
			action = new storeUploadAction(); System.out.println("스토어업로드 탔다");
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		 //로그인 클릭시
		else if(command.equals("/CustomerLoginAction.cu")) {
			action = new CustomerLoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		// 회원가입 폼
		else if(command.equals("/CustomerJoinForm.cu")) {
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./CustomerJoinForm.jsp");
		}
//		
		
		
		// 회원가입 버튼 누를 시
		 if(command.equals("/CustomerJoinAction.cu")) {
			action = new CustomerJoinAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		 else if(command.equals("/MovieReserveInfo.cu")) {
				action = new MovieReserveInfoAction();
				try {
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		 
		 else if(command.equals("/MovieCategoryList.cu")) {
				action = new CategoryListAction();
				try {
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
		 else if(command.equals("/MovieAllList.cu")) {
				action = new MovieAllListAction();
				try {
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		 
		 
//		else if(command.equals("/member_list.me")) {
//			action = new MemberListAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/member_detail.me")) {
//			action = new MemberDetailAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		else if(command.equals("/member_delete.me")) {
//			action = new MemberDeleteAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
	
		
		
		if(forward.isRedirect()){
			response.sendRedirect(forward.getPath()); 
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response); 
			System.out.println(forward.getPath());
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
