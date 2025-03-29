package pl.pjatk.danmak.components;

public class Car {
    private int id;
    private String vim;
    private String brand;
    private String model;

    public Car(){}
    public Car(int id, String vim, String brand, String model){
        this.id = id;
        this.vim = vim;
        this.brand = brand;
        this.model = model;
    }

    public String getVim() {
        return vim;
    }

    public void setVim(String vim) {
        this.vim = vim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
