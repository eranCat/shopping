package com.erank.shoppinglist.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erank.shoppinglist.models.Product;
import com.erank.shoppinglist.models.Type;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ProductVH> {
    private Type type;
    private List<Product> products;
    private OnCheckProductListener listener;

    public Adapter(Type type, List<Product> products) {
        this.type = type;
        this.products = products;
    }

    public Adapter(Type type) {
        this(type, new ArrayList<>());
    }

    public void setListener(OnCheckProductListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (type) {
            case PREVIEW:
                return new ProductPreviewVH(parent);
            case SELECTION:
                return new ProductSelectVH(parent, listener);
            default:
                throw new IllegalArgumentException();
        }
    }


    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Product product = products.get(position);
        holder.fill(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setList(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }
}
