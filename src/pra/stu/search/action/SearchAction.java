package pra.stu.search.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pra.stu.search.dao.*;
import pra.stu.search.service.*;

@SuppressWarnings("serial")
public class SearchAction extends HttpServlet {

	private SearchService service;

	/**
	 * Constructor of the object.
	 */
	public SearchAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("idd");
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		List<Map<String, Object>> res = service.Search(params);
		if (res.size() == 0) {
			request.setAttribute("resu", "��ϲ��û��ȱ�ڼ�¼��");
			request.getRequestDispatcher("/stu.jsp").forward(request, response);
		}
		else {
			String reString=res.toString();
			reString.replace("cname", "�γ���");
			reString.replace("ctime", "�Ͽ�ʱ��");
			System.out.println(reString );
			request.setAttribute("resu", "ȱ�ڼ�¼Ϊ"+reString);
			request.setAttribute("stulog2", id);
			request.getRequestDispatcher("/stu.jsp").forward(request, response);
		}
		System.out.println(res.size());
		System.out.println(res.size());
		System.out.println(res.size());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		service = new SearchDao();
	}

}
