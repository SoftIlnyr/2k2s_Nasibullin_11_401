package ru.kpfu.itis.Ilnyr_Nasibullin.Controllers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.Ilnyr_Nasibullin.Aspects.ConfigSIngleton;
import ru.kpfu.itis.Ilnyr_Nasibullin.Repositories.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Ilnyr on 17.10.2015.
 */
@WebServlet(name = "ru.kpfu.itis.ru.kpfu.itis.Ilnyr_Nasibullin.Controllers.RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setContentType и setCharacterEncoding вынесены в аспект ServletContentTypes в пакете Aspects
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String user = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            // проверка корректности введенных данных перенесена в аспект CorrectUserInfo в пакете Aspects
            boolean b3 = UsersRepository.getUserByName(user) == null;
            boolean b4 = UsersRepository.getUserByEmail(email).isEmpty();
            if (b3 && b4) {
                String pasCrypt = UsersRepository.md5Custom(password);
                UsersRepository.addUser(email, user, pasCrypt);
                if (request.getParameter("writer") != null) {
                    UsersRepository.addWriter(user);
                }
                if (request.getParameter("critic") != null) {
                    UsersRepository.addCritic(user);
                }
                session.setAttribute("message", "Регистрация прошла успешно! Теперь выполните вход.");
                response.sendRedirect("/login");
            } else {
                response.sendRedirect("/registration");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Configuration config = ConfigSIngleton.getConfig(getServletContext());
        Template template = config.getTemplate("registration.ftl");
        HashMap<String, Object> root = new HashMap<>();
        HttpSession session = request.getSession();
        try {
            root.put("regmessage", session.getAttribute("regmessage"));
            if (session.getAttribute("goodname") != null) {
                root.put("username", session.getAttribute("username"));
            }
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
