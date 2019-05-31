package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uri=request.getRequestURI();
		PrintWriter out=response.getWriter();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action:"+action);
		if("/check".equals(action)){
			String uname=request.getParameter("uname");
			System.out.println("uname:"+uname);
			if("ssd".equals(uname)){
				out.print("用户名被占用");
			}else{
				out.println("可以使用");
			}
		}
		if("/number".equals(action)){
			Random rd=new Random();
			System.out.println("产生验证码");
			out.println(rd.nextInt(100));
		}
		if("/getCity".equals(action)){
			String province=request.getParameter("province");
			List<String> list=new ArrayList<String>();
			if("bj".equals(province)){
				list.add("海淀区");
				list.add("朝阳区");
				list.add("天安门");
				out.println(list);
				System.out.println("北京");
			}else if("hn".equals(province)){
				list.add("长沙市");
				list.add("湘潭市");
				list.add("韶山市");
				out.println(list);
				System.out.println("湖南");
			}else if("sd".equals(province)){
				list.add("太行山");
				list.add("济南市");
				list.add("泰山");
				out.println(list);
				System.out.println("山东");
			}else{
				System.out.println("默认");
			}
		}
	}

}















