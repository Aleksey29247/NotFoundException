package ru.netology.domain;

import domain.Book;
import domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TryCatchTest {

    Book book1 = new Book(1, "3", 200, "string");
    Book book2 = new Book(3, "3", 200, "string");
    ProductRepository repository = new ProductRepository();

    @Test
    public void removingNonExistentElement() {
        repository.add(book2);
        Assertions.assertThrows(NotFoundException.class, () -> repository.removeByld(5));
    }

    @Test
    public void deletingExistingElement() {
        repository.add(book2);
        repository.add(book1);
        repository.removeByld(3);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }
}
