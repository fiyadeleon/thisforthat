package com.example.kenneth.thisforthat;

public class IngredientsHolder {
    String name;
    String subName;
    int admin;

    public IngredientsHolder(String name, String subName, String admin) {
        this.name = name;
        this.subName = subName;
        this.admin = Integer.valueOf(admin);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return subName;
    }

    public int getAdmin() {
        return admin;
    }
}