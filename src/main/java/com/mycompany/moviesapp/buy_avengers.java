/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.AccountCharge;
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
@WebServlet(name = "buy_avengers", urlPatterns = {"/buy-avengers"})
public class buy_avengers extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("buy-avengers.jsp");
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
        String acc = request.getParameter("acc");
        String bank = request.getParameter("bank");
        String email = request.getParameter("email");
        Double txR = Math.random();

        String txRef = txR.toString();
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        try {
            AccountCharge ch = new AccountCharge();

            ch.setAccountbank(bank)
                    .setAccountnumber(acc)
                    .setEmail(email)
                    .setTxRef(txRef)
                    .setAmount("2000")
                    .setCountry("NG")
                    .setCurrency("NGN");

            JSONObject charge = ch.chargeAccount();

            System.out.println(charge);
            JSONObject data = (JSONObject) charge.get("data");
            String response_code = (String) data.get("chargeResponseCode");

            if (charge.get("status").equals("success")) {
                {
                    if (response_code.equals("02")) {

                        String flw = (String) data.get("flwRef");
                        HttpSession session = request.getSession(true);
                        session.setAttribute("flwRef", flw);
                        session.setAttribute("payload", ch);
                        response.sendRedirect("Otp");
                        return;
                    }
                    else if (response_code.equals("00")) {
                         response.sendRedirect("Success");
                        return;
                        
                    }
                }
            } else {
                String message = (String) charge.get("message");
                System.out.println(message);
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("401");
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
