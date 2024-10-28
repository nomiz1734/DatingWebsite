/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.EmailService;
import model.IJavamail;

/**
 *
 * @author quang
 */
public class SignUpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String EMAIL_REGEX
            = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userDAO dao = new userDAO();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        boolean checkUser = dao.checkExistUserName(username);
        boolean checkEmail = dao.checkExistedUserByEmail(email);
        boolean isPasswordValid = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        if (checkUser == true) {
            String alertMessage = "Username has taken. Please try again.";
            String redirectUrl = "signup.jsp";
            String script = "<script>alert('" + alertMessage + "');";
            script += "window.location.href='" + redirectUrl + "';</script>";
            response.getWriter().println(script);
        } else if (checkEmail) {
            String alertMessage = "Email has taken or invalid. Please try again.";
            String redirectUrl = "signup.jsp";
            String script = "<script>alert('" + alertMessage + "');";
            script += "window.location.href='" + redirectUrl + "';</script>";
            response.getWriter().println(script);
        } else if (!isValidEmail(email)) {
            String alertMessage = "Email is invalid. Please try again.";
            String redirectUrl = "signup.jsp";
            String script = "<script>alert('" + alertMessage + "');";
            script += "window.location.href='" + redirectUrl + "';</script>";
            response.getWriter().println(script);
        } else if (!isPasswordValid) {
            String alertMessage = "Password is invalid. Please try again.Password must at least one number, one lowercase letter, "
                    + "one uppercase letter, one special character and must not contain spaces, and at least 8 character.";
            String redirectUrl = "signup.jsp";
            String script = "<script>alert('" + alertMessage + "');";
            script += "window.location.href='" + redirectUrl + "';</script>";
            response.getWriter().println(script);
        } else if (!password.equalsIgnoreCase(confirmPassword)) {
            String alertMessage = "Password and Confirm Password do not match. Please try again.";
            String redirectUrl = "signup.jsp";
            String script = "<script>alert('" + alertMessage + "');";
            script += "window.location.href='" + redirectUrl + "';</script>";
            response.getWriter().println(script);
        } else {
            dao.addUser(username, password, email);
            IJavamail emailService = new EmailService();
            emailService.send(email, subjectRegistration(), messageRegistration(username));
            String alertMessage = "Sign up already done. Please log in to your account.";
            String redirectUrl = "home.jsp";
            String script = "<script>alert('" + alertMessage + "');";
            script += "window.location.href='" + redirectUrl + "';</script>";
            response.getWriter().println(script);
        }
    }

    public String messageRegistration(String name) {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Password Reset Code</title>\n"
                + "</head>\n"
                + "\n"
                + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;\">\n"
                + "\n"
                + "    <table\n"
                + "        style=\"width: 100%; max-width: 600px; margin: 20px auto; background-color: #ffffff; border-collapse: collapse;\">\n"
                + "        <tr>\n"
                + "            <td style=\"padding: 20px; text-align: center; background-color: #FF0000; color: #ffffff; font-size: 24px;\">\n"
                + "                Registration successfully\n"
                + "            </td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td style=\"padding: 20px;\">\n"
                + "                <p>Hello yang123,</p>\n"
                + "                <p>Thanks for joining Love Connection, your free account is ready and you can start finding your partner\n"
                + "                    now.</p>\n"
                + "                <br>\n"
                + "                <p>Best regards,</p>\n"
                + "                <p>Love Connection Team</p>\n"
                + "            </td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td style=\"padding: 20px; text-align: center; background-color: #FF0000; color: #ffffff;\">\n"
                + "                &copy; 2024 Love Connection\n"
                + "            </td>\n"
                + "        </tr>\n"
                + "    </table>\n"
                + "\n"
                + "</body>\n"
                + "\n"
                + "</html>";
    }

    public String subjectRegistration() {
        return "Welcome to Love Connection";
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
