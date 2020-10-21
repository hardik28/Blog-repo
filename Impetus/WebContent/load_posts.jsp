<%@page import="com.blog.entities.User"%>
<%@page import="com.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.blog.database.ConnectionProvider"%>
<%@page import="com.blog.dao.PostDao"%>
<div class="row">
    <%
        User uuu=(User)session.getAttribute("currentUser");
        Thread.sleep(1000);
        PostDao d = new PostDao(ConnectionProvider.getConnection());
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Post> posts = null;
        if (cid == 0) {
            posts = d.getAllPosts();
        } else {
            posts = d.getPostByCatId(cid);
        }
        
        if (posts.size() == 0) {
            out.println("<h3 class='display-3 text-center'>No Posts in this category..</h3>");
            return;
        }
        
        for (Post p : posts) {
    %>

    <div class="col-md-6 mt-2">
        <div class="card">
            <div class="card-body">
                <b><%= p.getpTitle()%></b>
                <p><%= p.getpContent()%></p>

            </div>
            <div class="card-footer bg-primary text-center">
               
                <a href="show_blog_page.jsp?post_id=<%= p.getPid()%>" class="btn btn-outline-dark btn-sm">Read More...</a>
                
                
            </div>

        </div>
    </div>


    <%
        }
        
    %>

</div>