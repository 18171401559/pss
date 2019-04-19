package com.itheima.domain;

/**
 * 订单实体类
 * @author MACHENIKE
 *
 */
public class T_product {

	private int id;//主键
	private String company;//订单编号
	private String name;//订单名称
	private Double prices;//订单价格
	private int num;//订单数量
	public int getId() {
		return id;
	}

	public T_product(int id, String company, String name, Double prices, int num) {
		this.id = id;
		this.company = company;
		this.name = name;
		this.prices = prices;
		this.num = num;
	}

	public T_product() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrices() {
		return prices;
	}

	public void setPrices(Double prices) {
		this.prices = prices;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
