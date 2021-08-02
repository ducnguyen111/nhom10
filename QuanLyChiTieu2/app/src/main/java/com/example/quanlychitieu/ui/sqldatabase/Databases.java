package com.example.quanlychitieu.ui.sqldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databases  extends SQLiteOpenHelper {
    public static final String dbName="chitieu.db";
    public static final int dbVersion=2;

    public Databases (Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableLoaiThu="create table LoaiThu("+
                "maLoaiThu INTERGER not null PRIMARY KEY AUTOINCREMENT,"+
                "tenLoaiThu TEXT NOT NULL)";
        db.execSQL(createTableLoaiThu);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableLoaiThu="drop table if exists LoaiThu";
        db.execSQL(dropTableLoaiThu);
        onCreate(db);
    }
}
