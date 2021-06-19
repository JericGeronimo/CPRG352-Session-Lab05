package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 855474
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // create session object
        HttpSession session = request.getSession();
        // grabs the username of the 
        String username = (String) session.getAttribute("user_name");
        // determine if an authenticated user returns to the website
        if (username == null || username.equals("")) {
            // send the user to the login page
            response.sendRedirect("login");
        } else {
            // this will display the requested JSP as a view
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
    }
}
