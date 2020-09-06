package com.wfp.freedom;

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

public class MainFragment extends Fragment {
    private DataHelper dataHelper = new DataHelper();

    @BindView(R.id.allPlanTitle)
    public TextView title;

    @BindView(R.id.showAllPlan)
    public SlideWrap showAllPlanView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    private void initData() {
        title.setText("所有品种");

        SlideData slideData = dataHelper.getAllPlan();
        showAllPlanView.setAdapter(new MainAdapter(getActivity(), slideData));
    }
}
