public class ShoppingServiceImpl implements ShoppingService {
    private DatabaseService databaseService;
    private Cart cart;

    public ShoppingServiceImpl(DatabaseService databaseService) {
        this.databaseService = databaseService;
        this.cart = new Cart();
    }

    @Override
    public void displayProducts() {
        System.out.println("Daftar Produk:");
        for (Product product : databaseService.getProducts()) {
            System.out.println(product);
        }
    }

    @Override
    public void viewCart() {
        cart.viewCart();
    }

    @Override
    public void addToCart(int productId, int quantity) {
    Product product = databaseService.getProductById(productId);
    if (product != null) {
        cart.addProduct(product, quantity);
    } else {
        System.out.println("Produk tidak ditemukan.");
    }
}


    @Override
    public void removeFromCart(int productId) {
        cart.removeProduct(productId);
    }

    @Override
    public double getTotalPrice() {
        return cart.getTotalPrice();
    }
}
