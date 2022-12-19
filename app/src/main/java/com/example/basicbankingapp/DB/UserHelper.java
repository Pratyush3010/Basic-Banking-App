package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Ashutosh Tiwari', 'tripathiashu9696@gmail.com','4672','8400097493', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Vivek Kumar Yadav', 'vivekmgs0321@gmail.com','7252','9670348649', 35000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Sangam Prajapati', '20350@recbanda.ac.in','8896','9305014431', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Rahul kumar Patel', 'rahul@gmail.com','7752','8795452849', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Khushi Gupta', 'khushi@gmail.com','4522','7885021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Sneha Kumari', 'snehakumari@gmail.com','3669','9798654623', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Anjali Singh', 'anjalisingh@gmail.com','9985','9339319431', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yash Pratap', 'yash@gmail.com','1207','6395640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Ritika Sharma', 'ritik@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Ritesh Poddar', 'ritesh@gmail.com','5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Nitin Kumar', 'nitin@gmail.com','2656','7015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Gaurav Sharma', 'sharmagaurav@gmail.com','1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Numan Alam', 'numanalam@gmail.com','5566','7019541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Gauri Parashar', 'gauri@gmail.com','2236','6354642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Ashutosh Pandey', 'ashutosh_panndey@gmail.com','6692','9693641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}