package models;

public class Room {
    public String number;
    public String type; // "standard" or "luxury"
    public double price;

    public Room(String number, String type, double price){
        this.number = number;
        this.type = type;
        this.price = price;
    }
    public String getNumber() { return number; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
