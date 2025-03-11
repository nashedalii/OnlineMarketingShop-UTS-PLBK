public class PaymentServiceImpl implements PaymentService {
    @Override
    public void processPayment(int method, double amount) {
        if (amount == 0) {
            System.out.println("Keranjang belanja kosong. Tidak ada pembayaran yang dilakukan.");
            return;
        }

        switch (method) {
            case 1:
                System.out.println("Pembayaran sebesar Rp " + amount + " melalui Bank Transfer berhasil.");
                break;
            case 2:
                System.out.println("Pembayaran sebesar Rp " + amount + " melalui QRIS berhasil.");
                break;
            case 3:
                System.out.println("Pembayaran sebesar Rp " + amount + " melalui E-Wallet berhasil.");
                break;
            default:
                System.out.println("Metode pembayaran tidak valid.");
        }
    }
}
