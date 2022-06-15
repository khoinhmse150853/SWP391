/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AdminDAO;
import daos.PitchDAO;
import daos.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.District;
import models.SendEmail;
import models.User;
import models.Ward;

/**
 *
 * @author SE150853 Nguyen Huynh Minh Khoi
 */
@WebServlet(name = "AdminController", urlPatterns = {"/admin"})
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getAttribute("action").toString();
        switch (action) {
            case "viewBecomingOwner":
                //Xu ly
                viewBecomingOwner(request, response);
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            case "getBecomingOwnerInfo":
                //Xu ly
                getBecomingOwnerInfo(request, response);
                break;
            case "confirmOwner":
                //Xu ly
                confirmOwner(request, response);
                break;
            default:
                request.setAttribute("action", "error");
        }
    }

    private void viewBecomingOwner(HttpServletRequest request, HttpServletResponse response) {
        try {
            AdminDAO ad = new AdminDAO();
            List<User> listU = ad.getUserForBecomingOwner();
            List<User> listNoAdmin = ad.getUserForBecomingOwner();
            request.setAttribute("listNoAdmin", listNoAdmin);
            request.setAttribute("countNoAdmin", listNoAdmin.size());
            request.setAttribute("listU", listU);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getBecomingOwnerInfo(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            String userID = request.getParameter("UserID");
            PitchDAO pd = new PitchDAO();
            UserDAO ud = new UserDAO();

            User user = ud.getUser(userID);
            List<Ward> listW = pd.getAllWard();
            List<District> listD = pd.getDistrict();

            for (District district : listD) {
                for (Ward ward : listW) {
                    if (user.getDistrictID().equals(district.getDistrictID()) && user.getWardID().equals(ward.getWardID())) {
                        out = response.getWriter();
                        out.println("<form>\n"
                                + "    <div class=\"mb-3\">\n"
                                + "        <label for=\"exampleInputEmail1\" class=\"form-label\">Họ tên người chờ xét duyệt</label>\n"
                                + "        <input type=\"text\" value=\"" + user.getFullName() + "\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" disabled=\"\">\n"
                                + "    </div>\n"
                                + "    <div class=\"mb-3\">\n"
                                + "        <label for=\"exampleInputEmail1\" class=\"form-label\">Số điện thoại</label>\n"
                                + "        <input type=\"text\" value=\"" + user.getPhone() + "\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" disabled=\"\">\n"
                                + "    </div>\n"
                                + "    <div class=\"mb-3\">\n"
                                + "        <label for=\"exampleInputEmail1\" class=\"form-label\">Email</label>\n"
                                + "        <input type=\"email\" value=\"" + user.getEmail() + "\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" disabled=\"\">\n"
                                + "    </div>\n"
                                + "    <div class=\"mb-3\">\n"
                                + "        <label for=\"exampleInputEmail1\" class=\"form-label\">Địa chỉ</label>\n"
                                + "        <input type=\"email\" value=\"" + user.getUserAddress() + ", " + ward.getWardName() + ", " + district.getDistrictName() + "\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" disabled=\"\">\n"
                                + "    </div>\n"
                                + "</form>");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void confirmOwner(HttpServletRequest request, HttpServletResponse response) {
        try {
            String userID = request.getParameter("Id");
            UserDAO ud = new UserDAO();
            AdminDAO ad = new AdminDAO();
            User user = ud.getUser(userID);
            SendEmail sm = new SendEmail();

            if (ad.updateBecomingOwner(userID)) {
                sm.sendEmailConfirmOwner(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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