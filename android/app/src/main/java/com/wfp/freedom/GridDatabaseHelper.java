package com.wfp.freedom;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import androidx.annotation.Nullable;

public class GridDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "Freedom";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "grid.db";

    private Context mContext;
    private DataHelper dataHelper = new DataHelper();

    public GridDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "GridDatabaseHelper onCreate");

        String createPlanTable = "create table plan(" +
                "code char(10) NOT NULL," +
                "id integer  NOT NULL," +
                "buyPrice decimal(8,2) NOT NULL," +
                "sellPrice decimal(8,2) NOT NULL," +
                "buyCount integer NOT NULL," +
                "sellCount integer NOT NULL," +
                "profit decimal(8,2) NOT NULL," +
                "profitRation decimal(8,2) NOT NULL," +
                "saveCount integer NOT NULL," +
                "PRIMARY KEY (code, id))";

        db.execSQL(createPlanTable);

        List<ContentValues> datas = dataHelper.initialPlanData(mContext);
        for (ContentValues item : datas) {
            db.insert("plan", null, item);
        }

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
