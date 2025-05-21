import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseService dbService = new DatabaseServiceImpl();
        ShoppingService shoppingService = new ShoppingServiceImpl(dbService);
        PaymentService paymentService = new PaymentServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            printHeader("ONLINE MARKETING SHOP");
            printMenu();

            System.out.print("Pilih menu [1-6]: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid [1-6]: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            System.out.println("\n" + "-".repeat(50));

            switch (choice) {
                case 1:
                    printSection("Daftar Produk");
                    shoppingService.displayProducts();
                    break;
                case 2:
                    printSection("Keranjang Belanja");
                    shoppingService.viewCart();
                    break;
                case 3:
                    System.out.println("Tambah Produk ke Keranjang");
                    System.out.print("Masukkan ID produk: ");
                    int productId = scanner.nextInt();
                    System.out.print("Masukkan jumlah: ");
                    int quantity = scanner.nextInt();
                    shoppingService.addToCart(productId, quantity);
                    break;
                case 4:
                    System.out.println("Hapus Produk dari Keranjang");
                    System.out.print("Masukkan ID produk yang akan dihapus: ");
                    int removeId = scanner.nextInt();
                    shoppingService.removeFromCart(removeId);
                    break;
                case 5:
                    printSection("Pembayaran");
                    System.out.println("|----------------------------|");
                    System.out.println("| 1 | Bank Transfer          |");
                    System.out.println("| 2 | QRIS                  |");
                    System.out.println("| 3 | E-Wallet              |");
                    System.out.println("|----------------------------|");
                    System.out.print("Pilih metode [1-3]: ");
                    int paymentMethod = scanner.nextInt();

                    double totalAmount = shoppingService.getTotalPrice();
                    paymentService.processPayment(paymentMethod, totalAmount);

                    if (totalAmount > 0) {
                        Order newOrder = orderService.createOrder(
                                ((ShoppingServiceImpl) shoppingService).getCart(),
                                paymentMethod);
                        System.out.println("✅ Order berhasil dibuat dengan ID: " + newOrder.getOrderId());
                    }
                    break;
                case 6:
                    System.out.println("Terima kasih telah berbelanja di Online Marketing Shop!");
                    break;
                default:
                    System.out.println("⚠️ Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println("-".repeat(50));
        } while (choice != 6);

        scanner.close();
    }

    // Fungsi bantu untuk menampilkan header
    private static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.printf("%-25s%25s\n", "", title);
        System.out.println("=".repeat(50));
    }

    // Fungsi bantu untuk menampilkan menu utama
    private static void printMenu() {
        System.out.println("|------------------------------------------------|");
        System.out.println("|                    MENU UTAMA                  |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| 1 | Tampilkan seluruh produk                   |");
        System.out.println("| 2 | Tampilkan produk dalam keranjang           |");
        System.out.println("| 3 | Tambah produk ke keranjang                 |");
        System.out.println("| 4 | Hapus produk dari keranjang                |");
        System.out.println("| 5 | Lakukan pembayaran                         |");
        System.out.println("| 6 | Keluar                                     |");
        System.out.println("|------------------------------------------------|");
    }

    // Fungsi bantu untuk section judul
    private static void printSection(String sectionTitle) {
        System.out.println("\n" + "-".repeat(50));
        System.out.printf(">>> %s <<<\n", sectionTitle.toUpperCase());
        System.out.println("-".repeat(50));
    }
}
