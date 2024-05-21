package com.example.sqlite_btvn5;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Product.class, version = 2)
abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductRepo repo();
}
