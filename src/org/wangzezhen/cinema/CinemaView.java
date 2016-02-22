package org.wangzezhen.cinema;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 窗口
 * @author 王泽振
 *2016年2月22日 上午10:47:47
 */
public class CinemaView {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		ICinmea service = new CinemaService();//创建业务对象
		int m = 0;
		//读取历史记录
		File file=new File("tickets.ser");
		if(file.exists()){
			service.load();
		}
		do{
			System.out.println("1 浏览电影 2 售票 3查询销售记录 4 退出");
			m = in.nextInt();
			
			switch (m) {
			
			case 1://浏览电影
				service.showInfo();
				break;
				
			case 2://售票
				System.out.println("请输入电影名称");
				String name = in.next();
				Movie movie = service.getMovieByName(name);
				System.out.println(movie == null ? "您输入的电影不存在":movie);
				System.out.println("请选择种类：1普通票 2学生票 3赠票");
				m = in.nextInt();
				Ticket ticket = TicketFactory.createTicket(movie, m);
				if(ticket == null){
					System.out.println("您输入的票类不存在");
				}else if(ticket instanceof StudentTicket){
					System.out.println("请输入折扣");
					int discount = in.nextInt();
					((StudentTicket) ticket).setDiscount(discount);
				}else if(ticket instanceof FreeTicket){
					System.out.println("请输入客户名");
					String customerName = in.next();
					((FreeTicket) ticket).setCustomerName(customerName);
				}
				System.out.println(ticket);
				//打印票
				ticket.print();
				service.addTicket(ticket);
				
				break;
				
			case 3:
				//查询销售记录 （序列化  objectoutputstream objectinputstream）
				service.showTickets();
				break;
				
			case 4://退出
				//判断是否存在销售记录
				if(!ICinmea.TICKET.isEmpty()){
					//保存销售记录
					service.save();
					System.out.println("保存成功！");
				}
				System.out.println("谢谢 再见");
				System.exit(0);
				break;
				
			}
		}while(m<=4);
		in.close();
	}
}
