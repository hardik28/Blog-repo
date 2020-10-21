package com.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.UserDao;
import com.blog.database.ConnectionProvider;
import com.blog.entities.Message;
import com.blog.entities.User;


public class LoginServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
//          login 
//            fetch username and password from request
            String userEmail = request.getParameter("email");
            String userPassword = request.getParameter("password");

            UserDao dao = new UserDao(ConnectionProvider.getConnection());

            User u = dao.getUserByEmailAndPassword(userEmail, userPassword);

            if (u == null) {
                //login.................
            	//error
            	Message msg=new Message(" Invalid Login","error","alert-danger");
            	HttpSession s = request.getSession();
                s.setAttribute("msg",msg);                
                response.sendRedirect("login_page.jsp");
            } else {
                //......
            	//login success
                HttpSession s = request.getSession();
                s.setAttribute("currentUser", u);
                response.sendRedirect("profile.jsp");
                out.println("Success");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}