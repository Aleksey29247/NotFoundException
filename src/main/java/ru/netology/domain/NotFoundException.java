package ru.netology.domain;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super("Element with id: " + s + " not found");
    }
}