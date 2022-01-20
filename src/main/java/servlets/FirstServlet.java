package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
            ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariableMap(request);
        String value = request.getParameter("key");
        pageVariables.put("key", value == null ? "" : value);

        response.getWriter().println(PageGenerator.instance().getPage("first.html", pageVariables));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws
            ServletException, IOException {

    }

    public static Map<String, Object> createPageVariableMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
//        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }
}


