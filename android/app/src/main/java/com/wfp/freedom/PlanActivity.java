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
        title.add("序号");
        title.add("买入价格");
        title.add("卖出价格");
        title.add("买入数量");
        title.add("买入金额");
        title.add("卖出数量");
        title.add("卖出金额");
        title.add("盈利金额");
        title.add("盈利比例");
        title.add("留存数量");

        List<String> column1 = new ArrayList<>();
        column1.add("1");
        column1.add("1.23");
        column1.add("1.29");
        column1.add("1700");
        column1.add("2091.00");
        column1.add("1600");
        column1.add("2066.40");
        column1.add("104.55");
        column1.add("5.00%");
        column1.add("100");

        List<String> column2 = new ArrayList<>();
        column2.add("2");
        column2.add("1.17");
        column2.add("1.23");
        column2.add("1800");
        column2.add("2103.00");
        column2.add("1700");
        column2.add("2085.77");
        column2.add("105.17");
        column2.add("5.00%");
        column2.add("100");

        List<List<String>> content = new ArrayList<>();
        content.add(column1);
        content.add(column2);

        data.setTitle(title);
        data.setContent(content);
        return data;
    }
}
