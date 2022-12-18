package com.example.yourpills;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import androidx.annotation.Nullable;

import java.sql.Blob;

public class DB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "YourPills.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "comprimido";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "nome_comprimido";
    private static final String COLUMN_MIL = "miligramas_comprimido";
    private static final String COLUMN_MED = "medicamentos_comprimido";
    private static final String COLUMN_EMB = "embalagens_comprimido";
    private static final String COLUMN_DATA = "data_comprimido";


    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");

        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + "TEXT, " +
                        COLUMN_MIL + "INTEGER, " +
                        COLUMN_MED + "INTEGER, " +
                        COLUMN_EMB + "INTEGER, " +
                        COLUMN_DATA + "BLOB); " ;
        MyDB.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");

        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(MyDB);
    }

    void addComp(String Name, int MIl, int MED, int EMB, String data){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, Name);
        cv.put(COLUMN_MIL, MIl);
        cv.put(COLUMN_MED, MED);
        cv.put(COLUMN_EMB, EMB);
        cv.put(COLUMN_DATA, data);
        long result = MyDB.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Adicionado com Sucesso", Toast.LENGTH_SHORT).show();
        }


    }
    public Boolean insertDATA(String username, String email, String age, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("age", age);
        contentValues.put("password", password);

        long result = DB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
