/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.registrationform;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nikos-pappas
 */
public class Save extends HttpServlet {

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
           User user=new User();
           String first_name=request.getParameter("first_name");
           String last_name=request.getParameter("last_name");
           String birthdate=request.getParameter("birth_date");
           String email=request.getParameter("email");
           String phone_number=request.getParameter("phone");
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           
           user.setFirst_name(first_name);
           user.setLast_name(last_name);
           user.setBirthdate(birthdate);
           user.setUsername(username);
           user.setEmail(email);
           user.setPhone_number(phone_number);
           user.setPassword(password);
           
           if(UserDAO.userExists(username)){
               
               RequestDispatcher rd=request.getRequestDispatcher("UserExists.html");
               rd.include(request, response);
           }
           else{
               int status=UserDAO.save(user);
               if(status==1){
                   RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
                   rd.forward(request, response);
               }
               else{
                   RequestDispatcher rd=request.getRequestDispatcher("Error.html");
                   rd.forward(request, response);
               }
           }
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
