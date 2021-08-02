package com.example.quanlychitieu.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Database;

import com.example.quanlychitieu.ui.dto.LoaiThu;
import com.example.quanlychitieu.ui.sqldatabase.Databases;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuDao {
    Databases databases;
    SQLiteDatabase db;

    public LoaiThuDao(Context context) {
        databases=new Databases(context);
        db=databases.getWritableDatabase();
    }
    public long insert(LoaiThu loaiThu){
        ContentValues contentValues=new ContentValues();
        contentValues.put("maLoaiThu",loaiThu.maLoaiThu);
        contentValues.put("tenLoaiThu",loaiThu.tenLoaiThu);
        return db.insert("LoaiThu",null,contentValues);
    }
    public int update(LoaiThu loaiThu){
        ContentValues contentValues=new ContentValues();
        contentValues.put("tenLoaiThu",loaiThu.tenLoaiThu);
        return db.update("LoaiThu",contentValues,"maLoaiThu=",new String[]{String.valueOf(loaiThu.maLoaiThu)});
    }
    public int delete(String string){
        return db.delete("LoaiThu","maLoaiThu=?",new String[]{string});

    }
    public List<LoaiThu> getAll(){
        String sql="Select*from LoaiThu";
        return getData(sql);
    }
    private List<LoaiThu> getData(String sql,String...a) {
    List<LoaiThu> loaiThus=new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,a);
        while (cursor.moveToNext()){
            LoaiThu loaiThu=new LoaiThu();
            loaiThu.maLoaiThu=Integer.parseInt(cursor.getString(cursor.getColumnIndex("maLoaiThu")));
            loaiThu.tenLoaiThu=cursor.getString(cursor.getColumnIndex("tenLoaiThu"));
            loaiThus.add(loaiThu);
        }
        return loaiThus;

    }


}
