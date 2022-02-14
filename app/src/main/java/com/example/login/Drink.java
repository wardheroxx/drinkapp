package com.example.login;

enum DrinkType
{
    whisky,arak,beer,cognac,tequila,vodka,wine,champagne
}

class Drink {
    private String name;
    private String photo;
    private int num;
    private int price;
    private int liters;
    private DrinkType type;

    public Drink() {
    }

    public Drink(String name, String photo, int num, int price, int liters, DrinkType type) {
        this.name = name;
        this.photo = photo;
        this.num = num;
        this.price = price;
        this.liters = liters;
        this.type = type;
    }

    public Drink(String name, String description, String address, String valueOf, String photo, String phone) {

    }

    public static void values(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLiters() {
        return liters;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", liters=" + liters +
                ", type=" + type +
                '}';
    }
}