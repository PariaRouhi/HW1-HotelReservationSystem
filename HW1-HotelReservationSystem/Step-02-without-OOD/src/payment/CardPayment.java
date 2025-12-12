package payment;

public class CardPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid by card: " + amount);
    }
}