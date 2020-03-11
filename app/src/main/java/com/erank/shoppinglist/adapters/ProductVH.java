package com.erank.shoppinglist.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.erank.shoppinglist.models.Product;

abstract class ProductVH extends RecyclerView.ViewHolder {


    ProductVH(ViewGroup parent, @LayoutRes int layout) {
        super(LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false));
    }

    abstract void fill(Product product);
}
