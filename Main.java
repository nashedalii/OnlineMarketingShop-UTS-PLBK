import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseService dbService = new DatabaseServiceImpl();
        ShoppingService shoppingService = new ShoppingServiceImpl(dbService);
        PaymentService paymentService = new PaymentServiceImpl();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan seluruh produk");
            System.out.println("2. Tampilkan Produk dalam Keranjang");
            System.out.println("3. Tambah Produk ke Keranjang");
            System.out.println("4. Hapus Produk dari Keranjang");
            System.out.println("5. Lakukan Pembayaran");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shoppingService.displayProducts();
                    break;
                case 2:
                    shoppingService.viewCart();
                    break;
                case 3:
                    System.out.print("Masukkan ID produk: ");
                    int productId = scanner.nextInt();
                    shoppingService.addToCart(productId);
                    break;
                case 4:
                    System.out.print("Masukkan ID produk yang akan dihapus: ");
                    int removeId = scanner.nextInt();
                    shoppingService.removeFromCart(removeId);
                    break;
                case 5:
                    System.out.println("Pilih metode pembayaran:");
                    System.out.println("1. Bank Transfer");
                    System.out.println("2. QRIS");
                    System.out.println("3. E-Wallet");
                    System.out.print("Pilih metode: ");
                    int paymentMethod = scanner.nextInt();
                    paymentService.processPayment(paymentMethod, shoppingService.getTotalPrice());
                    break;
                case 6:
                    System.out.println("Terima kasih telah berbelanja!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 6);

        scanner.close();
    }
}
