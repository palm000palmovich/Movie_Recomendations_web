package com.example.TypesObjects;

import java.time.Year;

public class Movie {
    private String director;
    private String genre;
    private int year;

    //Конструктор
    public Movie(String director, String genre, int year){
        this.director = director;
        this.genre = genre;
        this.year = year;
    }

    //Геттеры
    public String getDirector(){
        return this.director;
    }

    public String getGenre(){
        return this.genre;
    }

    public int getYear(){
        return this.year;
    }

    //Сеттеры


    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Вывод информации о фильме

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }



}
