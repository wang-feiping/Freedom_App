package com.wfp.freedom;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.wfp.freedom.slide.SlideData;
import com.wfp.freedom.slide.SlideWrap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanActivity extends AppCompatActivity {
    private static final String TAG = "Freedom";

    private DataHelper dataHelper = new DataHelper();

    @BindView(R.id.draggable_list_view)
    public SlideWrap mDraggableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        GridDatabaseHelper databaseHelper = new GridDatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        String queryPlan = "SELECT * from plan";
        Cursor cursor = db.rawQuery(queryPlan, null);
        SlideData slideData = dataHelper.getPlanData(cursor);
        mDraggableView.setAdapter(new ColumnAdapter(this, slideData));
    }
}
