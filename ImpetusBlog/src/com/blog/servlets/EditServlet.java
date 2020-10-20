package com.blog.servlets;
import com.blog.dao.UserDao;
import com.blog.entities.Message;
import com.blog.entities.User;
import com.blog.database.ConnectionProvider;
import com.blog.database.Helper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@MultipartConfig
public class EditServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");
            out.println("</head>");
            out.println("<body>");

//            fetch all data
            String userEmail = request.getParameter("user_email");
            String userName = request.getParameter("user_name");
            String userPassword = request.getParameter("user_password");
            String userAbout = request.getParameter("user_about");
            Part part = request.getPart("image");

           

            //get the user from the session...
            HttpSession s = request.getSession();
            User user = (User) s.getAttribute("currentUser");
            user.setEmail(userEmail);
            user.setName(userName);
            user.setPassword(userPassword);
            user.setAbout(userAbout);
            String oldFile = user.getProfile();



            //update database....
            UserDao userDao = new UserDao(ConnectionProvider.getConnection());

            boolean ans = userDao.updateUser(user);
            if (ans) {
            	
                out.println("updated to db");
            } 
            else
            {
            	out.println("not updated to db");
            }

            response.sendRedirect("profile.jsp");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
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