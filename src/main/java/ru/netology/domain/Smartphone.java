package ru.netology.domain;

import ru.netology.domain.repository.ProductRepository;

import java.util.Objects;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return id == that.id && price == that.price && Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    public static class ProductManager {
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
}
