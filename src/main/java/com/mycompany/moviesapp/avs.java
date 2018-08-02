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
@WebServlet(name = "avs", urlPatterns = {"/avs"})
public class avs extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("avs.jsp");
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

        String billing_zip = request.getParameter("billing_zip");
        String billing_address = request.getParameter("billing_address");
        String billing_city = request.getParameter("billing_city");
        String billing_state = request.getParameter("billing_state");
        String billing_country = request.getParameter("billing_country");

        CardCharge payload = (CardCharge) request.getSession().getAttribute("pay");
        String authmode = (String) request.getSession().getAttribute("auth");
        System.out.println(payload);
        System.out.println(authmode);

        payload.setBillingaddress(billing_address);
        payload.setBillingcity(billing_city);
        payload.setBillingcountry(billing_country);
        payload.setBillingstate(billing_state);
        payload.setBillingzip(billing_zip);

        JSONObject charge = payload.recharge(authmode);
        System.out.println(charge);
        JSONObject data = (JSONObject) charge.get("data");
        if (charge.get("status").equals("success")) {
            if (data.get("chargeResponseCode").equals("00")) {
                response.sendRedirect("success");

                return;
            } else if (data.get("chargeResponseCode").equals("02")) {
                if (data.get("authModelUsed").equals("VBVSECURECODE")) {

                    String authurl = (String) data.get("authurl");

                    HttpSession session = request.getSession(true);
                    session.setAttribute("txRef", payload.getTxRef());
                    response.sendRedirect(authurl);

                    request.getQueryString();
                    return;
                } else if (data.get("authModelUsed").equals("ACCESS_OTP")
                        || data.get("authModelUsed").equals("GTB_OTP")
                        || data.get("authModelUsed").equals("PIN")) {
                    String message = (String) charge.get("message");
                    System.out.println(message);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("message", message);
                    response.sendRedirect("failed");
                    return;
                }

            }
        } else {
            String message = (String) charge.get("message");
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
