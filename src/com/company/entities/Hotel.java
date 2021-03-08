package com.company.entities;

import com.sun.source.tree.UsesTree;

public class Hotel {
    int id;
    int star;
    String address;
    String hotel_name;
    double price;
    String services;
    String about;
    String city;
    String country;
    public Hotel(){
        address = "";
        hotel_name = "";
        services = "";
        about = "";
        city = "";
        country = "";
        price = 0;
        star = 0;
        id = 0;
    }
    public Hotel(int id, String hotel_name, int star,String address, double price, String services, String about, String city, String country){
        this.id = id;
        this.hotel_name = hotel_name;
        this.star = star;
        this.address = address;
        this.price = price;
        this.services = services;
        this.about = about;
        this.city = city;
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public double getPrice() {
        return price;
    }

    public int getStar() {
        return star;
    }

    public String getAbout() {
        return about;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public String getServices() {
        return services;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + id +
                ", star=" + star +
                ", address='" + address + '\'' +
                ", hotel_name='" + hotel_name + '\'' +
                ", price=" + price +
                ", services='" + services + '\'' +
                ", about='" + about + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}' + '\n';
    }
}
