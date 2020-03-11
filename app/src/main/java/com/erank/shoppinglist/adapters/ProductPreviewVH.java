package com.erank.shoppinglist.adapters;

import android.view.ViewGroup;
import android.widget.TextView;

import com.erank.shoppinglist.R;
import com.erank.shoppinglist.models.Product;

class ProductPreviewVH extends ProductVH {

    private TextView name;

    ProductPreviewVH(ViewGroup parent) {
        super(parent, R.layout.product);
        name = itemView.findViewById(R.id.name);
    }

    @Override
    void fill(Product product) {
        name.setText(product.name);
    }
}
