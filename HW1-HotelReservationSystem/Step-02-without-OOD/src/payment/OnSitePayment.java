package payment;

public class OnSitePayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid on-site: " + amount);
    }
}
