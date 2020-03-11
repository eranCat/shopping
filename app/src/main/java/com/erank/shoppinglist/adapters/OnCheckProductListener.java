package com.erank.shoppinglist.adapters;

import com.erank.shoppinglist.models.Product;

public interface OnCheckProductListener {
    void onProductChecked(boolean isChecked, Product product);
}
