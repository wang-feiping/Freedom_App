package com.wfp.freedom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.wfp.freedom.slide.SlideData;
import com.wfp.freedom.slide.SlideWrap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanActivity extends AppCompatActivity {
    private static final String TAG = "Freedom";

    private DataHelper dataHelper = new DataHelper();

    @BindView(R.id.title)
    public TextView mTitleView;

    @BindView(R.id.draggable_list_view)
    public SlideWrap mDraggableView;

    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        code = intent.getStringExtra("Code");

        mTitleView.setText(code);
        initData(NameMapToCode.nameCodeMap.get(code));
    }

    private void initData(String code) {
        GridDatabaseHelper databaseHelper = new GridDatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        String queryPlan = String.format("SELECT * from plan WHERE CODE = %s", code);
        Cursor cursor = db.rawQuery(queryPlan, null);
        SlideData slideData = dataHelper.getPlanData(cursor);
        mDraggableView.setAdapter(new PlanAdapter(this, slideData));
    }
}