package services;

import models.Customer;
import models.Room;

public class Reservation {
    private Customer customer;
    private Room room;
    private int nights;

    public Reservation(Room r, Customer c, int nights) {
        this.room = r;
        this.customer = c;
        this.nights = nights;
    }

    // 1
    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public int getNights() { return nights; }

    // 2
    public double getRoomPrice() { return room.getPrice(); }
    public void setRoomPrice(double price) { room.setPrice(price); }

    public double totalPrice() {
        return room.getPrice() * nights;
    }
}