package net.movie.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import net.movie.db.movieListBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class movieDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public movieDAO() {
		// 커넥션 풀을 DAO 생성자에 삽입
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public List<movieListBean> getSelectmovie() {

		String sql = "select * from movie order by no";

		List<movieListBean> list = new ArrayList<movieListBean>();

		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("여기는다오");
			while (rs.next()) {

				movieListBean bean = new movieListBean();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setDirector(rs.getString("director"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

				list.add(bean);
				System.out.println(list);
			}

			return list;

		} catch (Exception ex) {
			System.out.println("getMovieList ??? : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}

		}

		return list;
	}

	// 카테고리별 영화 리스트를 저장하는 메소드
	public List<movieListBean> getCategoryMovie(String cate) {

		List<movieListBean> list = new ArrayList<movieListBean>();
		// 데이터를 저장할 빈클래스 선언
		movieListBean bean = null;

		try {
			pstmt = con.prepareStatement("select * from movie where category = ?order by no");

			// ? 물음표값
			pstmt.setString(1, cate);

			// 결과를 리턴
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 데이터를 저장

			while (rs.next()) {
				// 데이터를 저장할 빈클래스 생성
				bean = new movieListBean();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setDirector(rs.getString("director"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

				list.add(bean);

			}
			rs.close();
		} catch (Exception ex) {
			System.out.println("getCategoryMovie 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return list;
	}

	// 모든 무비을 검색하는 메소드
	public List<movieListBean> getAllMovie() {

		List<movieListBean> list = new ArrayList<movieListBean>();
		// 데이터를 저장할 빈클래스 선언
		movieListBean bean = null;

		try {
			pstmt = con.prepareStatement("select * from movie order by no");

			// 결과를 리턴
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 데이터를 저장

			while (rs.next()) {
				// 데이터를 저장할 빈클래스 생성
				bean = new movieListBean();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setDirector(rs.getString("director"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

				list.add(bean);

			}
			// rs.close();
		} catch (Exception ex) {
			System.out.println("getAllMovie 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return list;

	}

	// 하나의 영화 정보를 리턴하는 메소드
	public movieListBean getOneMovie(int no) {

		// 리턴타입 선언
		movieListBean bean = new movieListBean();

		try {
			pstmt = con.prepareStatement("select * from movie where no = ? order by no");

			// 물음표 값
			pstmt.setInt(1, no);

			// 결과를 리턴
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 데이터를 저장

			if (rs.next()) {

				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setPrice(rs.getInt("price"));
				bean.setDirector(rs.getString("director"));
				bean.setImg(rs.getString("img"));
				bean.setInfo(rs.getString("info"));

			}
			rs.close();
			return bean;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}

	public boolean movieupload(movieListBean mlbean) {
		int num = 0;
		String sql = "insert into movie values(?,?,?,?,?,?,?)";
		System.out.println("성공33");
		try {
			pstmt = con.prepareStatement("select max(no) from movie");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			System.out.println(num);
			System.out.println(mlbean.getImg());
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, mlbean.getName());
			pstmt.setString(3, mlbean.getCategory());
			pstmt.setInt(4, mlbean.getPrice());
			pstmt.setString(5, mlbean.getDirector());
			pstmt.setString(6, mlbean.getImg());
			pstmt.setString(7, mlbean.getInfo());
			System.out.println("성공55");
			pstmt.execute();
			return true;

		} catch (Exception ex) {
			System.out.println("movieInsert 에러 : " + ex);

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			System.out.println("성공66");
		}
		return false;
	}

}

//	//최신순 5개의 영화를 리턴하는 메소드
//	public Vector<movieListBean> getSelectMovie(){
//		
//		//리턴타입을 설정
//		Vector<movieListBean> v = new Vector<>();
//		getCon(); //커넥션이 연결되어야 쿼리를 실행 가
//		
//		
//		try {
//			String sql = "select * from movie order by no desc";
//			pstmt = con.prepareStatement(sql);
//			//쿼리 실행 후 결과를 Result 타입으로 리턴
//			rs = pstmt.executeQuery();
//			int count=0;
//			while(rs.next()) {
//				
//				movieListBean bean = new movieListBean();
//				bean.setNo(rs.getInt(1));
//				bean.setName(rs.getString(2));
//				bean.setCategory(rs.getString(3));
//				bean.setPrice(rs.getInt(4));
//				bean.setDirector(rs.getString(5));
//				bean.setImg(rs.getString(6));
//				bean.setInfo(rs.getString(7));
//				//벡터에 빈 클래스를 저장
//				v.add(bean);
//				count++;
//				if(count > 5)break; // 반복문을 빠져나가시오
//				// 5개만 벡터에 저장
//			}
//			con.close();
//		}catch (Exception e) {
//			
//	 }
//		
//		return v;
//  }
