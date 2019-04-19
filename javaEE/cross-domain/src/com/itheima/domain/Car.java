package com.itheima.domain;

import java.util.Date;

/**
 * @Package: com.itheima.domain
 * @Author: PengSS
 * @Date: 2018/12/19 22:02
 */
public class Car {
    private Integer id;
    private String name;
    private Date ctime;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ctime=" + ctime +
                '}';
    }

    public Car() {
    }

    public Car(Integer id, String name, Date ctime) {
        this.id = id;
        this.name = name;
        this.ctime = ctime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
