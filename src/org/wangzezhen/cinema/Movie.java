package org.wangzezhen.cinema;

import java.io.Serializable;

public class Movie implements Serializable{

	private String direction;//导演
	private String actor;//主演
	private int price;//票价
	private String name;//名称
	private String time;//时间
	private MovieType type;//枚举  惊悚 战争 卡通 言情 动作 科幻 
	
	/**
	 * 构造
	 */
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String direction, String actor, int price, String name,
			MovieType type) {
		super();
		this.direction = direction;
		this.actor = actor;
		this.price = price;
		this.name = name;
		this.type = type;
	}
	
	public Movie(String direction, String actor, int price, String name,
			String time, MovieType type) {
		super();
		this.direction = direction;
		this.actor = actor;
		this.price = price;
		this.name = name;
		this.time = time;
		this.type = type;
	}

	/**
	 * 封装
	 * @return
	 */
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieType getType() {
		return type;
	}

	public void setType(MovieType type) {
		this.type = type;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "电影名=" + name +", 导演=" + direction + ", 主演=" + actor
				+ ", 价格=" + price + ", 电影类型=" + type
				+ ",时间"+time;
	}
	
	
	
}
