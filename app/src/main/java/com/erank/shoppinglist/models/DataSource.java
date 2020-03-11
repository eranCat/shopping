package com.erank.shoppinglist.models;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final DataSource ourInstance = new DataSource();
    private List<Product> products;
    private List<Product> selectedProducts;

    private DataSource() {
        products = new ArrayList<>();
        selectedProducts = new ArrayList<>();
        initProducts();
    }

    public static DataSource getInstance() {
        return ourInstance;
    }

    private void initProducts() {
        products.add(new Product("malk"));
        products.add(new Product("bred"));
        products.add(new Product("oil"));
        products.add(new Product("flawer"));
        products.add(new Product("sowp"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void addProductToCart(Product product) {
        selectedProducts.add(product);
    }

    public void removeFromCart(Product product) {
        selectedProducts.remove(product);
    }

    public void clearCart() {
        selectedProducts.clear();
    }
}
