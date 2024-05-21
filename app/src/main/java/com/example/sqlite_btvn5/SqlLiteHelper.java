package com.example.sqlite_btvn5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLiteHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="PMA";
    public static final String SQL_CREATE_PRODUCT="CREATE TABLE Product(\n" +
            "id text PRIMARY KEY,\n" +
            "name text,\n" +
            "price real,\n" +
            "image real);";
    public SqlLiteHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Product;");
    }
}
