package no.chris;

import java.time.LocalDateTime;

public class Book {

    private int id;
    private String name;
    private String author;
    private LocalDateTime date;

    public Book(int id, String name, String author, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
