package me.liuchuang.servlet;

import me.liuchuang.beans.User;
import me.liuchuang.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuchuang on 16-5-13.
 */
@WebServlet(name = "RegServlet", urlPatterns = "/RegisterServlet")
public class RegServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String path = request.getContextPath();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDAO userdao = new UserDAO();
        try {
            if (userdao.findUser(username, password)) {
                request.getSession().setAttribute("err", "USERNAME HAS BEEN USED");
                response.sendRedirect("register.jsp");
            } else {
                userdao.addUser(user);
                request.getSession().setAttribute("username", username);
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
