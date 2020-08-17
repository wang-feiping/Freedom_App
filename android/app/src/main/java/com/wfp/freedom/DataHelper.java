package com.wfp.freedom;

import android.content.ContentValues;

import com.wfp.freedom.slide.SlideData;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public List<ContentValues> initialPlanData(String code) {
        List<ContentValues> datas = new ArrayList<>();

        // 改为从配置文件中读取
        ContentValues values1 = new ContentValues();
        values1.put("code", "512800");
        values1.put("id", 1);
        values1.put("buyPrice", 1.23);
        values1.put("sellPrice", 1.29);
        values1.put("buyCount", 1700);
        values1.put("sellCount", 1600);
        values1.put("profit", 104.55);
        values1.put("profitRation", 0.05);
        values1.put("saveCount", 100);
        datas.add(values1);

        ContentValues values2 = new ContentValues();
        values2.put("code", "512800");
        values2.put("id", 2);
        values2.put("buyPrice", 1.17);
        values2.put("buyCount", 1800);
        values2.put("sellPrice", 1.23);
        values2.put("sellCount", 1700);
        values2.put("profit", 105.17);
        values2.put("profitRation", 0.05);
        values2.put("saveCount", 100);
        datas.add(values2);
        return datas;

       /* SlideData data = new SlideData();
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
        title.add("留存数量");*/
    }

    // 获取指定标的的网格计划表
    public SlideData getPlanData(String code) {
        return null;
    }
}
