package com.wfp.freedom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class GridDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "Freedom";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "grid.db";

    public GridDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "GridDatabaseHelper onCreate");

        String createPlanTable = "create table plan(" +
                "code char(10) NOT NULL," +
                "id integer  NOT NULL," +
                "buyPrice decimal(8,2) NOT NULL," +
                "buyCount integer NOT NULL," +
                "sellPrice decimal(8,2) NOT NULL," +
                "sellCount integer NOT NULL," +
                "profit decimal(8,2) NOT NULL," +
                "profitRation decimal(8,2) NOT NULL," +
                "saveCount integer NOT NULL," +
                "PRIMARY KEY (code, id))";

        db.execSQL(createPlanTable);

        String createRecordTable = "create table record(" +
                "code char(10) NOT NULL," +
                "id integer NOT NULL," +
                "date char(20) NOT NULL," +
                "operation integer NOT NULL," +
                "price decimal(8,2) NOT NULL," +
                "count integer NOT NULL," +
                "currentHold integer NOT NULL," +
                "currentValue decimal(8,2) NOT NULL," +
                "costPrice decimal(8,2) NOT NULL," +
                "currentPrice decimal(8,2) NOT NULL," +
                "PRIMARY KEY (code, id))";

        db.execSQL(createRecordTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "GridDatabaseHelper onUpgrade");
    }
}
