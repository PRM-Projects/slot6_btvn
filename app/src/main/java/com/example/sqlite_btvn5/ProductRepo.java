package com.example.sqlite_btvn5;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.sqlite_btvn5.Product;

import java.util.List;
@Dao
public interface ProductRepo {
    @Query("Select * from products")
    List<Product> getAll();
    @Query("Select * from products where id = :id")
    Product getOne(int id);
    @Delete
    void deleteAll(Product... products);
    @Insert
    void insertAll(Product... products);
    @Update
    void updateAll(Product... products);
}
