package com.erank.shoppinglist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.erank.shoppinglist.adapters.Adapter;
import com.erank.shoppinglist.DataSource;
import com.erank.shoppinglist.R;
import com.erank.shoppinglist.models.Type;

public class MainActivity extends AppCompatActivity {

    public static final int RC_SELECT = 1;
    private Adapter adapter;
    private DataSource ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ds = DataSource.getInstance();

        RecyclerView productsRV = findViewById(R.id.recyclerView);
        adapter = new Adapter(Type.PREVIEW);
        productsRV.setAdapter(adapter);

        View selectButton = findViewById(R.id.select);
        selectButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ShelfActivity.class);
            startActivityForResult(intent, RC_SELECT);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SELECT && resultCode == RESULT_OK) {
            adapter.setList(ds.getSelectedProducts());
        }
    }
}
