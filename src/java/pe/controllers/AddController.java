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
import pe.entity.Comestic;
import pe.entity.ComesticError;

/**
 *
 * @author Trần Công Lâm
 */
public class AddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "add.jsp";
    private static final String SUCCESS = "login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        ComesticError comesticError = new ComesticError();
        UserDAO dao = new UserDAO();
        boolean checkValidation = true;
        
        try {
            String Id = request.getParameter("Id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            
        
            boolean checkDuplicate = dao.checkDuplicateComestic(name);
            
            if (checkDuplicate) {
                comesticError.setName("Duplicate name");
                checkValidation = false;
            }           
            if (checkValidation == true) {
                Comestic comestic = new Comestic(Id, name, description, price, status);
                //    boolean checkInsert = dao.insert(user);
                boolean checkInsert = dao.insertV2Comestic(comestic);
                if (checkInsert) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("COMESTIC_ERROR", comesticError);
            }
        } catch (Exception ex) {
            log("Error at CreateController: " + ex.toString());
            if (ex.toString().contains("duplicate")) {
                comesticError.setName("Duplicate name");
                request.setAttribute("COMESTIC_ERROR", comesticError);
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
