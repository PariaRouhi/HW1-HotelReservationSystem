import models.Customer;
import models.Room;
import services.Reservation;
import services.ReservationService;
import payment.*;
import notify.*;
import discount.CityDiscount;
import invoice.ConsoleInvoice;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hotel Reservation System ===\n");

        Customer customer = new Customer("Ali Ahmadi", "ali@email.com", "09123456789", "Paris");
        Room room = new Room("101", "standard", 100.0);
        Reservation reservation = new Reservation(room, customer, 3);

        System.out.println("--- Test 1: Card Payment + Email Notification ---");
        PaymentService cardPayment = new CardPayment();
        NotificationService emailNotif = new EmailNotification();
        DiscountService discount = new CityDiscount();
        InvoiceService invoice = new ConsoleInvoice();

        ReservationService service1 = new ReservationService(
            cardPayment, emailNotif, discount, invoice
        );
        service1.makeReservation(reservation, customer.getEmail());

        System.out.println("\n--- Test 2: OnSite Payment + SMS Notification ---");
        PaymentService onSitePayment = new OnSitePayment();
        NotificationService smsNotif = new SmsNotification();

        ReservationService service2 = new ReservationService(
            onSitePayment, smsNotif, discount, invoice
        );
        
        // 
        room.setPrice(100.0);
        service2.makeReservation(reservation, customer.getMobile());
    }
}