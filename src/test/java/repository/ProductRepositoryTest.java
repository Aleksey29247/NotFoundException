
package repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


public class ProductRepositoryTest {


    @Test
    public void Test1() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book1, book2, smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void Test2() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        assertEquals(smartphone, repository.findByld(4));

    }

    @Test
    public void Test3() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        assertEquals(book2, repository.findByld(3));

    }

    @Test
    public void Test4() {
        Book book = new Book(1, "2", 200, "string");
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        repository.removeByld(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book2, smartphone};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void Test5() {
        Book book = new Book();
        Book book1 = new Book(2, "2", 200, "string");
        Book book2 = new Book(3, "2", 200, "string");
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        ProductRepository repository = new ProductRepository();
        book.setId(1);
        book.setName("2");
        book.setPrice(200);
        book.setAuthor("TEXT");
        repository.add(book);
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone);
        repository.removeByld(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, book2, smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void Test6() {
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        Smartphone smartphone1 = new Smartphone();
        ProductRepository repository = new ProductRepository();
        smartphone1.setId(1);
        smartphone1.setName("2");
        smartphone1.setPrice(200);
        smartphone1.setManufacturer("TEXT");
        repository.add(smartphone);
        repository.add(smartphone1);
        assertEquals(smartphone1.getManufacturer(), "TEXT");
    }

    @Test
    public void Test7() {
        Smartphone smartphone = new Smartphone(4, "5", 210, "str");
        Smartphone smartphone1 = new Smartphone();
        ProductRepository repository = new ProductRepository();
        smartphone1.setId(1);
        smartphone1.setName("2");
        smartphone1.setPrice(200);
        smartphone1.setManufacturer("TEXT");
        repository.add(smartphone);
        repository.add(smartphone1);
        assertEquals(smartphone1.getPrice(), 200);
    }

    @Test
    public void Test8() {

        Smartphone smartphone1 = new Smartphone();
        ProductRepository repository = new ProductRepository();
        smartphone1.setId(1);
        smartphone1.setName("2");
        smartphone1.setPrice(200);
        smartphone1.hashCode();
        smartphone1.setManufacturer("TEXT");
        repository.add(smartphone1);
        assertEquals(smartphone1.getName(), "2");
    }
    @Test
    public void Test9() {
        Smartphone smartphone = new Smartphone(4, "5", 250, "str");
        Smartphone smartphone1 = new Smartphone();
        ProductRepository repository = new ProductRepository();
        smartphone1.setId(1);
        smartphone1.setName("3");
        smartphone1.setPrice(210);
        smartphone1.setManufacturer("TEXT");
        repository.add(smartphone);
        repository.add(smartphone1);
        assertEquals(smartphone1.getPrice(), 210);
    }
}



