package com.example.rfc.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rfc on 10/9/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyApp";
    public static final String TABLE_NAME = "Pictures";
    public static final String IMAGE_NAME = "imageName";
    public static final int DATABASE_VERSION = 1;

    public DataBase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY, " + IMAGE_NAME + " TEXT);";

        try{
            db.execSQL(SQL);
            System.out.println("Database created!");
        }
        catch(Exception error){
            System.out.println("Error create: " + error);
        }

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onCreate(db);
    }

    public boolean InsertPicture(String imagename){
        SQLiteDatabase db = this.getWritableDatabase();

        String SQL = "INSERT INTO " + TABLE_NAME + " VALUES (null, '" + imagename + "');";

        try{
            db.execSQL(SQL);
            return true;

        }
        catch (Exception error){
            System.out.println("Error insert: " + error);
            return false;
        }
    }

}
