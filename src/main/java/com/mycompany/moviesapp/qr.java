/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviesapp;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.QRCharge;
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
@WebServlet(name = "qr", urlPatterns = {"/qr"})
public class qr extends HttpServlet {

  

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Double txR = Math.random();
         RaveConstant.ENVIRONMENT = Environment.STAGING;
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        try {
           QRCharge ch = new QRCharge();
            
            
            ch.setAmount("2000");
            ch.setCurrency("NGN");
            ch.setTxRef(txR.toString());
            ch.setCountry("NG");
            ch.setMetaname("Avengers");
            ch.setMetavalue("Infinity war");
            ch.setEmail("sogunledolapo@gmail.com");
            
            
            
            JSONObject charge = ch.chargeQR();
            
            System.out.println(charge);
            JSONObject data = (JSONObject) charge.get("data");
//            String response_code = (String) data.get("chargeResponseCode");
            String image = (String) data.get("qr_image");

            if (charge.get("status").equals("success")) {
                HttpSession session = request.getSession(true);
                session.setAttribute("image", image);
                response.sendRedirect("qr_image");
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
