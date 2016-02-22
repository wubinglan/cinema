package org.wangzezhen.cinema;
/**
 * 学生票
 * @author 王泽振
 *2016年2月22日 上午11:32:01
 */
public class StudentTicket extends Ticket {

	private int discount;//折扣

	@Override
	public int calc() {
		//重写
		int n = this.getMoive().getPrice()*this.discount/10;
		return n;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	

	public StudentTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "学生票：[折扣=" + discount +"折"+  super.toString() + "]";
	}

	public StudentTicket(Movie moive) {
		super(moive);
		// TODO Auto-generated constructor stub
	}
	
	
}
