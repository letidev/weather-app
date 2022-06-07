package com.example.weatherapp.datautils

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE $TABLE_NAME ($ID_COL INTEGER PRIMARY KEY, $CITY_COL TEXT)")
        db.execSQL(query);
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db);
    }

    fun addSearch(city: String) {
        val values = ContentValues()
        values.put(CITY_COL, city);

        val db = this.writableDatabase;
        db.insert(TABLE_NAME, null, values);
        db.close()
    }

    fun getSearches(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null);
    }

    fun deleteSearch(id: Int?) {
        if(id !== null) {
            val db = this.writableDatabase;
            db.delete(TABLE_NAME, "$ID_COL = $id", null);
        }
    }

    companion object{
        private const val DATABASE_NAME = "WEATHER_APP"

        private const val DATABASE_VERSION = 1

        val TABLE_NAME = "searches"

        val ID_COL = "id"

        val CITY_COL = "city"

    }
}