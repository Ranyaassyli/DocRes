package com.example.doctor.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.doctor.models.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY, " +
                "first_name TEXT, " +
                "last_name TEXT, " +
                "email TEXT, " +
                "password TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    // Insert a new user into the database
    public boolean insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("first_name", user.getFirstName());
        values.put("last_name", user.getLastName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        long result = db.insert("users", null, values);
        db.close();
        return result != -1;
    }

    // Get a user by email and password (for login)
    public User getUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("users", null, "email=? AND password=?", new String[]{email, password}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            User user = new User(
                    cursor.getInt(cursor.getColumnIndex("id")), // ID is assumed to be stored as an integer
                    cursor.getString(cursor.getColumnIndex("first_name")),
                    cursor.getString(cursor.getColumnIndex("last_name")),
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("password"))
            );
            cursor.close();
            return user;
        }
        cursor.close();
        return null;
    }

    // Get user by ID (for profile editing)
    public User getUserById(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("users", null, "id=?", new String[]{String.valueOf(userId)}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            User user = new User(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("first_name")),
                    cursor.getString(cursor.getColumnIndex("last_name")),
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("password"))
            );
            cursor.close();
            return user;
        }
        cursor.close();
        return null;
    }

    // Update user profile information
    public boolean updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("first_name", user.getFirstName());
        values.put("last_name", user.getLastName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword()); // You may choose not to update the password

        int rowsUpdated = db.update("users", values, "id=?", new String[]{String.valueOf(user.getId())});
        db.close();
        return rowsUpdated > 0;
    }
}
