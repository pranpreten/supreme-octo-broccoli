package kr.or.ddit.web;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

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
		
		String view = "/WEB-INF/views/fileBrowser.jsp";
		resp.setContentType("text/html;charset=UTF-8");
		ServletContext context = req.getServletContext();
		File folder = new File("D:\\A_TeachingMaterial\\6.JspSrpgin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\work\\Catalina\\localhost\\webStudy01\\org\\apache\\jsp");

		String[] filenames = folder.list();
		for(String name:filenames) {
			System.out.println(name);
		}
		req.setAttribute("file", filenames);
		
		RequestDispatcher re = req.getRequestDispatcher(view);
		re.forward(req, resp);
	}
}
