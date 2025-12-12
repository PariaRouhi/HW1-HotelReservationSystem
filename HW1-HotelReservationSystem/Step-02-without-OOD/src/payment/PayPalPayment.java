package payment;

public class PayPalPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid by PayPal: " + amount);
    }
}
