package services;

import payment.PaymentService;
import notify.NotificationService;
import discount.DiscountService;
import invoice.InvoiceService;

public class ReservationService {
    private PaymentService paymentService;
    private NotificationService notificationService;
    private DiscountService discountService;
    private InvoiceService invoiceService;

    // Dependency Injection through constructor
    public ReservationService(PaymentService paymentService,
                            NotificationService notificationService,
                            DiscountService discountService,
                            InvoiceService invoiceService) {
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.discountService = discountService;
        this.invoiceService = invoiceService;
    }

    public void makeReservation(Reservation res, String recipientInfo) {
        System.out.println("Processing reservation for " + res.getCustomer().getName());

        // Apply discount
        double discountedPrice = discountService.applyDiscount(res);
        res.setRoomPrice(discountedPrice);

        // Process payment
        paymentService.processPayment(res.totalPrice());

        // Print invoice
        invoiceService.printInvoice(res);

        // Send notification
        notificationService.sendNotification(recipientInfo, "Your reservation confirmed!");
    }
}