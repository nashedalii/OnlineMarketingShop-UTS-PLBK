import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println(product.getName() + " ditambahkan ke keranjang.");
    }

    public void removeProduct(int productId) {
        cartItems.removeIf(product -> product.getId() == productId);
        System.out.println("Produk dengan ID " + productId + " dihapus dari keranjang.");
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Keranjang belanja kosong.");
        } else {
            System.out.println("Produk dalam keranjang:");
            for (Product product : cartItems) {
                System.out.println(product);
            }
        }
    }

    public double getTotalPrice() {
        return cartItems.stream().mapToDouble(Product::getPrice).sum();
    }
}
