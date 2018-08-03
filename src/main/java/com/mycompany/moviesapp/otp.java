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
@WebServlet(name = "otp", urlPatterns = {"/otp"})
public class otp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("otp-acc.jsp");
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

        try {

            String flwRef = (String) request.getSession().getAttribute("flwRef");
            AccountCharge payload = (AccountCharge) request.getSession().getAttribute("payload");

            payload.setTransaction_reference(flwRef);
            payload.setOtp(otp);
            String txRef = (String) request.getSession().getAttribute("txRef");
            System.out.println(txRef);
            JSONObject val = payload.validateAccountCharge();
            System.out.println(val);
            JSONObject data = (JSONObject) val.get("data");

            String response_code = (String) data.get("chargeResponseCode");
            String message = (String) data.get("acctvalrespmsg");

            if (response_code.equals("00")) {
                JSONObject verify = payload.verify(txRef);
                System.out.println(verify);
                JSONObject datta = (JSONObject) verify.get("data");
                String chargecode = (String) datta.get("chargecode");
                if (chargecode.equals("00")) {
                    String chargemessage = (String) verify.get("status");
                    HttpSession session = request.getSession(true);
                    session.setAttribute("message", chargemessage);
                    response.sendRedirect("success");
                }

                return;
            } else {

                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("failed");
//                response.sendRedirect("AccountError");
                return;
            }
        } catch (Exception ex) {
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
