package com.example.Egg_Store.model;

public class Egg {
    private int id;
    private String eggType;
    private Double price;

    public Egg(int id, String eggType, Double price) {
        this.id = id;
        this.eggType = eggType;
        this.price = price;
    }

    public Egg(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEggType() {
        return eggType;
    }

    public void setEggType(String eggType) {
        this.eggType = eggType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
