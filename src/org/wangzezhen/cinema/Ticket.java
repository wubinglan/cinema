package org.wangzezhen.cinema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Date;
import java.util.Random;

/**
 * 普通票  电影票的父类  
 * @author 王泽振
 *2016年2月22日 上午11:17:06
 */
public class Ticket implements IPrint,Serializable{

	private Movie moive;
	private String seatNum;//座位号
	
	/**
	 * 构造
	 */
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
		this.seatNum = this.getNumber();
	}
	
	public Ticket(Movie moive) {
		this();
		this.moive = moive;

	}
	
	/**
	 * 封装
	 * @return
	 */
	public Movie getMoive() {
		return moive;
	}
	
	public void setMoive(Movie moive) {
		this.moive = moive;
	}
	
	public String getSeatNum() {
		return seatNum;
	}

	//票价
	public int calc(){
		
		return this.moive.getPrice();
	}
	
	private String getNumber() {
		// TODO Auto-generated method stub

		Random ran = new Random();
		int m = ran.nextInt(20)+1;
		int n = ran.nextInt(30)+1;
		return m+"排"+n+"号";
		
	}

	@Override
	public String toString() {
		return "[电影名：《" + this.moive.getName() + "》, 座位号："
					+ this.seatNum + ",时间"+this.moive.getTime()+",票价：￥"
				+this.calc()+"]";
	}

	@Override
	public void print() {

		try{
			Writer w = new FileWriter("票"+new Date().getTime()+".txt");
			w.write("-------------------夜黑电影院--------------------------\n");
			w.write("电影名《"+this.moive.getName()+"》 \n");
			w.write("座位号：" +this.getSeatNum()+"时间"+this.moive.getTime());
			w.write("\n票价：￥"+this.calc()+"\n");
			w.write("======================================================");
			w.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
