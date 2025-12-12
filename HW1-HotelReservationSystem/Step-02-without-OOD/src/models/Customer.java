package models;

public class Customer {
    public String name;
    public String email;
    public String city;
    public String mobile;
    public Customer(String name, String email, String mobile, String city){
        this.name = name; this.email = email; this.city = city;this.mobile=mobile;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCity() { return city; }
    public String getMobile() { return mobile; }
}