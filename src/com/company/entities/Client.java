package com.company.entities;

public class Client {
    int id;
    String firstName;
    String secondName;
    String email;
    int age;
    String gender;
    int planeID;
    int countryID;
    int hotelID;
    int tourID;
    public Client(){
        firstName = "";
        secondName = "";
        age = 0;
        gender = "";
        email = "";
    }
    public Client(int id, String firstName, String secondName, int age, String gender, String email){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
    public Client(String firstName, String secondName, int age, String gender, String email){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryID() {
        return countryID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getPlaneID() {
        return planeID;
    }

    public int getTourID() {
        return tourID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}' + '\n';
    }
}
