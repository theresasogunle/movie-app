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
@WebServlet(name = "otpcard", urlPatterns = {"/otpcard"})
public class otpcard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("otp-card.jsp");
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

        String otp = request.getParameter("otp");
        CardCharge ch = new CardCharge();

        RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";

        try {

            String flwRef = (String) request.getSession().getAttribute("flwRef");
            String txRef = (String) request.getSession().getAttribute("txRef");
            System.out.println(txRef);

            System.out.println(flwRef);
            ch.setTransactionreference(flwRef);
            ch.setOtp(otp);

            JSONObject val = ch.validateCardCharge();
            System.out.println(val);
            JSONObject dat = (JSONObject) val.get("data");

            if (val.get("status").equals("success")) {

                JSONObject verify = ch.verify(txRef);
                System.out.println(verify);
                JSONObject data = (JSONObject) verify.get("data");
                String chargecode = (String) data.get("chargecode");
                if (chargecode.equals("00")) {
                    String chargemessage = (String) verify.get("status");
                    HttpSession session = request.getSession(true);
                    session.setAttribute("message", chargemessage);
                    response.sendRedirect("success");
                }

                return;
            } else {
                String message = (String) val.get("message");
                System.out.println(message);
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("failed");
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
