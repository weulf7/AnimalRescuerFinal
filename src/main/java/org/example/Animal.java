package org.example;

public class Animal {
    String name;
    int age;
    int healthState;
    int hungerState;
    int spiritState;
    String favoriteFood;
    String favoriteActivity;
    String type;


    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealthState() {
        return healthState;
    }

    public void setHealthState(int healthState) {
        this.healthState = healthState;
    }

    public int getHungerState() {
        return hungerState;
    }

    public void setHungerState(int hungerState) {
        this.hungerState = hungerState;
    }

    public int getSpiritState() {
        return spiritState;
    }

    public void setSpiritState(int spiritState) {
        this.spiritState = spiritState;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }
}
