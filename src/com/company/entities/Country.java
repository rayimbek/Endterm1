package com.company.entities;

import java.util.List;

public class Country {
    int id;
    List< String > cities;
    int population;
    double rating;
    public Country(){
        population = 0;
        rating = 0;
    }
    public Country(List < String > cities, int population, double rating){
        this.id = id;
        this.cities = cities;
        this.population = population;
        this.rating = rating;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getCities() {
        return cities;
    }

    public double getRating() {
        return rating;
    }

    public int getPopulation() {
        return population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", cities=" + cities +
                ", population=" + population +
                ", rating=" + rating +
                '}' + '\n';
    }
}
