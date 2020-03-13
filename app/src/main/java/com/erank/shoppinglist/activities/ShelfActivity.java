package com.erank.shoppinglist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.erank.shoppinglist.adapters.Adapter;
import com.erank.shoppinglist.DataSource;
import com.erank.shoppinglist.R;
import com.erank.shoppinglist.models.Type;

public class ShelfActivity extends AppCompatActivity {

    private DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf);

        dataSource = DataSource.getInstance();

        Adapter adapter = new Adapter(Type.SELECTION,dataSource.getProducts());
        adapter.setListener(dataSource::checkProduct);
        adapter.setCheckedItems(dataSource.getCheckedProducts());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_done) {
            doneWithStuff();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void doneWithStuff() {
        dataSource.packStuff();
        setResult(RESULT_OK);
        finish();
    }
}
