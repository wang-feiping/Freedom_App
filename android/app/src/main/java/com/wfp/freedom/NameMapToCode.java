package com.wfp.freedom;

import java.util.HashMap;
import java.util.Map;

public class NameMapToCode {
    public static final Map<String, String> nameCodeMap = new HashMap<>();

    static {
        nameCodeMap.put("券商ETF", "512000");
        nameCodeMap.put("恒生ETF", "159920");
        nameCodeMap.put("传媒ETF", "512980");
    }
}
