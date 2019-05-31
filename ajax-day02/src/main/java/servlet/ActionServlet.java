package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ActionServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action:"+action);
		if("/quoto".equals(action)){
			List<Stock> stocks=new ArrayList<Stock>();
			Random r=new Random();
			for(int i=0;i<8;i++){
				Stock s=new Stock();
				s.setCode("600877"+r.nextInt(10));
				s.setName("中国嘉陵"+r.nextInt(10));
				s.setPrice(r.nextInt(1000));
				stocks.add(s);
			}
			ObjectMapper om=new ObjectMapper();
			String jsonstr=om.writeValueAsString(stocks);
			System.out.println(jsonstr);
			out.println(jsonstr);
			
		}else if("/saveInfo".equals(action)){
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			System.out.println(name+","+phone+","+address);
			out.println("保存送货信息成功");
		}
	}

}



















