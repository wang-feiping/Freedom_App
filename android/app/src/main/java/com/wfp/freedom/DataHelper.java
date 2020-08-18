package com.wfp.freedom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wfp.freedom.data.PlanItem;
import com.wfp.freedom.slide.SlideData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataHelper {
    private static final String TAG = "Freedom";

    public List<PlanItem> readJson(Context context, String code) {
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

        return item.get(code);
    }

    public List<ContentValues> initialPlanData(Context context, String code) {
        List<ContentValues> datas = new ArrayList<>();

        List<PlanItem> planItems = readJson(context, code);
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
            title.add("编码");
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
            temp.add(cursor.getString(0));
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
}
