package org.example;

public class Cat extends Animal{
    String name;
    String breed;
    String favoriteActivity="Playing with a ball";
    String favoriteFood="Milk";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
