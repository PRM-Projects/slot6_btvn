package com.example.sqlite_btvn5;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ProductRepo {
    @Query("Select * from products")
    List<Product> getAll();
    @Query("Delete from products where id = :id")
    void delete(int id);
    @Delete
    void deleteAll(Product... products);
    @Insert
    void insertAll(Product... products);
}
