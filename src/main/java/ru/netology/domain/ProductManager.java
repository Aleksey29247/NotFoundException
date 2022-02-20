package ru.netology.domain;


import ru.netology.domain.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;

    }

    public ProductManager() {
        this.repository = new ProductRepository();
    }

    public Product[] searchBy(String text) {
        int i = 0;
        Product[] result = new Product[2]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                i++;
                result[i] = product;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

}
