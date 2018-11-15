package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImagesFormServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		ServletContext context = req.getServletContext();
		File folder = (File)context.getAttribute("contentFolder");
		
		String[] filenames = folder.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				String mime = context.getMimeType(name);
				return mime.startsWith("image/");
			}
		});
		
		// action 속성의 값은 context/imageService, method="get"
		InputStream in = this.getClass().getResourceAsStream("imageForm.html");
		InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
			
		StringBuffer html = new StringBuffer();
		String temp = null;
		while((temp = br.readLine()) !=null ){
			html.append(temp+"\n");
		}	

		StringBuffer options = new StringBuffer();
		String pattern = "<option>%s</option>\n";
		for(String name:filenames){
			options.append(String.format(pattern, name));
			
		}
		int start = html.indexOf("@option");
		int end = start + "@option".length();
		String replacetext = options.toString();
		html.replace(start,end,replacetext);
		
		PrintWriter out = resp.getWriter();
		out.println(html);
//		out.close();
	}
}
