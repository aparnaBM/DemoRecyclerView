package com.example.demorecyclerview;

public class Product {
    public int id;
    public String name;
    private static int increment = 0;

    public Product(int id,String name) {

        this.id = ++increment;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    protected void setId() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
