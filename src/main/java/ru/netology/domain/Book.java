package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    @Override
    public boolean equals(Object o) {
        return true;


    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}
