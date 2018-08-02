/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.AccountCharge;
import com.rave.function.Transfer;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "transfer_2", urlPatterns = {"/transfer-2"})
public class transfer_2 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("transfer-2.jsp");
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
        Double txR = Math.random();
        String acc = (String) request.getSession().getAttribute("acc-num");
        String bank = (String) request.getSession().getAttribute("bank");
        String amount = request.getParameter("amount");
        String narration = request.getParameter("narration");
      
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        try {
            Transfer ch = new Transfer();
            
            ch.setAccount_bank(bank);
            ch.setAccount_number(acc);
            ch.setAmount(amount);
            ch.setCurrency("NG");
            ch.setNarration(narration);
        ch.setReference("MX-"+txR.toString());
            
            JSONObject charge = ch.initiateTransfer();
            
            System.out.println(charge);
            JSONObject data = (JSONObject) charge.get("data");
//            String response_code = (String) data.get("chargeResponseCode");

            if (charge.get("status").equals("success")) {
                 String message = (String) charge.get("message");
                System.out.println(message);
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("success");
                return;
                
            } else {
                String message = (String) charge.get("message");
                System.out.println(message);
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("failed");
                return;
                
            }
            
        } catch (JSONException ex) {
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
