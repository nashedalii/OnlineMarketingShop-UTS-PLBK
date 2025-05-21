import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private double amount;
    private String status;
    private int paymentMethod;

    public Order(int orderId, double amount, int paymentMethod) {
        this.orderId = orderId;
        this.orderDate = new Date();
        this.amount = amount;
        this.status = "CREATED";
        this.paymentMethod = paymentMethod;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Date: " + orderDate + ", Amount: Rp " + amount +
                ", Status: " + status + ", Payment Method: " + paymentMethod;
    }
}