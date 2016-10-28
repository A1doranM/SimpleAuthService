package frontend;

import dataBase.DBService;
import dataBase.DBServiceImpl;
import dataBase.UserDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Registration extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();

        pageVariables.put("Status", "write data");

        response.getWriter().println(PageGenerator.getPage("registration.html", pageVariables));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String login = "", email = "", password = "";
        UserDataSet dataSet = null;
        DBService dbService = new DBServiceImpl();
        Map<String, Object> pageVariables = new HashMap<>();

        login = request.getParameter("login");
        password = request.getParameter("password");
        email = request.getParameter("email");

        response.setContentType("text/html;charset=utf-8");

        if (login == null || login.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        if (password == null || password.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        if (email == null || email.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        try {
            dataSet = dbService.readByName(login);
            if (dataSet.getName().equals(login)) {
                pageVariables.put("Status: ", "this name" + login + "already exists");
            }else if(dataSet.getEmail().equals(email)){
                    pageVariables.put("Status: ", "this email" + email + "already exists");
            }
        }catch(NullPointerException e){
            dbService.save(new UserDataSet(email, login, password));
            pageVariables.put("Status", ": new user created");
        }

        response.getWriter().println(PageGenerator.getPage("registration.html", pageVariables));
        dbService.shutdown();
    }
}
