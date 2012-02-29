package task9;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/23/12
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageServlet extends HttpServlet{
  DatabaseHelper helper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
  Resources resources = new Resources();

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    List<Book> bookArray = new ArrayList<Book>();
    if(session.getAttribute("bookPosition") == null){
      session.setAttribute("bookPosition", 0);
   }
    if(resources.getPageChangersList().containsKey(req.getParameter("changeValue"))){
      int bookPosition = (Integer) session.getAttribute("bookPosition");
      session.setAttribute("bookPosition", resources.getPageChangersList().get(req.getParameter("changeValue")).change(bookPosition));
    }
    try {
      bookArray = helper.executeQuery("SELECT * FROM Books LIMIT ?, ?;",new BookRowMapper(), session.getAttribute("bookPosition"), 3);
    } catch (SQLException e) {
      e.printStackTrace();
    }



    session.setAttribute("bookArray" , bookArray);
    resp.sendRedirect("/war/task9/catalog.jsp");
  }

}
