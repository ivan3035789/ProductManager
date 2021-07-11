package ru.netology.repository;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(1, "The Little Prince", 228, "Antoine de Saint-Exupery");
    private Book secondBook = new Book(2, "The Master and Margarita", 307, "Mikhail Bulgakov");

    @Test
    public void shouldRemoveByID() {
        repository.save(firstBook);
        repository.save(secondBook);
        Product[] expected = new Product[]{secondBook};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
