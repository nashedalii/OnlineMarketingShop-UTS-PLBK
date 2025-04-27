public interface ShoppingService {
    void displayProducts();
    void viewCart();
    void addToCart(int productId, int quantity);
    void removeFromCart(int productId);
    double getTotalPrice();
}
