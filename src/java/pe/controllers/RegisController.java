/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.dao.UserDAO;
import pe.entity.User;
import pe.entity.UserError;

/**
 *
 * @author Trần Công Lâm
 */
public class RegisController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "registration.jsp";
    private static final String SUCCESS = "login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        UserError userError = new UserError();
        UserDAO dao = new UserDAO();
        boolean checkValidation = true;
//        System.out.println("OK");
        try {
            String userID = request.getParameter("userID");
            Boolean status = Boolean.parseBoolean(request.getParameter("status"));
            
            String fullName = request.getParameter("fullName");
           
            String password = request.getParameter("password");
            System.out.println(userID + status + fullName + password);
            String pattern = "^US\\d{3}$";
            
            if (!userID.matches(pattern)) {
                userError.setUserID("UserID must be start with US and contain 3 numbers");
                checkValidation = false;
            }
            boolean checkDuplicate = dao.checkDuplicateUser(userID);
            if (checkDuplicate) {
                userError.setUserID("Duplicate userID");
                checkValidation = false;
            }
            
            if (checkValidation == true) {
                User user = new User(userID, status, fullName, password);
                //    boolean checkInsert = dao.insert(user);
                boolean checkInsert = dao.insertV2User(user);
                System.out.println(checkInsert);
                if (checkInsert) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception ex) {
            log("Error at CreateController: " + ex.toString());
            if (ex.toString().contains("duplicate")) {
                userError.setUserID("Duplicate userID");
                request.setAttribute("USER_ERROR", userError);
            }
        } finally {
            
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
