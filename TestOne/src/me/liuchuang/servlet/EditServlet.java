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
@WebServlet(name = "EditServlet", urlPatterns = "/EditServlet")
public class EditServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        UserDAO userdao = new UserDAO();
        try {
            user = userdao.getUser(Integer.parseInt(id));
            System.out.println(id);
            if (!userdao.findUser(username) || user.getUsername() == username) {
                System.out.println("username");
                user.setUsername(username);
                user.setPassword(password);
                userdao.update(user);
                request.getSession().setAttribute("username", username);
                response.sendRedirect("index.jsp");

            } else {
                request.getSession().setAttribute("err", "USERNAME HAS BEEN USED");
                response.sendRedirect("edit.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
