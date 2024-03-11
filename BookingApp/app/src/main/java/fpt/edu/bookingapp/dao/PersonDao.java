package fpt.edu.bookingapp.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.util.ArrayList;

import fpt.edu.bookingapp.DateConverter;
import fpt.edu.bookingapp.database.AppDatabase;
import fpt.edu.bookingapp.model.Person;

public class PersonDao {

    AppDatabase appDatabase;

    public PersonDao(Context context) {this.appDatabase = new AppDatabase(context); }

    @SuppressLint("Range")
    public ArrayList<Person> get(String sql, String... choose) {
        ArrayList<Person> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = appDatabase.getWritableDatabase();
        @SuppressLint("Recycle")Cursor cursor = sqLiteDatabase.rawQuery(sql, choose);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex("id")));
                person.setName(cursor.getString(cursor.getColumnIndex("name")));
                try {
                    person.setDate(DateConverter.toDate(cursor.getString(cursor.getColumnIndex("date"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                person.setValue(cursor.getInt(cursor.getColumnIndex("value")));
                list.add(person);
                Log.i("TAG", person.toString());
            } while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<Person> getAllPersons() {
        String sql = "SELECT * FROM PERSON ORDER BY date DESC";

        return get(sql);
    }

    public boolean insertPerson(Person person) {
        SQLiteDatabase sqLiteDatabase = appDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", person.getId());
        values.put("name", person.getName());
        values.put("date", DateConverter.toStringDate(person.getDate()));
        values.put("value", person.getValue());
        long check = sqLiteDatabase.insert("PERSON", null, values);

        return check != -1;
    }

}
