package com.objectivemonsters.consumables;

public class Item {
    private String name;
    // TODO: comment here
    private String type;
    // in advanced versions, too much weight will limit amount can carry
    private int weight;

    // constructor

    public Item(String name, String type, int weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    //tailored toString

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }
}
