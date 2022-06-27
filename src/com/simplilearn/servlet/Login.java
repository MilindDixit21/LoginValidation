package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] usernames = { "Jeff", "Mike", "Tony", "John" };
		String[] passwords = { "Jeff123", "Mike123", "Tony123", "John123" };

		String get_username = request.getParameter("username");
		String get_password = request.getParameter("password");
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();

		int match = 0;
		for (int i = 0; i < usernames.length; i++) {
			String curr_uname = usernames[i];
			String curr_pwd = passwords[i];

			if (curr_uname.equalsIgnoreCase(get_username) && curr_pwd.equals(get_password)) {
				rd = request.getRequestDispatcher("Dashboard");
				rd.forward(request, response);
				match++;
			}
		}

		if (match == 0) {
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.println("<div style='background-color:#fae8e8;border:1px solid #f27976; margin-top:10px; padding: 10px 30px; width:350px; text-align:center;'>");
			out.println("<span style='color:red'>Invalid Login Credentials!</span>");
			out.println("</div>");
		}
	}
}
