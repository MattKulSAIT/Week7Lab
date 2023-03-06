/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.UserDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author mdkul
 */
public class UserServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDB DBconnection = new UserDB();
        ArrayList<User> users = new ArrayList<>();
        users = (ArrayList<User>)DBconnection.getall();
        request.setAttribute("users", users);
        
        String whatToDO = request.getParameter("action");
        if(whatToDO ==  null){
            String bottom = "Add User";
            request.setAttribute("subTitle", bottom);
        }
        else if(whatToDO.equals("editUser")){
            String bottom = "Edit User";
            request.setAttribute("subTitle", bottom);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
