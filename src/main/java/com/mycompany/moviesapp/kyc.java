/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.BvnValidation;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
@WebServlet(name = "kyc", urlPatterns = {"/kyc"})
public class kyc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("kyc.jsp");
        view.forward(request, response);
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
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String middle_name = request.getParameter("middle_name");
        String phone_number = request.getParameter("phone");
        String bvn = request.getParameter("bvn");

        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        try {
            BvnValidation ch = new BvnValidation();

            JSONObject charge = ch.validateBVN(bvn);

            System.out.println(charge);
            JSONObject data = (JSONObject) charge.get("data");

            System.out.println(charge.get("status"));
            if (charge.get("status").equals("success")) {
                
                    response.sendRedirect("validbvn.jsp");
                    return;
                
            } else {
                String message = (String) charge.get("message");
                System.out.println(message);
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("failedbvn.jsp");
                return;

            }

        } catch (Exception ex) {
        }
        doGet(request, response);
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
