/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.CardCharge;
import java.io.IOException;
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
@WebServlet(name = "card_payment", urlPatterns = {"/card-payment"})
public class card_payment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("card-payment.jsp");
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
          String cardnumber = request.getParameter("cardnumber");
        String cvv = request.getParameter("cvv");
        String email = request.getParameter("email");
        String pin = request.getParameter("pin");
        String expiry_month = request.getParameter("expiry_month");
        String expiry_year = request.getParameter("expiry_year");

        Double txR = Math.random();

        String txRef = txR.toString();

        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";

        CardCharge payload = new CardCharge();
        String txref = "MX-"+txRef;
        payload.setCardno(cardnumber);
        payload.setCvv(cvv);
        payload.setAmount("2000");
        payload.setEmail(email);
        payload.setExpiryyear(expiry_year);
        payload.setExpirymonth(expiry_month);
        payload.setTxRef(txref);
        payload.setRedirect_url("https://ravemovies.herokuapp.com/verify");

        JSONObject charge = payload.chargeCard();

        System.out.println(charge);
        if (charge.get("status").equals("error")) {
            String message = (String) charge.get("message");
            System.out.println(message);
            HttpSession session = request.getSession(true);
            session.setAttribute("message", message);
            response.sendRedirect("failed");
            return;
        }

        if (charge.get("status").equals("success")) {
            JSONObject data = (JSONObject) charge.get("data");
            if (data.has("suggested_auth")) {
                String authmode = (String) data.get("suggested_auth");

                if (authmode.equals("PIN")) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("pay", payload);
                    session.setAttribute("auth", authmode);
                    session.setAttribute("txRef", txref);
                    response.sendRedirect("pin");
                    return;

                } else if (authmode.equals("NOAUTH_INTERNATIONAL") || authmode.equalsIgnoreCase("AVS_VBVSECURECODE")) {

                    HttpSession session = request.getSession(true);

                    session.setAttribute("pay", payload);
                    session.setAttribute("auth", authmode);
                    session.setAttribute("txRef", txref);
                    response.sendRedirect("avs");
                    return;
                }

            } else {
                response.sendRedirect("success");
                return;
            }
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
