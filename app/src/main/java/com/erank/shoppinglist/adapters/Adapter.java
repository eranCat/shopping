package com.erank.shoppinglist.adapters;

import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erank.shoppinglist.R;
import com.erank.shoppinglist.models.Product;
import com.erank.shoppinglist.models.Type;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ProductVH> {
    private Type type;
    private List<Product> products;
    private OnCheckProductListener listener;
    private boolean[] checkedItems;

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
                return new ProductSelectVH(parent);
            default:
                throw new IllegalArgumentException();
        }
    }


    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Product product = products.get(position);
        holder.fill(product, position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setList(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public void setCheckedItems(boolean[] checkedItems) {
        this.checkedItems = checkedItems;
    }

    class ProductSelectVH extends ProductVH {

        private CheckBox checkBox;

        ProductSelectVH(ViewGroup parent) {
            super(parent, R.layout.product_check);
            checkBox = itemView.findViewById(R.id.checkBox);
        }

        @Override
        void fill(Product product, int pos) {
            checkBox.setText(product.name);
            checkBox.setChecked(checkedItems[pos]);
            checkBox.setOnCheckedChangeListener((btn, b) -> {
                if (btn.isPressed()) {
                    if (listener != null) {
                        listener.onProductChecked(b, pos);
                    }

                    checkedItems[pos] = b;
                }
            });
        }
    }
}
