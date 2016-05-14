package me.liuchuang.servlet;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
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
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String path = request.getContextPath();
        UserDAO userdao = new UserDAO();
        try {
            if (userdao.findUser(username, password)) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect(path + "/index.jsp");
                System.out.println(path);
            } else {
                request.getSession().setAttribute("err", "Login false.");
                response.sendRedirect(path+"/register.jsp");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
