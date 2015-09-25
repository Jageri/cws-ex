package pra.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pra.login.dao.LoginDao;
import pra.login.service.LoginService;

@SuppressWarnings("serial")
public class LoginAction extends HttpServlet {

	private LoginService service;

	/**
	 * Constructor of the object.
	 */
	public LoginAction() {
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
		String id = request.getParameter("id");
		String psw = request.getParameter("psw");

		List<Object> params = new ArrayList<Object>();
		params.add(id);
		params.add(psw);

		int flag = service.login(params);
		System.out.println(flag);
		if (flag == 1) {
			request.setAttribute("stulog", id);
			request.setAttribute("stu", id);
			request.getRequestDispatcher("/stu.jsp").forward(request, response);
		} else if (flag == 2) {
			request.setAttribute("teclog", id);
			request.getRequestDispatcher("/tec.jsp").forward(request, response);
		} else {			
			request.setAttribute("loginError", "’ ∫≈ªÚ√‹¬Î¥ÌŒÛ£°");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

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
		service = new LoginDao();
	}

}
