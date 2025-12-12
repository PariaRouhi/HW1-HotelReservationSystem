package discount;

import services.Reservation;

public interface DiscountService {
    double applyDiscount(Reservation reservation);
}
