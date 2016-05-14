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
@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        UserDAO userdao = new UserDAO();
        try {
            if (!userdao.findUser(username)) {
                user.setUsername(username);
                user.setPassword(password);
                userdao.addUser(user);
                request.getSession().setAttribute("username", username);
                response.sendRedirect("index.jsp");
            } else {
                request.getSession().setAttribute("err", "USERNAME HAS BEEN USED");
                response.sendRedirect("register.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
