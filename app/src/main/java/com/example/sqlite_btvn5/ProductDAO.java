package com.example.sqlite_btvn5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Room;

import java.util.List;

public class ProductDAO {

    private  SqlLiteHelper dbHelper;
    private ProductDatabase db;
    private Context context;
    private ProductRepo repo;
    public ProductDAO(Context context) {
        this.context = context;
        dbHelper = new SqlLiteHelper(context);
        db = Room.databaseBuilder(context, ProductDatabase.class, "product_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        repo = db.repo();
    }

    public Product getOne(int id){
        return repo.getOne(id);
    }
    public void update(Product... products){
        repo.updateAll(products);
    }
    public List<Product> listAll(){
        return repo.getAll();
    }

    public void delete(Product... products){
        repo.deleteAll(products);
    }

    public void insert(Product... products){
        repo.insertAll(products);
    }

}
