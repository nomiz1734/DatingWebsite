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
import java.util.ArrayList;
import java.util.List;
import model.Report;
import model.userAccount;

/**
 *
 * @author gamek
 */
public class ReportServlet extends HttpServlet {

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
            out.println("<title>Servlet ReportServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if(action == null){
        action = "rp";
        } 
        switch (action) {
            case "rp":
                viewReportList(request, response);
                break;
            case "form":
                showReportForm(request, response);
                break;
            case "delete":
                deleteReport(request, response);
                break;
            default:
                viewReportList(request, response);
                break;
        }
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
        String user1 = user.getUsername();
        String user2 = request.getParameter("user2");
        String reason = request.getParameter("reason");
        Report report = new Report(user1,user2, reason);
        userDAO dao = new userDAO();
        dao.addReport(report);
        response.sendRedirect("report");
       
    }
    
    
    
    private void showReportForm(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        HttpSession session = request.getSession();
        userAccount user = (userAccount) session.getAttribute("user");
        String user1 = user.getUsername();
        String user2 = request.getParameter("user2");
        request.setAttribute("user1", user1);
        request.setAttribute("user2", user2);
        request.getRequestDispatcher("report.jsp").forward(request, response);
    }
    
    private void viewReportList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
     HttpSession session = request.getSession();
        userAccount user = (userAccount) session.getAttribute("user");
        userDAO dao = new userDAO();
        List<Report> report = new ArrayList<>();
        int type = user.getUserTypeId();
        switch(type){
            case 0:
                report = dao.getReportByUser(user.getUsername());
                session.setAttribute("reportList", report);
        request.getRequestDispatcher("listReport.jsp").forward(request, response);
                break;
            case 1:
                report = dao.getAllReport();
                session.setAttribute("reportList", report);
        request.getRequestDispatcher("reportManage.jsp").forward(request, response);
                break;
        }
        
//        like = dao.getAllUserLiked(user.getUsername());
//        System.out.println(like);
        
        
    }
    
    private void deleteReport(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        userAccount user = (userAccount) session.getAttribute("user");
        String user1 = user.getUsername();
        String user2 = request.getParameter("user2");
        userDAO dao = new userDAO();
        dao.deleteReport(user1,user2);
        response.sendRedirect("report");
        
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
