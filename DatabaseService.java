import java.util.List;

public interface DatabaseService {
    List<Product> getProducts();
    Product getProductById(int id);
}
