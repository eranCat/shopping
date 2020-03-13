package com.erank.shoppinglist;

import com.erank.shoppinglist.models.Product;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final DataSource ourInstance = new DataSource();
    private List<Product> products;
    private List<Product> selectedProducts;
    private boolean[] checkedProducts;

    private DataSource() {
        products = new ArrayList<>();
        selectedProducts = new ArrayList<>();
        initProducts();
    }

    public static DataSource getInstance() {
        return ourInstance;
    }

    public boolean[] getCheckedProducts() {
        return checkedProducts;
    }

    private void initProducts() {
        products.add(new Product("milk"));
        products.add(new Product("bread"));
        products.add(new Product("oil"));
        products.add(new Product("flower"));
        products.add(new Product("soap"));
        products.add(new Product("tomatoes"));
        products.add(new Product("potatoes"));
        products.add(new Product("rice"));
        products.add(new Product("cereal"));
        products.add(new Product("sugar"));
        products.add(new Product("salt"));

        checkedProducts = new boolean[products.size()];
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void checkProduct(boolean isChecked, int pos) {
        checkedProducts[pos] = isChecked;
    }

    public void packStuff() {
        selectedProducts.clear();
        for (int i = 0; i < checkedProducts.length; i++) {
            if (checkedProducts[i])
                selectedProducts.add(products.get(i));
        }
    }
}
