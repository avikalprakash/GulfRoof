package com.example.lue.waterroofingmeasurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by LUE on 16-09-2017.
 */

public class DatabaseHandler1 extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "details.db";
    public static final String TABLE_NAME = "offer_table";
    //  public static final String CONTACTS_COLUMN_Document_ID = "id";
    public static final String COLUMN_Rooftype = "Rooftype";
    public static final String COLUMN_Area = "Area";
    public static final String COLUMN_Number = "Number";
    public static final String COLUMN_Cost = "Cost";


    public DatabaseHandler1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (Rooftype TEXT PRIMARY KEY,Area TEXT,Number TEXT,Cost TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_Rooftype, Rooftype);
//        contentValues.put(COLUMN_Area, Area);
//        contentValues.put(COLUMN_Number, Number);
//        contentValues.put(COLUMN_Cost, Cost);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


}
