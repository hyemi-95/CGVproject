package net.customer.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.movie.db.movieDAO;
import net.movie.db.movieListBean;

public class movieUploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		movieDAO mdao= new movieDAO();//쿼리문을 수행할 객체생성
		movieListBean mlbean = new movieListBean();//영화차트를 담을 객체
		ActionForward forward= new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		//절대경로 폴더생성 : String folderPath = "C:\\Users\\pc\\Desktop\\Project\\eclipse_project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CGVproject\\upload";
		String uploadPath=request.getRealPath("img");//upload라는 파일의 경로를 가져오겠다.

		File a = new File(uploadPath);
		if(!a.mkdir()) {
		a.mkdir();
		}
		

		int size = 10*1024*1024;

		try{
			MultipartRequest multi=new MultipartRequest(request, uploadPath, size, "UTF-8",
					new DefaultFileRenamePolicy());
			
			System.out.println(multi.getParameter("name"));
			System.out.println(multi.getParameter("category"));
			System.out.println(multi.getParameter("director"));
			System.out.println(multi.getParameter("info"));
			System.out.println(Integer.parseInt(multi.getParameter("price")));
System.out.println(multi.getFilesystemName("fileName"));
			
			mlbean.setName(multi.getParameter("name"));
			mlbean.setCategory(multi.getParameter("category"));
			mlbean.setPrice(Integer.parseInt(multi.getParameter("price")));
			mlbean.setDirector(multi.getParameter("director"));
			mlbean.setInfo(multi.getParameter("info"));
			mlbean.setImg(multi.getFilesystemName("fileName"));
			//Enumeration files=multi.getFileNames();			필요가...있나..?
			//String file1=(String)files.nextElement();

			System.out.println("성공11");
			boolean result = mdao.movieupload(mlbean);
			System.out.println("성공122");
			if(result==true) {
				System.out.println("무비업로드 성공");
			}
			forward.setRedirect(false);
	   		forward.setPath("/LoginMain.cu");
	   		return forward;

		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}

}
