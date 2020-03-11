package com.erank.shoppinglist.adapters;

import android.view.ViewGroup;
import android.widget.CheckBox;

import com.erank.shoppinglist.R;
import com.erank.shoppinglist.models.Product;

class ProductSelectVH extends ProductVH {

    private final OnCheckProductListener listener;
    private CheckBox checkBox;

    ProductSelectVH(ViewGroup parent, OnCheckProductListener listener) {
        super(parent, R.layout.product_check);
        checkBox = itemView.findViewById(R.id.checkBox);
        this.listener = listener;
    }

    @Override
    void fill(Product product) {
        checkBox.setText(product.name);
        checkBox.setOnCheckedChangeListener((btn, b) -> {
            if (listener != null) {
                listener.onProductChecked(b, product);
            }
        });
    }
}
