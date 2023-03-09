/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import java.net.URLDecoder;

/**
 *
 * @author mdkul
 */
public class UserServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDB DBconnection = new UserDB();
        RoleDB roleConnection = new RoleDB();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Role> roles = new ArrayList<>();
        users = (ArrayList<User>)DBconnection.getall();
        roles = (ArrayList<Role>)roleConnection.getall();
        request.setAttribute("users", users);
        request.setAttribute("roles", roles);
        
        String whatToDO = request.getParameter("action");
        if(whatToDO ==  null || whatToDO.equals("Cancel")){
            String bottom = "Add User";
            request.setAttribute("subTitle", bottom);
        }
        else if(whatToDO.equals("editUser")){
            String bottom = "Edit User";
            request.setAttribute("subTitle", bottom);
            String theUserEmail = request.getParameter("userEmail");
            theUserEmail = theUserEmail.replace(" ", "+");
            User theUser = DBconnection.getUser(theUserEmail);
            request.setAttribute("userToEdit", theUser);
        }
        else if(whatToDO.equals("Update")){
            //Need to do this, I think I will have to Repopulate the array tho
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String whatToDo = (String) request.getAttribute("action");
        //if (whatToDo.equals("cancel")){
        //    request.setAttribute("action", null);
        //    getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        //}
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
