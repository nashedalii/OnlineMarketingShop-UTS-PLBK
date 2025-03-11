public interface ShoppingService {
    void displayProducts();
    void viewCart();
    void addToCart(int productId);
    void removeFromCart(int productId);
    double getTotalPrice();
}
