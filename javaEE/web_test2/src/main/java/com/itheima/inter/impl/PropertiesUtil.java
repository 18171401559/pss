package com.itheima.inter.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * @Package: com.itheima.inter.impl
 * @Author: PengSS
 * @Date: 2018/10/26 10:35
 */
public class PropertiesUtil {
    public static HashMap<String, String> readProperties(String jdbcPropertiesFile) {
        HashMap<String, String> map = new HashMap<>();
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(jdbcPropertiesFile));
            for (String s : pro.stringPropertyNames()) {
                map.put(s, (String) pro.get(s));
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
