package com.blog.servlets;

import com.blog.dao.UserDao;
import com.blog.entities.User;
import com.blog.database .ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@MultipartConfig
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          

//            fetch all form data
        	 String check = request.getParameter("check");
             if (check == null) {
                 out.println("box not checked");
             } else {
                 //baki ka data yaha nikalna..
                 String name = request.getParameter("user_name");
                 String email = request.getParameter("user_email");
                 String password = request.getParameter("user_password");
                 String gender = request.getParameter("gender");
                 String about = request.getParameter("about");
                 //create user object and set all data to that object..
                 User user = new User(name, email, password, gender, about);

                 //create a user daao object..
                 UserDao dao = new UserDao(ConnectionProvider.getConnection());
                 if (dao.saveUser(user)) {
//                 save..
                     out.println("done");
                 } else {
                     out.println("error");
                 }
             }
          
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