package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/songs")
public class MusicLyricsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		ServletContext context = req.getServletContext();
		File folder = new File("d:/contents");

		String[] filenames = folder.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				String mime = context.getMimeType(name);
				return mime.startsWith("text/");
			}
		});

		InputStream in = this.getClass().getResourceAsStream("songForm.html");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		StringBuffer html = new StringBuffer();
		String temp = null;
		while ((temp = br.readLine()) != null) {
			html.append(temp + "\n");
		}

		StringBuffer options = new StringBuffer();
		String pattern = "<option>%s</option>\n";
		for (String name : filenames) {
			options.append(String.format(pattern, name));

		}
		int start = html.indexOf("@option");
		int end = start + "@option".length();
		String replacetext = options.toString();
		html.replace(start, end, replacetext);

		PrintWriter out = resp.getWriter();
		out.println(html);
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 파라미터 확보 : 파라미터명(image)
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
	
		String txtName = req.getParameter("music");
		if (txtName == null && txtName.trim().length() == 0) {
			resp.sendError(400);
			return;
		}
		// txtName : 파일명(트와이스.txt)
		// folder : 디렉토리
		File folder = new File("d:/contents");
		File txtFile = new File(folder, txtName);

		if (!txtFile.exists()) {
			resp.sendError(404);
			return;
		}

		// ServletContext context = req.getServletContext();
		// resp.setContentType(context.getMimeType(txtName));

		// 텍스트파일읽어오기

	    BufferedReader br = 
	    		new BufferedReader(
	    				new InputStreamReader(
	    						new FileInputStream(txtFile),"UTF-8")); //utf-8 안됨
        
	    StringBuffer sb = new StringBuffer();
        String line = null;
        
        sb.append("<html>");
        sb.append("<body>");
        while ((line = br.readLine()) != null) {
            sb.append(line+"<br>");
        }
        sb.append("</html>");
        sb.append("</body>");
        
        PrintWriter out = resp.getWriter();
        out.println(sb.toString());
        out.close();

	}

}
