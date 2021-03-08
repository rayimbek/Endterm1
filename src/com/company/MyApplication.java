package com.company;

import com.company.entities.*;
import com.company.controller.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MyApplication {
    private final Controller controller;
    private final Scanner scanner;

    public MyApplication(Controller controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Welcome to our travel booking Application");
        System.out.println("Please enter 1 if you already have an account");
        System.out.println("Please enter 2 if you want to register");
        int opt = scanner.nextInt();
        int id = 0;
        scanner.nextLine();
        if(opt == 1) {
            String res = allClientsMenu();
            System.out.println(res);
            System.out.println("Select an account");
            id = scanner.nextInt();
            scanner.nextLine();
        }
        else {
            id = createClientMenu();
        }
        while(true){
            System.out.println();
            System.out.println("Select option: (1-5)");
            System.out.println("Enter 1 if you want to book/reserve plane");
            System.out.println("Enter 2 if you want to book/reserve hotel");
            System.out.println("Enter 3 if you want to select tour");
            System.out.println("Enter 4 if you want to select country");
            System.out.println("Enter 5 if you want to calculate the money needed");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (0-5)");
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option == 1){
                    reservePlaneMenu(id);
                }
                else if(option == 2){
                    reserveHotelMenu(id);
                }
                else if(option == 3){
                    reserveTourMenu(id);
                }
                else if(option == 4){
                    reserveCountryMenu(id);
                }
                else if(option == 5){
                    calculateClientMenu(id);
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("----------------------------------------");
        }
    }

    public String allClientsMenu(){
        System.out.println("Here is the list of accounts: ");
        String res = controller.allClients();
        return res;
    }

    public int createClientMenu(){
        System.out.println("Please give some information about yourself, please");
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        System.out.println("Please enter surname");
        String surname = scanner.nextLine();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter gender");
        String gender = scanner.nextLine();
        System.out.println("Please enter email");
        String email = scanner.nextLine();
        Client cur = new Client(name, surname, age, gender, email);
        int id = controller.createClient(cur);
        System.out.println(id);
        return id;
    }

    public void reservePlaneMenu(int id){
        System.out.println("Enter 1 if you want to see the Planes list");
        System.out.println("Enter 2 if you want to see the passengers list in exact Plane");
        System.out.println("Enter 3 if you want to book the Plane");
        System.out.println("Enter 0 if you want to exit");
        try {
            int option = -1;
            while(option != 2 || option != 3 || option != 0) {
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllPlanes();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of plane");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.getClientsInPlane(curid);
                    System.out.println(response);
                } else if (option == 3) {
                    System.out.println("Please enter id of plane");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reservePlane(curid, id);
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void reserveHotelMenu(int id){
        System.out.println("Enter 1 if you want to see the Hotels list");
        System.out.println("Enter 2 if you want to see the clients list in exact Hotel");
        System.out.println("Enter 3 if you want to book the Hotel");
        System.out.println("Enter 0 if you want to exit");
        try {
            int option = -1;
            while(option != 2 || option != 3 || option != 0) {
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllHotels();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of hotel");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.getClientsInHotel(curid);
                    System.out.println(response);
                } else if (option == 3) {
                    System.out.println("Please enter id of hotel");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reserveHotel(curid, id);
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void reserveTourMenu(int id){
        System.out.println("Enter 1 if you want to see the Tours list");
        System.out.println("Enter 2 if you want to see the clients list in Tour");
        System.out.println("Enter 3 if you want to select the Tour");
        System.out.println("Enter 0 if you want to exit");
        try {
            int option = -1;
            while(option != 2 || option != 3 || option != 0) {
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllTours();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of tour");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.getClientsInTour(curid);
                    System.out.println(response);
                } else if (option == 3) {
                    System.out.println("Please enter id of tour");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reserveTour(curid, id);
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void reserveCountryMenu(int id){
        System.out.println("Enter 1 if you want to see the Countries list");
        System.out.println("Enter 2 if you want to select the Country");
        System.out.println("Enter 0 if you want to exit");
        try {
            int option = -1;
            while(option != 2 || option != 0) {
                System.out.println("Enter the option: (0 - 2)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllCountries();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of country");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reserveCountry(curid, id);
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 2!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void calculateClientMenu(int id){
        String response = controller.calculateClient(id);
        System.out.println(response);
    }

}
