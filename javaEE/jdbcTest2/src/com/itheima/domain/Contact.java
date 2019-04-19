package com.itheima.domain;

import java.util.Date;

/**
 * @Package: com.itheima.domain
 * @Author: PengSS
 * @Date: 2018/11/4 21:46
 */
public class Contact {
    private Integer id;
    private String name;
    private String gander;
    private Date birthday;
    private String telephone;
    private String city;

    public Contact(Integer id, String name, String gander, Date birthday, String telephone, String city) {
        this.id = id;
        this.name = name;
        this.gander = gander;
        this.birthday = birthday;
        this.telephone = telephone;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gander='" + gander + '\'' +
                ", birthday=" + birthday +
                ", telephone='" + telephone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Contact() {
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

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
