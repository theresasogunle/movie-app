/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.AccountCharge;
import com.rave.function.RecurringPayment;
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
@WebServlet(name = "account_dp", urlPatterns = {"/account-dp"})
public class account_dp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("account-dp.jsp");
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
        String txref = "MX-" + txRef;
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        try {

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

                AccountCharge ch = new AccountCharge();

                ch.setAccountbank(bank)
                        .setAccountnumber(acc)
                        .setEmail(email)
                        .setTxRef(txref)
                        .setAmount("2000")
                        .setCountry("NG")
                        .setPayment_plan(plan_id)
                        .setCurrency("NGN");

                JSONObject charge = ch.chargeAccount();

                System.out.println(charge);
                JSONObject data = (JSONObject) charge.get("data");
                if (charge.get("status").equals("success")) {
                    if (data.get("chargeResponseCode").equals("02")) {

                        String flw = (String) data.get("flwRef");
                        HttpSession session = request.getSession(true);
                        session.setAttribute("flwRef", flw);
                        session.setAttribute("payload", ch);
                        session.setAttribute("txRef", txref);
                        response.sendRedirect("otp");
                        return;
                    } else {
                        response.sendRedirect("success");
                        return;
                    }
                } else {
                    String message = (String) charge.get("message");
                    System.out.println(message);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("message", message);
                    response.sendRedirect("failed");
                    return;

                }
            } else {
                String message = (String) plan.get("message");
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
