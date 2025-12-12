package invoice;

import services.Reservation;

public class ConsoleInvoice implements InvoiceService {
    @Override
    public void printInvoice(Reservation res) {
        System.out.println("----- INVOICE -----");
        System.out.println("Customer: " + res.getCustomer().getName());
        System.out.println("Room: " + res.getRoom().getNumber() + 
                         " (" + res.getRoom().getType() + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");
    }
}
