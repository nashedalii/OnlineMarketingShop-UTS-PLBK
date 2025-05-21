import java.util.List;

public interface OrderService {
    Order createOrder(Cart cart, int paymentMethod);

    Order getOrderById(int id);

    List<Order> getOrders();

    boolean updateOrderStatus(int id, String status);

    boolean cancelOrder(int id);
}