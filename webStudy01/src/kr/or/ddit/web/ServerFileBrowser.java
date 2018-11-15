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

import kr.or.ddit.web.model2.FileList;

@WebServlet("/fileBrowser.do")
public class ServerFileBrowser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String view = "/WEB-INF/views/fileBrowser.jsp";
		resp.setContentType("text/html;charset=UTF-8");
		ServletContext context = req.getServletContext();
		
		FileList vo = new FileList();
		String[] filenames = vo.getFileList();
		
		req.setAttribute("file", filenames);
		
		RequestDispatcher re = req.getRequestDispatcher(view);
		re.forward(req, resp);
	}
}
