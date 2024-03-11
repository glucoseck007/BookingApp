package fpt.edu.bookingapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "PE";
    public static final int DB_VERSION = 1;
    public Context context;

    public static final String TABLE = "CREATE TABLE PERSON(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT," +
            "date DATE," +
            "value INTEGER)";

    public AppDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE);

        String insert = "INSERT INTO PERSON(name, date, value) VALUES (?, ?, ?)";
        db.execSQL(insert, new Object[]{"Nguyễn Văn Hoàng", "12-05-2022", 100000});
        db.execSQL(insert, new Object[]{"Nguyễn Văn Hải", "11-05-2022", 100200});
        db.execSQL(insert, new Object[]{"Hoàng Thị Anh", "11-04-2022", 100200});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
