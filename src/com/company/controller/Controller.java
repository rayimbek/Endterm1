package com.company.controller;

import com.company.Repository.interfaces.IClientRepository;
import com.company.entities.*;

import java.util.List;

public class Controller {
    private final IClientRepository repo;

    public Controller(IClientRepository repo) {
        this.repo = repo;
    }

    public String allClients(){
        List <String> Clients = repo.allClients();
        return Clients.toString();
    }

    public int createClient(Client cur){
        int created = repo.createClient(cur);
        if(created == -1){
            System.out.println("Creation failed!");
        }
        else{
            System.out.println("Created successfully!");
        }
        return created;
    }

    public String getAllPlanes(){
        List <Plane> Planes = repo.getAllPlanes();
        return Planes.toString();
    }

    public String getClientsInPlane(int id){
        List <Client> Clients = repo.getClientsInPlane(id);
        return Clients.toString();

    }

    public String reservePlane(int client_id, int plane_id){
        boolean response = repo.reservePlane(client_id, plane_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String getAllHotels(){
        List <Hotel> Hotels = repo.getAllHotels();
        return Hotels.toString();
    }

    public String getClientsInHotel(int id){
        List <Client> Clients = repo.getClientsInHotel(id);
        return Clients.toString();

    }

    public String reserveHotel(int client_id, int hotel_id){
        boolean response = repo.reserveHotel(client_id, hotel_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String getAllTours(){
        List <Tour> Tours = repo.getAllTours();
        return Tours.toString();
    }

    public String getClientsInTour(int id){
        List <Client> Clients = repo.getClientsInTour(id);
        return Clients.toString();

    }

    public String reserveTour(int client_id, int tour_id){
        boolean response = repo.reserveTour(client_id, tour_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String getAllCountries(){
        List <Country> Countries = repo.getAllCountries();
        return Countries.toString();
    }

    public String reserveCountry(int client_id, int country_id){
        boolean response = repo.reserveCountry(client_id, country_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String calculateClient(int client_id){
        int res = repo.calculateClient(client_id);
        return "Needed money: " + res;
    }
}
