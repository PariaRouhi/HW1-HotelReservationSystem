package invoice;

import services.Reservation;

public interface InvoiceService {
    void printInvoice(Reservation reservation);
}
