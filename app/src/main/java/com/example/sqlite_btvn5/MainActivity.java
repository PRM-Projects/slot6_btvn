package com.example.sqlite_btvn5;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        ProductDAO dao = new ProductDAO(this);

        List<Product> list = dao.listAll();
        dao.deleteAll(list.toArray(new Product[0]));
        dao.insert(buildProducts());
        list = dao.listAll();
        Adapter adapter = new Adapter(list, this);
        listView.setAdapter(adapter);
    }

    private Product[] buildProducts(){
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId("1");
        product1.setName("name");
        product1.setPrice(12.3);
        Product product2 = new Product();
        product2.setId("2");
        product2.setName("pro 2");
        product2.setPrice(12.6);
        Product product3 = new Product();
        product3.setId("3");
        product3.setName("pro 3");
        product3.setPrice(12.7);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        return products.toArray(new Product[0]);
    }
}