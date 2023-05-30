package com.example.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class Db_Helper extends SQLiteOpenHelper {

    static final String DB_Name = " fieb.do ";
    static final int DB_VERSION = 1;
    static final String TABLE = " cadastro ";
    //   static final String C ID = " id ";
    static final String C_NOME = " nome ";
    static final String C_EMAIL = "Email";

    public Db_Helper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            String sql = "create table" + TABLE + " ("

                    + C_NOME + " text,"
                    + C_EMAIL + " text)";
            db.execSQL(sql);
        } catch (Exception e) {

            Log.e("Erro DbHelper: ", e.getMessage());
        }
    }

        @Override
        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
            try {


                String sql = "drop table if exists" + TABLE;
                db.execSQL(sql);
                onCreate(db);

            } catch (Exception e) {
                Log.e("Erro DbHelper: " e.getMessage());
            }

        }
    }
}