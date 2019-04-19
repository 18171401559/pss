package com.itheima.domain;

import java.util.Date;

public class Product {
  /*
   * 	pid varchar (96) primary key,
	pname varchar (150) not null unique,
	market_price double,
	shop_price double,
	pdate date,
	is_hot varchar(1),
	pdesc varchar (765),
	pflag varchar(1)
   * 
   */
   private String pid;
   private String pname;
   private double market_price;
   private double shop_price;
   private Date pdate;
   private String is_hot;
   private String pdesc;
   private String pflag;
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public double getMarket_price() {
	return market_price;
}
public void setMarket_price(double market_price) {
	this.market_price = market_price;
}
public double getShop_price() {
	return shop_price;
}
public void setShop_price(double shop_price) {
	this.shop_price = shop_price;
}
public Date getPdate() {
	return pdate;
}
public void setPdate(Date pdate) {
	this.pdate = pdate;
}
public String getIs_hot() {
	return is_hot;
}
public void setIs_hot(String is_hot) {
	this.is_hot = is_hot;
}
public String getPdesc() {
	return pdesc;
}
public void setPdesc(String pdesc) {
	this.pdesc = pdesc;
}
public String getPflag() {
	return pflag;
}
public void setPflag(String pflag) {
	this.pflag = pflag;
}
   
   
   
}
