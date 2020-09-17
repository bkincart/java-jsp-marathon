import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OrderService {
  private EntityManager em;

  public OrderService(EntityManager em) {
    this.em = em;
  }

  public Boolean save(Order order) {
    // try to save it to the database
    try {
      // return true if successful
      em.getTransaction().begin();
      em.persist(order);
      em.getTransaction().commit();
      System.out.println("persisted");

      return true;
    } catch (Exception e) {
      System.out.println("failing to persist");
      System.out.println(e.getMessage());
      System.out.println(e.getStackTrace());
      // return false if it's not
      return false;
    }
  }

  public List<Order> findAll() {
    TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
    return query.getResultList();
  }
}
