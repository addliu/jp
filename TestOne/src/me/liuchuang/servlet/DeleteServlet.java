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
 * Created by liuchuang on 16-5-14.
 */
@WebServlet(name = "DeleteServlet", urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDAO userdao = new UserDAO();
        try {
            userdao.deleteUser(Integer.parseInt(id));
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
