package com.example.sqlite_btvn5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Room;

import java.util.List;

public class ProductDAO {

    private  SqlLiteHelper dbHelper;
    private ProductDatabase db;
    private Context context;
    public ProductDAO(Context context) {
        this.context = context;
        dbHelper = new SqlLiteHelper(context);
        db = Room.databaseBuilder(context, ProductDatabase.class, "product_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
    public List<Product> listAll(){
        ProductRepo repo = db.repo();
        return repo.getAll();
    }

    public void deleteAll(Product[] products){
        ProductRepo repo = db.repo();
        repo.deleteAll(products);
    }

    public void insert(Product[] products){
        ProductRepo repo = db.repo();
        repo.insertAll(products);
    }
}
