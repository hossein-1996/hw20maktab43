import Dao.UserDao;
import Util.JPAUtil;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
    UserDao userDao = new UserDao(entityManager);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/html");

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            String password = servletRequest.getParameter("password");
            String username = servletRequest.getParameter("userName");
            User user = userDao.loadUser(username, password);
            String password2 = user.getPassword();
            String username2 = user.getUserName();

            servletRequest.setAttribute("username",username2);
            if (username.equals(username2) && password.equals(password2)) {

                servletRequest.getRequestDispatcher("FirstPage.jsp").forward(servletRequest,servletResponse);
            }
        } catch (NoResultException noResultException) {

            response.sendRedirect("UserError.jsp");
//            RequestDispatcher rd = servletRequest.getRequestDispatcher("login.html");
//            rd.include(servletRequest, servletResponse);
        }

    }
    @Override
    public void destroy()  {

    }
}
