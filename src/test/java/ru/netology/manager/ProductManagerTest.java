package ru.netology.manager;
import ru.netology.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "The Master and Margarita", 500, "Mikhail Bulgakov");
    private Book secondBook = new Book(2, "A dog's heart", 1000, "Mikhail Bulgakov");
    private Smartphone firstSmartphone = new Smartphone(3, "6.1", 59_000, "samsung");
    private Smartphone secondSmartphone = new Smartphone(4, "5.0", 17_000, "samsung");


    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);

    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookAuthor() {
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = manager.searchBy("Mikhail Bulgakov");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("The Master and Margarita");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneManufacturer() {
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone};
        Product[] actual = manager.searchBy("samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("5.0");
        assertArrayEquals(expected, actual);
    }
}
