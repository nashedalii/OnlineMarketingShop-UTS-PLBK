import java.util.ArrayList;
import java.util.List;

public class DatabaseServiceImpl implements DatabaseService {
    private List<Product> products = new ArrayList<>();

    public DatabaseServiceImpl() {
        products.add(new Product(1, "Laptop", 12000000));
        products.add(new Product(2, "Smartphone", 5000000));
        products.add(new Product(3, "Headset", 300000));
        products.add(new Product(4, "Mouse", 150000));
        products.add(new Product(5, "Keyboard", 450000));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
