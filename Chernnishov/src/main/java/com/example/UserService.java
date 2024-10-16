package com.example;

import com.example.Exceptions.*;
import com.example.TypesObjects.Movie;
import com.example.TypesObjects.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<Movie> bestmovieList = new ArrayList<>();  //Лучшие фильмы
    private List<Movie> watchLaterMovieList = new ArrayList<>(); //Смотреть позже
    private User user;
    private List<String> onlyAdult = List.of("боевик", "ужасы"
            , "криминал", "Романтическая комедия"); //Цензура

    //Библиотека фильмов
    private final List<Movie> moviesList  = List.of(new Movie("Ричард Фейнман", "Боевик", 2004),
                new Movie("Ричи", "Комедия", 1998),
                new Movie("Нолан", "Научная фантастика", 2010),
                new Movie("Тарантино", "Драма", 1994),
                new Movie("Кубрик", "Ужасы", 1980),
                new Movie("Джексон", "Фэнтези", 2001),
                new Movie("Коппола", "Комедия", 2003),
                new Movie("Торо", "Фэнтези", 2006),
                new Movie("Кэмерон", "Экшен", 1997),
                new Movie("Бертон", "Мультфильм", 1993),
                new Movie("Спилберг", "Приключения", 1993),
                new Movie("Нолан", "Научная фантастика", 2010),
                new Movie("Джексон", "Фэнтези", 2001),
                new Movie("Тарантино", "Криминал", 1994),
                new Movie("Пил", "Ужасы", 2017),
                new Movie("Эдвардс", "Научная фантастика", 2014),
                new Movie("Фавро", "Комедия", 2016),
                new Movie("Скотт", "Научная фантастика", 1979),
                new Movie("Скорсезе", "Драма", 1990),
                new Movie("Коппола", "Драма", 2003),
                new Movie("Кубрик", "Научная фантастика", 1968),
                new Movie("Коппола", "Драма", 1972),
                new Movie("Тарантино", "Криминал", 1994),
                new Movie("Нолан", "Научная фантастика", 2010),
                new Movie("Лукас", "Фэнтези", 1977),
                new Movie("Джексон", "Приключения", 2001),
                new Movie("Торо", "Фэнтези", 2006),
                new Movie("Финчер", "Триллер", 1999),
                new Movie("Аллен", "Комедия", 1977),
                new Movie("Дарденн", "Драма", 1999),
                new Movie("Триер", "Драма", 2000),
                new Movie("Бёртон", "Фэнтези", 1990),
                new Movie("МакДона", "Комедия", 2008),
                new Movie("Нолан", "Научная фантастика", 2014),
                new Movie("Спилберг", "Приключения", 1993),
                new Movie("Пэйн", "Комедия", 2004),
                new Movie("Лурман", "Музыкальный", 2001),
                new Movie("Кустурица", "Драма", 1995),
                new Movie("Эдвардс", "Научная фантастика", 2018),
                new Movie("Хо", "Триллер", 2019),
                new Movie("Кроу", "Романтическая комедия", 2000));


    //Геттеры для всего
    public List<Movie> getBestmovieList() {
        return bestmovieList;
    }

    public List<Movie> getWatchLaterMovieList() {
        return watchLaterMovieList;
    }

    public User getUser() {
        return user;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public List<String> getOnlyAdult() {
        return onlyAdult;
    }

    //Стартовый экран
    public String ptintIntro() {
        return "Сперва давайте введем любимый(е) фильм(ы) пользователя - /bestFilm" +
                " и список 'Посмотреть позже' - /watchLater";
    }

    //Любимые фильмы пользователя
    public String bestFilms(String director, String genre, int year)
            throws FilmAlreadyAddedException {
        //В записи автора не должно быть чисел, и он должен быть введен
        if (StringUtils.isNotEmpty(director) && !director.chars().anyMatch(Character::isDigit)) {
            String director1 = StringUtils.capitalize(director);  //Все ФИО авторов начинаются с заглавной буквы

            List<Movie> msBest = new ArrayList<>();
            Movie newMov = new Movie(director1, genre, year);
            if (!msBest.contains(newMov)) {
                msBest.add(newMov);
            } else {
                throw new FilmAlreadyAddedException("Этот фильм уже есть!");
            }
            this.bestmovieList = msBest;
            return "Фильм успешно добавлен!";
        }
        throw new IncorrectDirectorException("Некорректное имя автора!");
    }


    // фильмы "Смотреть позже"
    public String watchLaterFilms(String director, String genre, int year)
            throws FilmAlreadyAddedException {
        //В записи автора не должно быть чисел, и он должен быть введен
        if (StringUtils.isNotEmpty(director) && !director.chars().anyMatch(Character::isDigit)) {
            String director1 = StringUtils.capitalize(director);  //Все ФИО авторов начинаются с заглавной буквы

            List<Movie> msLater = new ArrayList<>();
            Movie newMov = new Movie(director1, genre, year);
            if (!msLater.contains(newMov)) {
                msLater.add(newMov);
            } else {
                throw new FilmAlreadyAddedException("Этот фильм уже есть!");
            }
            this.watchLaterMovieList = msLater;
            return "Фильм успешно добавлен!";
        }
        throw new IncorrectDirectorException("Некорректное имя автора!");
    }


    //Все указанные фильмы
    public String allMovies() throws FilmsArentAddedException {
        if (!bestmovieList.isEmpty() && !watchLaterMovieList.isEmpty()) {
            return "Любимые фильмы пользователя: " + bestmovieList.toString()
                    + "\n\nСмотреть позже: " + watchLaterMovieList.toString();
        } else if (watchLaterMovieList.isEmpty()) {
            return "Любимые фильмы пользователя: " + bestmovieList.toString();
        } else if (bestmovieList.isEmpty()) {
            return "Смотреть позже: " + watchLaterMovieList.toString();
        }
        throw new FilmsArentAddedException("База данных фильмов пуста!");
    }

    //Запись пользователя
    public String writeUser(int age){
        User usr = new User(age, this.getBestmovieList(), this.getWatchLaterMovieList());
        this.user = usr;
        return "Пользователь успешно записан!";
    }

    //Вывод информации о пользователе
    public String printUser() {
        return this.user.toString();

    }

    //Вывод библиотеки фильмов
    public List<Movie> moviesLibrary() {
        return moviesList;
    }


    //Система рекоменаций
    public String recommendations() {

        //Все данные
        User nashSlon = this.getUser();
        List<Movie> hosting  = this.getMoviesList();
        List<Movie> best = this.getBestmovieList();
        List<Movie> later = this.getWatchLaterMovieList();
        List<String> cens = this.getOnlyAdult();


        //любимый жанр
        String bestGenre = bestmovieList.get(0).getGenre();

        //любимый автор
        String bestAuthor = bestmovieList.get(0).getDirector();



        //Список рекомендаций
        List<Movie> recs = new ArrayList<>();

        //Сперва проверка на малолетку
        if (nashSlon.getAge() < 18){
            for (int i = 0; i < hosting.size(); i++) {
                if (bestGenre.equals(hosting.get(i).getGenre())
                        || bestAuthor.equals(hosting.get(i).getDirector())){
                    if (!cens.contains(hosting.get(i).getGenre())){recs.add(hosting.get(i));}
                }
            }
        } else{
            for (int i = 0; i < hosting.size(); i++) {
                if (bestGenre.equals(hosting.get(i).getGenre())
                        || bestAuthor.equals(hosting.get(i).getDirector())){
                    recs.add(hosting.get(i));
                }
            }
        }
        return recs.toString();
    }

}
