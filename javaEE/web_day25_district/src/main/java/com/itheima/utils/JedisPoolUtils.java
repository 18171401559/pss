package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {

    private  static JedisPool jedisPool ;

    static {

        try {
            //1. 加载配置文件
            InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
            //2. 加载输入流中的数据
            Properties properties = new Properties();
            properties.load(is);

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
            config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));

            jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取jedis连接的操作
     * @return
     */
    public static Jedis getJedis(){
        return  jedisPool.getResource();
    }
}
