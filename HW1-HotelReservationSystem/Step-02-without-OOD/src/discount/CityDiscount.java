package discount;

import services.Reservation;

public class CityDiscount implements DiscountService {
    @Override
    public double applyDiscount(Reservation res) {
        double price = res.getRoomPrice();
        
        if (res.getCustomer().getCity().equalsIgnoreCase("Paris")) {
            System.out.println("Apply city discount for Paris!");
            price *= 0.9;
        }
        
        return price;
    }
}
