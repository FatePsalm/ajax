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
				out.print("�û�����ռ��");
			}else{
				out.println("����ʹ��");
			}
		}
		if("/number".equals(action)){
			Random rd=new Random();
			System.out.println("������֤��");
			out.println(rd.nextInt(100));
		}
		if("/getCity".equals(action)){
			String province=request.getParameter("province");
			List<String> list=new ArrayList<String>();
			if("bj".equals(province)){
				list.add("������");
				list.add("������");
				list.add("�찲��");
				out.println(list);
				System.out.println("����");
			}else if("hn".equals(province)){
				list.add("��ɳ��");
				list.add("��̶��");
				list.add("��ɽ��");
				out.println(list);
				System.out.println("����");
			}else if("sd".equals(province)){
				list.add("̫��ɽ");
				list.add("������");
				list.add("̩ɽ");
				out.println(list);
				System.out.println("ɽ��");
			}else{
				System.out.println("Ĭ��");
			}
		}
	}

}















