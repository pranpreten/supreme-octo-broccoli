package kr.or.ddit.web;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileBrowser.do")
public class ServerFileBrowser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String getFilePath = req.getParameter("filePath");
		String fileBackPath = req.getParameter("fileBackPath");
		ServletContext context = getServletContext();
		String fileUrl = null;
		if(fileBackPath==null) {
			fileUrl = Objects.toString(getFilePath, context.getRealPath(""));
		}else {
			fileUrl = fileBackPath;
		}
		File file = new File(fileUrl);
		req.setAttribute("fileUrl", fileUrl);
		File[] fileList = file.listFiles();
		req.setAttribute("fileList", fileList);
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/fileBrowser.jsp");
		rd.forward(req, resp);
		
	}

}
