package org.wangzezhen.cinema;

public class FreeTicket extends Ticket {

	private String customerName;//客户名称

	@Override
	public int calc() {
		// TODO Auto-generated method stub
		return 0;
	}

	public FreeTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeTicket(Movie moive) {
		super(moive);
		// TODO Auto-generated constructor stub
	}

	public FreeTicket(String customerName) {
		super();
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "赠票： [客户  ：" + customerName 
				+ super.toString() + "]";
	}

	
	
	
}
