package com.wfp.freedom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanActivity extends AppCompatActivity {
    public static final String TAG = "Freedom";

    @BindView(R.id.planListView)
    ListView planListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        ButterKnife.bind(this);

        final List<String> adapterData = new ArrayList<String>();
        //存放要显示的数据
        for (int i = 0; i < 20; i++) {
            adapterData.add("ListItem" + i);
        }
        //创建ArrayAdapter对象adapter并设置适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, adapterData);
        //将LsitView绑定到ArrayAdapter上
        planListView.setAdapter(adapter);
    }
}
