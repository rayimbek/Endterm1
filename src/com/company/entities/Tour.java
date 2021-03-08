package com.company.entities;

public class Tour {
    int id;
    int days;
    int cost;
    String country;
    String name;
    public Tour(){
        days = 0;
        country = "";
        cost = 0;
        name = "";
        id = 0;
    }
    public Tour(int id, String country, String name, int days, int cost){
        this.id = id;
        this.country = country;
        this.days = days;
        this.cost = cost;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDays() {
        return days;
    }

    public String getCountry() {
        return country;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCountry(String city) {
        this.country = country;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", days=" + days +
                ", cost=" + cost +
                ", country='" + country + '\'' +
                '}' + '\n';
    }
}
