/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.function.CardCharge;
import java.io.IOException;
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
@WebServlet(name = "verify", urlPatterns = {"/verify"})
public class verify extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String str = request.getQueryString();
        System.out.println(str);
//       response.sendRedirect("success");
        CardCharge ch = new CardCharge();
        String txRef = (String) request.getSession().getAttribute("txRef");
        System.out.println(txRef);
        JSONObject chh = ch.verify(txRef);
        System.out.println(chh);
        JSONObject data = (JSONObject) chh.get("data");

        if (chh.get("status").equals("success")) {
            if (data.get("chargecode").equals("00")) {
                String message = (String) chh.get("status");
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("success");
            } else {
                String message = (String) data.get("message");
                HttpSession session = request.getSession(true);
                session.setAttribute("message", message);
                response.sendRedirect("failed");
            }

        } else {
            String message = (String) data.get("message");
            HttpSession session = request.getSession(true);
            session.setAttribute("message", message);
            response.sendRedirect("failed");
        }
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
