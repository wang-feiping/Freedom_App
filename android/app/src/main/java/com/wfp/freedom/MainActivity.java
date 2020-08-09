package com.wfp.freedom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Freedom";

    @BindView(R.id.showPlan)
    public Button showPlanBt;

    @BindView(R.id.showRecord)
    public Button showRecordBt;

    @OnClick(R.id.showPlan)
    public void showPlanClick() {
        Log.i(TAG, "showPlanClick");
        Intent intent = new Intent();
        ComponentName name = new ComponentName("com.wfp.freedom","com.wfp.freedom.PlanActivity");
        intent.setComponent(name);
        startActivity(intent);
    }

    @OnClick(R.id.showRecord)
    public void showRecordClick() {
        Log.i(TAG, "showRecordClick");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}