package payment;

public class CashPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid by cash: " + amount);
    }
}
