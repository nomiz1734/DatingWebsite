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
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author quang
 */
public class ChangePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassword at " + request.getContextPath() + "</h1>");
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
            HttpSession session = request.getSession();
            userAccount user = (userAccount) session.getAttribute("user");
            String pw = user.getPassword();
            String name = user.getUsername();
//            String curPassword = request.getParameter("curPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            boolean isPasswordValid = newPassword.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
            boolean check = true;
            userDAO dao = new userDAO();
            if (isPasswordValid == false) {
                String alertMessage = "Password is invalid. Please try again.Password must at least one number, one lowercase letter, "
                        + "one uppercase letter, one special character and must not contain spaces, and at least 8 character.";
                request.setAttribute("alertMessage", alertMessage);
                System.out.println(alertMessage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            } else if (!newPassword.equals(confirmPassword)) {
                String alertMessage = "New password and Confirm password doesn't match. Please try again";
                request.setAttribute("alertMessage", alertMessage);
                System.out.println(alertMessage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            } else {
                try {
                    dao.updatePasswordwithUserName(name, newPassword);
                    String alertMessage = "Change password successfully.";
                    request.setAttribute("alertMessage", alertMessage);
                    System.out.println(alertMessage);
                    request.getRequestDispatcher("profile.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
