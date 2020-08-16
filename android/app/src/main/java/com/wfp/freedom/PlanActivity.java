package com.wfp.freedom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wfp.freedom.slide.SlideData;
import com.wfp.freedom.slide.SlideWrap;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanActivity extends AppCompatActivity {
    public static final String TAG = "Freedom";

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
        mDraggableView.setAdapter(new ColumnAdapter(this, obtainDraggableData()));
    }

    private SlideData obtainDraggableData() {
        SlideData data = new SlideData();
        List<String> title = new ArrayList<>();
        title.add("年龄|身高");
        title.add("152cm");
        title.add("156cm");
        title.add("160cm");
        title.add("164cm");
        title.add("168cm");
        title.add("172cm");
        title.add("176cm");
        title.add("180cm");
        title.add("184cm");
        title.add("188cm");

        List<String> column1 = new ArrayList<>();
        column1.add("19");
        column1.add("50");
        column1.add("56");
        column1.add("58");
        column1.add("60");
        column1.add("62");
        column1.add("64");
        column1.add("66");
        column1.add("68");
        column1.add("70");
        column1.add("72");

        List<List<String>> content = new ArrayList<>();
        content.add(column1);

        data.setTitle(title);
        data.setContent(content);
        return data;
    }
}
