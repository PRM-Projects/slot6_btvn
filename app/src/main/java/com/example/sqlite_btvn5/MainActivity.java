package com.example.sqlite_btvn5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.util.StringUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText Pid, name, price;
    Button load, add, update, delete;
    ProductDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        Pid = findViewById(R.id.id);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);

        load = findViewById(R.id.load);
        add = findViewById(R.id.add);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        dao = new ProductDAO(this);
        init(dao.listAll());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product item = (Product) parent.getItemAtPosition(position);
                Pid.setText(String.valueOf(item.getId()));
                name.setText(item.getName());
                price.setText(String.valueOf(item.getPrice()));
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    private void load() {
        if(validate()){
            Toast.makeText(this, "invalidate", Toast.LENGTH_SHORT).show();
            return;
        }
        init(dao.listAll());
    }

    private void update(){
        if(validate()){
            Toast.makeText(this, "invalidate", Toast.LENGTH_SHORT).show();
            return;
        }
        Product updateProduct = buildProduct();
        dao.update(updateProduct);
        Toast.makeText(this, "success update", Toast.LENGTH_SHORT).show();
    }

    private void delete(){
        if(validate()){
            Toast.makeText(this, "invalidate", Toast.LENGTH_SHORT).show();
            return;
        }
        Product deleteProduct = buildProduct();
        dao.delete(deleteProduct);
        Toast.makeText(this, "success delete", Toast.LENGTH_SHORT).show();
    }

    private void add(){
        if(validate()){
            Toast.makeText(this, "invalidate", Toast.LENGTH_SHORT).show();
            return;
        }
        Product addProduct = buildProduct();
        addProduct.setId(0);
        dao.insert(addProduct);
        Toast.makeText(this, "success add", Toast.LENGTH_SHORT).show();
    }

    private Product buildProduct(){
        Product product = new Product();
        product.setId(Integer.parseInt(Pid.getText().toString()));
        product.setName(name.getText().toString());
        product.setPrice(Double.parseDouble(price.getText().toString()));
        return product;
    }

    private boolean validate(){
        return isEmpty(Pid.getText()) && isEmpty(name.getText()) && isEmpty(price.getText());
    }

    private boolean isEmpty(Object obj){
        if (obj == null) {
            return true;
        }
        if(obj instanceof String) {
            return ((String) obj).isEmpty();
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection<?> collection) {
            return collection.isEmpty();
        }
        if (obj instanceof Map<?, ?> map) {
            return map.isEmpty();
        }

        // else
        return false;
    }

    private void init(List<Product> list){
        Adapter adapter = new Adapter(list, this);
        listView.setAdapter(adapter);
    }

//    private Product[] buildProducts(){
//        List<Product> products = new ArrayList<>();
//        Product product1 = new Product();
//        product1.setId("1");
//        product1.setName("name");
//        product1.setPrice(12.3);
//        Product product2 = new Product();
//        product2.setId("2");
//        product2.setName("pro 2");
//        product2.setPrice(12.6);
//        Product product3 = new Product();
//        product3.setId("3");
//        product3.setName("pro 3");
//        product3.setPrice(12.7);
//        products.add(product1);
//        products.add(product2);
//        products.add(product3);
//        return products.toArray(new Product[0]);
//    }
}