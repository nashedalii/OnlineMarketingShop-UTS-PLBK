import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
    for (int i = 0; i < quantity; i++) {
        cartItems.add(product);
    }
    System.out.println(quantity + "x " + product.getName() + " ditambahkan ke keranjang.");
}


    public void removeProduct(int productId) {
        boolean found = false;
        for (Product product : cartItems) {
            if (product.getId() == productId) {
                found = true;
                break;
            }
        }

        if (found) {
            cartItems.removeIf(product -> product.getId() == productId);
            System.out.println("Produk dengan ID " + productId + " dihapus dari keranjang.");
        } else {
            System.out.println("Produk dengan ID " + productId + " tidak ditemukan dalam keranjang.");
        }
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Keranjang belanja kosong.");
        } else {
            System.out.println("Produk dalam keranjang:");
            Map<Integer, Integer> productCounts = new HashMap<>();

            for (Product product : cartItems) {
                productCounts.put(product.getId(), productCounts.getOrDefault(product.getId(), 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : productCounts.entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = cartItems.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);
                if (product != null) {
                    System.out.println("ID: " + product.getId() + ", Nama: " + product.getName() + ", Harga: Rp " + product.getPrice() + ", Jumlah: " + quantity);
                }
            }
        }
    }


    public double getTotalPrice() {
        return cartItems.stream().mapToDouble(Product::getPrice).sum();
    }
}
