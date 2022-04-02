package net.customer.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.*;

import net.customer.db.CustomerBean;

import net.movie.db.movieListBean;

public class CustomerDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	
	public CustomerDAO() {
		// 커넥션 풀을 DAO 생성자에 삽입
		try{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		conn = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	// 회원가입 회원 등록
	public boolean insertCustomer(CustomerBean cbean) {
		
	
		int result=0;

		try {

			
			//쿼리 준비
		String sql="insert into customer values (?,?,?,?,?,?)";
		
			//쿼리 실행할 객체 선언
			pstmt = conn.prepareStatement(sql);
			//  ?물음표에 대입
			pstmt.setString(1, cbean.getId());
			pstmt.setString(2, cbean.getPass1());
			pstmt.setString(3, cbean.getPass2());
			pstmt.setString(4, cbean.getName());
			pstmt.setString(5, cbean.getEmail());
			pstmt.setString(6, cbean.getPhone());
			//쿼리실행
			
			
			result = pstmt.executeUpdate();
			if(result==0) { 
				return false;
			}
			return true;
			
		}catch(Exception e) {
			System.out.println("DAO : insertCustomer 에러 : " + e);
			e.printStackTrace();
			
		}
		return false;
	
}
	
//모든 회원의 정보를 리턴하는 메소드 작성
	
	public List<CustomerBean> getAllCustomer(){
		
		//리턴타입 선언
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		
		
		try {
			
			//쿼리준비 
			String sql = "SELECT * FROM CUSTOMER";
			//쿼리 실행하는 객체 준비
			pstmt = conn.prepareStatement(sql);
			//쿼리 실행 후 결과 리턴
			rs = pstmt.executeQuery();
			//반복문을 돌면서 회원 정보를 저장해준다
			
			
			while(rs.next()) {
				
				CustomerBean cbean = new CustomerBean();
				cbean.setId(rs.getString("1"));
				cbean.setPass1(rs.getString("2"));
				cbean.setPass2(rs.getString("3"));
				cbean.setName(rs.getString("4"));
				cbean.setEmail(rs.getString("5"));
				cbean.setPhone(rs.getString("6"));
				//	리스트에 빈클래스를 저장
				
				list.add(cbean);
				
			}
		return list;
		}catch(Exception e) {
			System.out.println("DAO : getAllCustomer 에러 : " + e);
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		
		
		return null;
	}

	public boolean CustomerLogin(CustomerBean cbean) {
		String sql = "select id, pass1 from customer where id =?";
//		member.getId();
//		member.getPw();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cbean.getId());
			rs = pstmt.executeQuery();
//			System.out.println(cbean.getId());
//			System.out.println(cbean.getPass1());
			
			while(rs.next()) {
				if(rs.getString("pass1").equals(cbean.getPass1())) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println("DAO : CustomerLogin 에러 : " + e);
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return false;
	}
		
		
		
		
		
		
		
		
		
		
		
}
	
	
	
	


	
	
		


