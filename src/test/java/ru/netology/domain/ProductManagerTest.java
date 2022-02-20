package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.domain.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {

    @Test
    void Test10() {
        ProductManager productManager = new ProductManager();
        Book book2 = new Book(3, "3", 200, "string");
        ProductRepository repository = new ProductRepository();
        repository.add(book2);
        boolean status = productManager.matches(book2, "3");
        assertEquals(status, true);

    }

    @Test
    void Test11() {
        Book book = new Book(1, "1", 200, "string1");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "3", 200, "string");
        Product produkt1 = new Product(5, "6", 200);
        book.hashCode();

        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(produkt1);
        ProductManager productManager = new ProductManager(repository);
        Product[] a = productManager.searchBy("6");
        produkt1.hashCode();
        assertEquals(a[1], produkt1);
    }

    @Test
    void Test12() {
        Product product = new Product(2, "uname", 200);
        Product product1 = new Product(2, "uname", 200);
        assertEquals(product, product1);
    }

    @Test
    void Test14() {
        Book product = new Book(2, "uname", 200, "user");
        Book product1 = new Book(2, "uname", 200, "user");
        assertEquals(product, product1);
    }

    @Test
    void Test13() {
        Product product = new Product(2, "uname", 200);
        Book book = new Book(2, "uname", 200, "user");
        Product product1 = new Book();
        if (product instanceof Book) {
            Book book1 = (Book) product1;
            book1.setAuthor("user");
            assertEquals(book, book1);
        }

    }

    @Test
    void Test15() {
        Smartphone product = new Smartphone(2, "uname", 200, "user");
        Smartphone product1 = new Smartphone(2, "uname", 200, "user");
        assertEquals(product, product1);
    }







}