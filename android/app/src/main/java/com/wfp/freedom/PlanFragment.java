package com.wfp.freedom;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wfp.freedom.slide.SlideData;
import com.wfp.freedom.slide.SlideWrap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanFragment extends Fragment {
    private static final String TAG = "Freedom";

    private DataHelper dataHelper = new DataHelper();

    @BindView(R.id.title)
    public TextView mTitleView;

    @BindView(R.id.draggable_list_view)
    public SlideWrap mDraggableView;

    private String code = "512800";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.plan_fragment, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTitleView.setText(code);
        initData(NameMapToCode.nameCodeMap.get(code));
    }

    private void initData(String code) {
        GridDatabaseHelper databaseHelper = new GridDatabaseHelper(getContext());
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        String queryPlan = String.format("SELECT * from plan WHERE CODE = %s", code);
        Cursor cursor = db.rawQuery(queryPlan, null);
        SlideData slideData = dataHelper.getPlanData(cursor);
        mDraggableView.setAdapter(new PlanAdapter(getContext(), slideData));
    }
}
