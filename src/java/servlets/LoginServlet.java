package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author 855474
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // create session object
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user_name");
        // Logout
        if (request.getParameter("logout") != null) {
            // invalidates session then 
            // unbinds any objects attached
            session.invalidate();
            // Displays a message to indicate successful log out
            request.setAttribute("message", "You have successfully logged out");
            // this will display the requested JSP as a view
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (username != null) {
            // send the user to the home page
            response.sendRedirect("home");
        } else {
            // this will display the requested JSP as a view
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // create session object
        HttpSession session = request.getSession();
        // create account service object
        AccountService service = new AccountService();

        // grabs the username from the input field
        String username = request.getParameter("input_username");
        // grabs the password from the input field
        String password = request.getParameter("input_password");

        // determines if login button is clicked by user
        if (request.getParameter("login_Button") != null) {
            if (username == null || username.equals("") || password == null || password.equals("")) {
                // Displays an error message to indicate improper input
                request.setAttribute("message", "Please enter your username and password");
                // Forward the user back to the login page
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            } else {
                // pass the username and password parameters to login method
                if (service.login(username, password) != null) {
                    session.setAttribute("user_name", username);
                    // send the user to the home page
                    response.sendRedirect("home");
                } else {
                    // Displays an error message to indicate improper input
                    request.setAttribute("message", "Wrong username or password. Try again.");
                    // Forward the user back to the login page
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                }
            }
        }
    }

}
