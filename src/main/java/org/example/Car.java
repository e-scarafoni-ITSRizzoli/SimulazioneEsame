package org.example;
import com.google.gson.Gson;
public class Car {
    String brand;
    int id;
    double price;
    int qty;

    public Car(int id, String brand, double price, int qty) {
        this.brand = brand;
        this.id = id;
        this.price = price;
        this.setQty(qty);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        if(qty<0) {
            this.qty = 0;
        }
        else {
            this.qty = qty;
        }
    }

    public String asJSON() {
        Gson g = new Gson();
        String toJson = g.toJson(this);
        return toJson;
    }
}
