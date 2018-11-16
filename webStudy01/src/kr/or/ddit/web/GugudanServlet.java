package kr.or.ddit.web;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet(value="/gugudan.do", loadOnStartup=3)
public class GugudanServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String minDanStr = req.getParameter("minDan");	
		String maxDanStr = req.getParameter("maxDan");
		int minDan = 2;
		int maxDan = 9;
		if(minDanStr!=null&&minDanStr.matches("\\d")) {
			minDan = Integer.parseInt(minDanStr); 
		}
		if(maxDanStr!=null&&maxDanStr.matches("[0-9]")) {
			maxDan = Integer.parseInt(maxDanStr);
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		InputStream in = this.getClass().getResourceAsStream("gugudan.205");
		InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		StringBuffer html = new StringBuffer();
		String temp = null;
		while((temp = br.readLine()) !=null ){
			html.append(temp);
		}	
		StringBuffer sb = new StringBuffer();

		for(int dan = minDan; dan<=maxDan; dan++){
			sb.append("<tr>");
			for(int mul = 1;mul<=9;mul++){
				sb.append(String.format("<td>%d * %d = %d</td>", dan, mul, dan*mul));
			}
			sb.append("</tr>");
		}
		int start = html.indexOf("@gugudan");
		int end = start + "@gugudan".length();
		String replacetext = sb.toString();
		html.replace(start,end,replacetext);
			
		PrintWriter out = resp.getWriter();
		out.println(html.toString());
//		out.close();
	}
	

	
	
}