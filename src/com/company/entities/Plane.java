package com.company.entities;

public class Plane {
    int id;
    String company;
    String model;
    int rowcount;
    int columncount;
    int vmestimost;
    int cost;
    public Plane(){
        cost = 0;
        company = "";
        rowcount = 0;
        columncount = 0;
        vmestimost = 0;
    }
    public Plane(int id, String company, String model, int rowcount, int columncount, int vmestimost, int cost){
        this.id = id;
        this.model = model;
        this.company = company;
        this.rowcount = rowcount;
        this.columncount = columncount;
        this.vmestimost = vmestimost;
    }
    public String getCompany(){
        return company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRowcount(){
        return rowcount;
    }
    public int getVmestimost(){
        return vmestimost;
    }
    public int getColumncount(){
        return columncount;
    }
    public int getCost(){
        return cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompany(String company){
        this.company = company;
    }
    public void setRowcount(int rowcount){
        this.rowcount = rowcount;
    }
    public void setColumncount(int columncount){
        this.columncount = columncount;
    }
    public void setVmestimost(int vmestimost){
        this.vmestimost = vmestimost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", rowcount=" + rowcount +
                ", columncount=" + columncount +
                ", vmestimost=" + vmestimost +
                ", cost=" + cost +
                '}' + '\n';
    }
}
