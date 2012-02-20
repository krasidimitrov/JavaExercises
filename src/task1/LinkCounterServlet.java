package task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/15/12
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkCounterServlet extends HttpServlet {
  private Map<String, Integer> countMap = new HashMap<String, Integer>();
  private int count;

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String link = req.getParameter("link");
    if(countMap.containsKey(link)){
      count = countMap.get(link)+1;
      countMap.put(link,count);
    } else {
      countMap.put(link,1);
    }
    session.setAttribute(link+"count",countMap.get(link));
//    if (link.equals("link1")) {
//      count1++;
//      session.setAttribute("count1", count1);
//    }
//
//    if (link.equals("link2")) {
//      count2++;
//      session.setAttribute("count2", count2);
//    }
//
//    if (link.equals("link3")) {
//      count3++;
//      session.setAttribute("count3", count3);
//    }
//    PrintWriter out = resp.getWriter();
//
//    out.println(req.getRequestURL());
    resp.sendRedirect("/war/task1/links.jsp");
  }
}
