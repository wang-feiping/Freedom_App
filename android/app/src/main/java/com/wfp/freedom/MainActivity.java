package com.wfp.freedom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.wfp.freedom.slide.SlideData;
import com.wfp.freedom.slide.SlideWrap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Freedom";

    private DataHelper dataHelper = new DataHelper();

    @BindView(R.id.allPlanTitle)
    public TextView title;

    @BindView(R.id.showAllPlan)
    public SlideWrap showAllPlanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        title.setText("所有项目");

        SlideData slideData = dataHelper.getAllPlan();
        showAllPlanView.setAdapter(new MainAdapter(this, slideData));
    }
}