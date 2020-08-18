package com.wfp.freedom.data;

import java.util.Date;

import lombok.Data;

/**
 * 网格交易成交记录表
 */
@Data
public class RecordItem {
    /**
     * 标的编码
     */
    private String code;

    /**
     * 序号
     */
    private int id;

    /**
     * 交易日期
     */
    private Date date;

    /**
     * 操作方向
     */
    private String operation;

    /**
     * 操作价格
     */
    private double price;

    /**
     * 操作数量
     */
    private int count;

    /**
     * 当前持仓
     */
    private int currentHold;

    /**
     * 当前市值
     */
    private double currentValue;

    /**
     * 成本价
     */
    private double costPrice;

    /**
     * 现价
     */
    private double currentPrice;
}
