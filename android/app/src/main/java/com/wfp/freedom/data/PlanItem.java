package com.wfp.freedom.data;

import lombok.Data;

/**
 * 保存网格计划表的字段
 */
@Data
public class PlanItem {
    /**
     * 标的编码
     */
    private String code;

    /**
     * 序号
     */
    private int id;

    /**
     * 买入价格
     */
    private double buyPrice;

    /**
     * 买入数量
     */
    private int buyCount;

    /**
     * 卖出价格
     */
    private double sellPrice;

    /**
     * 卖出数量
     */
    private int sellCount;

    /**
     * 盈利金额
     */
    private double profit;

    /**
     * 盈利比例
     */
    private double profitRation;

    /**
     * 留存数量
     */
    private int saveCount;
}
