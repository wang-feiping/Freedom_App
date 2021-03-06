package com.wfp.freedom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wfp.freedom.data.PlanItem;
import com.wfp.slide.slide.SlideData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataHelper {
    private static final String TAG = "Freedom";

    public List<PlanItem> readJson(Context context) {
        Map<String, List<PlanItem>> item;

        try {
            InputStream stream = context.getAssets().open("plan.json");
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder buffer = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
                buffer.append("\n");
            }

            Log.i(TAG, buffer.toString());
            item = JSON.parseObject(buffer.toString(),
                    new TypeReference<LinkedHashMap<String, List<PlanItem>>>(){});
        } catch (IOException error) {
            error.printStackTrace();
            return null;
        }

        List<PlanItem> result = new ArrayList<>();
        for (Map.Entry<String, List<PlanItem>> entry : item.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    public List<ContentValues> initialPlanData(Context context) {
        List<ContentValues> datas = new ArrayList<>();

        List<PlanItem> planItems = readJson(context);
        for (PlanItem item : planItems) {
            ContentValues value = new ContentValues();
            value.put("code", item.getCode());
            value.put("id", item.getId());
            value.put("buyPrice", item.getBuyPrice());
            value.put("sellPrice", item.getSellPrice());
            value.put("buyCount", item.getBuyCount());
            value.put("sellCount", item.getSellCount());
            value.put("profit", item.getProfit());
            value.put("profitRation", item.getProfitRation());
            value.put("saveCount", item.getSaveCount());
            datas.add(value);
        }
        return datas;
    }

    // 获取指定标的的网格计划表
    public SlideData getPlanData(Cursor cursor) {
        if (cursor == null) {
            return null;
        }

        SlideData data = new SlideData();
        {
            List<String> title = new ArrayList<>();
            title.add("序号");
            title.add("买入价格");
            title.add("卖出价格");
            title.add("买入数量");
            title.add("卖出数量");
            title.add("盈利金额");
            title.add("盈利比例");
            title.add("留存数量");
            data.setTitle(title);
        }

        List<List<String>> contents = new ArrayList<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            List<String> temp = new ArrayList<>();
            temp.add(String.valueOf(cursor.getInt(1)));
            temp.add(String.valueOf(cursor.getDouble(2)));
            temp.add(String.valueOf(cursor.getDouble(3)));
            temp.add(String.valueOf(cursor.getInt(4)));
            temp.add(String.valueOf(cursor.getInt(5)));
            temp.add(String.valueOf(cursor.getDouble(6)));
            temp.add(String.valueOf(cursor.getDouble(7)));
            temp.add(String.valueOf(cursor.getInt(8)));
            contents.add(temp);
            cursor.moveToNext();
        }
        data.setContent(contents);
        return data;
    }

    public SlideData getAllPlan() {
        SlideData data = new SlideData();
        {
            List<String> title = new ArrayList<>();
            title.add("名称");
            title.add("买入资金");
            title.add("卖出资金");
            title.add("资金占用");
            title.add("当前市值");
            title.add("总盈亏");
            title.add("收益率");
            data.setTitle(title);
        }

        List<List<String>> contents = new ArrayList<>();
        {
            List<String> temp = new ArrayList<>();
            temp.add("券商ETF");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            contents.add(temp);
        }

        {
            List<String> temp = new ArrayList<>();
            temp.add("恒生ETF");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            contents.add(temp);
        }

        {
            List<String> temp = new ArrayList<>();
            temp.add("传媒ETF");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            temp.add("0");
            contents.add(temp);
        }

        data.setContent(contents);
        return data;
    }
}
