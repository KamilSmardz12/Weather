import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns= "/DisplayWeather")
public class DisplayWeather extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String city = request.getParameter("city");
        String country = request.getParameter("country");
        request.setAttribute("city", city);
        request.setAttribute("country", country);

        RequestDispatcher dispatcher = request.getRequestDispatcher("wd.jsp");
        dispatcher.forward(request,response);


    }
}
