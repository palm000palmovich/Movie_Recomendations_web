package com.example.TypesObjects;

import java.util.List;

public class User {
    private int age;
    private List<Movie> bestFilms;
    private List<Movie> watchLater;


    //Конструктор
    public User(int age, List<Movie> bestFilms, List<Movie> watchLater) {
        this.age = age;
        this.bestFilms = bestFilms;
        this.watchLater = watchLater;
    }

    //Геттеры и сеттеры


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getBestFilms() {
        return bestFilms;
    }

    public void setBestFilms(List<Movie> bestFilms) {
        this.bestFilms = bestFilms;
    }

    public List<Movie> getWatchLater() {
        return watchLater;
    }

    public void setWatchLater(List<Movie> watchLater) {
        this.watchLater = watchLater;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", bestFilms=" + bestFilms +
                ", watchLater=" + watchLater +
                '}';
    }

}
