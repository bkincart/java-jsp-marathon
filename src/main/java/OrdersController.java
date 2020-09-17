import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/", "/orders", "/orders/new"})
public class OrdersController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletPath().equals("/")) {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    } else if (req.getServletPath().equals("/orders")) {
      EntityManager em = getEmf().createEntityManager();

      try {
        OrderService service = new OrderService(em);
        req.setAttribute("orders", service.findAll());
      }
      finally {
        em.close();
      }
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
      dispatcher.forward(req, resp);
    } else if (req.getServletPath().equals("/orders/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/new.jsp");
      dispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // check for the proper path
    if (req.getServletPath().equals("/orders")) {
      // create an instance of our Entity
      Order order = new Order();
      // fill it with the user's input
      try {
        BeanUtils.populate(order, req.getParameterMap());
      } catch (IllegalAccessException e) {
        System.out.println("Error:\nBeansUtils could not find setter: \n");
      } catch (InvocationTargetException e) {
        System.out.println("Error:\nBeansUtils had an error with the setter: \n");
      }
      System.out.println(order.getGlutenFree());
      System.out.println(order.getItemImageURL());
      System.out.println(order.getItemName());
      System.out.println(order.getItemQuantity());
      System.out.println(order.getUsername());
      System.out.println(order.getVegan());
      // try to save it to the database
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();

      OrderService service = new OrderService(em);
      service.save(order);

      em.close();

      // redirect somewhere once it's done
      resp.sendRedirect("/orders");
    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }
}
