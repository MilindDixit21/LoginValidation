package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<div style='min-height:165px; border:1px solid black; border-radius:10px; padding: 30px 30px 40px; width:350px; text-align:center;'>");
		out.println("<h3>========== THANK YOU ==========</h3>");
		out.println("<br><br><span>You have successfully logged out!</span>");
		out.println("</div>");
		out.println("</body></html>");
	}
}
