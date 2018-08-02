/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.CardCharge;
import com.rave.function.RecurringPayment;
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
@WebServlet(name = "card_payment_dp", urlPatterns = {"/card_payment_dp"})
public class card_payment_dp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("card-payment-dp.jsp");
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

        String expiry_month = request.getParameter("expiry_month");
        String expiry_year = request.getParameter("expiry_year");

        Double txR = Math.random();

        String txRef = txR.toString();
            String txref = "MX-"+txRef;

        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";

        RecurringPayment rr = new RecurringPayment();

        rr.setAmount("300");
        rr.setCurrency("NGN");
        rr.setDuration("1");
        rr.setInterval("monthly");
        rr.setMetaname("Deadpool");
        rr.setMetavalue("DP");
        rr.setName("Deadpooll");

        JSONObject plan = rr.createPaymentPlan();
        if (plan.get("status").equals("success")) {
            JSONObject data_1 = (JSONObject) plan.get("data");
            int plan_id = (Integer) data_1.get("id");
            CardCharge payload = new CardCharge();

            payload.setCardno(cardnumber);
            payload.setCvv(cvv);

            payload.setEmail(email);
            payload.setExpiryyear(expiry_year);
            payload.setAmount("300"); 
            payload.setExpirymonth(expiry_month);
            payload.setTxRef(txref);
            payload.setPayment_plan(plan_id);
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
            }else{
            String message = (String) plan.get("message");
                System.out.println(message);
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("failed");
                return;
           }
            doGet(request, response);

        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>
    }
