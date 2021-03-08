package com.company.Repository;

import com.company.Repository.interfaces.IClientRepository;
import com.company.data.IPostgresDB;
import com.company.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Global {
    public static int id = 0;
}

public class ClientRepository implements IClientRepository {
    private final IPostgresDB database;

    public ClientRepository(IPostgresDB database){this.database = database;}

    @Override
    public List<String> allClients() {
        Connection con = null;
        try {
            List <String> accounts = new ArrayList<String>();
            con = database.getConnection();
            String sql = "Select * FROM clients";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("client_id");
                String email = rs.getString("email");
                accounts.add(id + "   |   " + email + "\n");
            }
            return accounts;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public int getLastId(){
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Select * FROM clients";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int last = 0;
            while(rs.next()){
                int id = rs.getInt("client_id");
                last = id;
            }
            return last;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public int createClient(Client client) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "INSERT INTO clients(client_id, firstName, secondName, email, gender, age, plane_id, hotel_id, tour_id, country_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            int id = getLastId();
            if(id == -1){
                id = 1;
            }
            else{
                id++;
            }
            st.setInt(1, id);
            st.setString(2, client.getFirstName());
            st.setString(3, client.getSecondName());
            st.setString(4, client.getEmail());
            st.setString(5, client.getGender());
            st.setInt(6, client.getAge());
            st.setInt(7, 0);
            st.setInt(8, 0);
            st.setInt(9, 0);
            st.setInt(10, 0);
            st.execute();
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public List<Plane> getAllPlanes(){
        Connection con = null;
        try {
            List <Plane> planes = new ArrayList<Plane>();
            con = database.getConnection();
            String sql = "Select * FROM planes";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Plane pl = new Plane(rs.getInt("id"),
                        rs.getString("company"),
                        rs.getString("model"),
                        rs.getInt("rowcount"),
                        rs.getInt("columncount"),
                        rs.getInt("vmestimost"),
                        rs.getInt("cost"));
                pl.setCost(rs.getInt("cost"));
                planes.add(pl);
            }
            return planes;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Client> getClientsInPlane(int id) {
        Connection con = null;
        try {
            List <Client> clients = new ArrayList<Client>();
            con = database.getConnection();
            String sql = "Select * FROM clients where plane_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Client cl = new Client(rs.getInt("client_id"),
                        rs.getString("firstName"),
                        rs.getString("secondName"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email"));
                clients.add(cl);
            }
            return clients;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean reservePlane(int plane_id, int client_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "UPDATE clients SET plane_id=" + plane_id + " WHERE client_id=" + client_id;
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Tour> getAllTours() {
        Connection con = null;
        try {
            List <Tour> tours = new ArrayList<Tour>();
            con = database.getConnection();
            String sql = "Select * FROM tours";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Tour tr = new Tour(rs.getInt("id"),
                        rs.getString("country"),
                        rs.getString("name"),
                        rs.getInt("days"),
                        rs.getInt("cost"));
                tours.add(tr);
            }
            return tours;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Client> getClientsInTour(int id) {
        Connection con = null;
        try {
            List <Client> clients = new ArrayList<Client>();
            con = database.getConnection();
            String sql = "Select * FROM clients where tour_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Client cl = new Client(rs.getInt("client_id"),
                        rs.getString("firstName"),
                        rs.getString("secondName"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email"));
                clients.add(cl);
            }
            return clients;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean reserveTour(int tour_id, int client_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "UPDATE clients SET tour_id=" + tour_id + " WHERE client_id=" + client_id;
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Hotel> getAllHotels() {
        Connection con = null;
        try {
            List <Hotel> hotels = new ArrayList<Hotel>();
            con = database.getConnection();
            String sql = "Select * FROM hotels";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("hotel_name"));
                Hotel ht = new Hotel(rs.getInt("hotel_id"),
                        rs.getString("hotel_name"),
                        rs.getInt("star"),
                        rs.getString("address"),
                        rs.getDouble("price"),
                        rs.getString("services"),
                        rs.getString("about"),
                        rs.getString("city"),
                        rs.getString("country"));
                hotels.add(ht);
            }
            return hotels;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Client> getClientsInHotel(int id) {
        Connection con = null;
        try {
            List <Client> clients = new ArrayList<Client>();
            con = database.getConnection();
            String sql = "Select * FROM clients where hotel_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Client cl = new Client(rs.getInt("client_id"),
                        rs.getString("firstName"),
                        rs.getString("secondName"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email"));
                clients.add(cl);
            }
            return clients;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean reserveHotel(int hotel_id, int client_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "UPDATE clients SET hotel_id=" + hotel_id + " WHERE client_id=" + client_id;
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Country> getAllCountries() {
        Connection con = null;
        try {
            List <Country> countries = new ArrayList<Country>();
            con = database.getConnection();
            String sql = "Select * FROM countries";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String cities = rs.getString("cities");
                String temp = "";
                List <String> citieslist = new ArrayList<String>();
                for(int i = 0; i < cities.length(); ++i){
                    char ch = cities.charAt(i);
                    if(ch != ','){
                        temp += ch;
                    }
                    else{
                        citieslist.add(temp);
                        temp = "";
                    }
                }
                Country cn = new Country(citieslist,
                        rs.getInt("population"),
                        rs.getInt("rating"));
                cn.setId(rs.getInt("id"));
                countries.add(cn);
            }
            return countries;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean reserveCountry(int country_id, int client_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Update clients SET country_id=" + country_id + " WHERE client_id=" + client_id;
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int calculateClient(int client_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "SELECT * from clients where client_id=" + client_id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int plane_id = 0;
            int hotel_id = 0;
            int tour_id = 0;
            int total = 0;
            if(rs.next()){
                plane_id = rs.getInt("plane_id");
                hotel_id = rs.getInt("hotel_id");
                tour_id = rs.getInt("tour_id");
            }
            else{
                return 0;
            }
            sql = "SELECT * from planes where id=" + plane_id;
            rs = st.executeQuery(sql);
            if(rs.next()){
                total += rs.getInt("cost");
            }
            else{
                return 0;
            }
            sql = "SELECT * from hotels where hotel_id=" + hotel_id;
            rs = st.executeQuery(sql);
            if(rs.next()){
                total += rs.getDouble("price");
            }
            else{
                return 0;
            }
            sql = "SELECT * from tours where id=" + tour_id;
            rs = st.executeQuery(sql);
            if(rs.next()){
                total += rs.getInt("cost");
            }
            else{
                return 0;
            }
            return total;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

}
