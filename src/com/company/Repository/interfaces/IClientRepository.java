package com.company.Repository.interfaces;

import com.company.controller.Controller;
import com.company.entities.*;

import java.util.List;

public interface IClientRepository {
    List <String> allClients();
    int createClient(Client cur);
    List <Plane> getAllPlanes();
    List <Client> getClientsInPlane(int id);
    boolean reservePlane(int client_id, int plane_id);
    List <Hotel> getAllHotels();
    List <Client> getClientsInHotel(int id);
    boolean reserveHotel(int client_id, int hotel_id);
    List <Tour> getAllTours();
    List <Client> getClientsInTour(int id);
    boolean reserveTour(int client_id, int tour_id);
    List <Country> getAllCountries();
    boolean reserveCountry(int client_id, int country_id);
    int calculateClient(int client_id);
}