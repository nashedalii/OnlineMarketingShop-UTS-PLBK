import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private List<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;

    @Override
    public Order createOrder(Cart cart, int paymentMethod) {
        if (cart.getTotalPrice() == 0) {
            System.out.println("Tidak dapat membuat order dengan keranjang kosong.");
            return null;
        }

        Order order = new Order(nextOrderId++, cart.getTotalPrice(), paymentMethod);
        orders.add(order);
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getOrderId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public boolean updateOrderStatus(int id, String status) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setStatus(status);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelOrder(int id) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setStatus("CANCELLED");
            return true;
        }
        return false;
    }
}