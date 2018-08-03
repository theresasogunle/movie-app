/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.CardCharge;
import com.rave.function.SubAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
@WebServlet(name = "paymerchant", urlPatterns = {"/paymerchant"})
public class paymerchant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("paymerchant.jsp");
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
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";

        String bank = request.getParameter("bank");
        String acc = request.getParameter("acc");
        String amount = request.getParameter("amount");
        String bus_name = request.getParameter("bus_name");
        String bus_contact = request.getParameter("bus_contact");
        String bus_cmb = request.getParameter("bus_cmb");
        String bus_mob = request.getParameter("bus_mob");
        String email = request.getParameter("email");
         SubAccount sb = new SubAccount();
       sb.setAccount_bank(bank);
       sb.setAccount_number(acc);
       sb.setAmount(amount);
       sb.setBusiness_contact(bus_contact);
       sb.setBusiness_contact_mobile(bus_cmb);
       sb.setBusiness_email(email);
       sb.setBusiness_name(bus_name);
       sb.setBusiness_mobile(bus_mob);

        JSONObject charge = sb.initiateSubaccountPayment();
        System.out.println(charge);
      
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
