package com.codex;

public class Animal {

    private String name;
    private String family;
    private int legs;

    Animal(String name, String family, int legs) {
        this.name = name;
        this.family = family;
        this.legs = legs;
        System.out.println(this.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", legs=" + legs +
                '}';
    }

}
