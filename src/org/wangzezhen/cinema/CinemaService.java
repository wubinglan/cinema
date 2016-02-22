package org.wangzezhen.cinema;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;

public class CinemaService implements ICinmea {

	//静态快中初始化电影信息
	static{
		MOVIE.put("疯狂的石头", new Movie("宁浩", "黄渤", 60, "疯狂的石头","12时",MovieType.喜剧));
		MOVIE.put("老炮", new Movie("管虎", "冯小刚", 100, "老炮","13时",MovieType.动作));
		MOVIE.put("寻龙诀", new Movie("乌尔善", "陈坤", 80, "寻龙诀","14时",MovieType.动作));
//		MOVIE.put("疯狂的石头", new Movie("宁浩", "黄渤", 60, "疯狂的石头",,MovieType.喜剧));
//		MOVIE.put("疯狂的石头", new Movie("宁浩", "黄渤", 60, "疯狂的石头",MovieType.喜剧));
//		MOVIE.put("疯狂的石头", new Movie("宁浩", "黄渤", 60, "疯狂的石头",MovieType.喜剧));
//		MOVIE.put("疯狂的石头", new Movie("宁浩", "黄渤", 60, "疯狂的石头",MovieType.喜剧));
		
	}
	
	@Override
	public void showInfo() {

		//迭代集合
		for(Iterator<Movie> it = MOVIE.values().iterator();it.hasNext();){
			System.out.println(it.next());
		}
		
	}

	@Override
	public Movie getMovieByName(String name) {

				
		return MOVIE.get(name);
	}

	@Override
	public void addTicket(Ticket ticket) {
		TICKET.add(ticket);
		System.out.println("售票成功，当前共卖出"+TICKET.size()+"张");
		
	}

	@Override
	public void showTickets() {
		if(!TICKET.isEmpty()){
			for(Ticket c : TICKET){
				System.out.println(c);
				System.out.println("=======================================");
			}
		}else{
			System.out.println("对不起，当前没有销售记录");
		}
	}

	@Override
	public void save() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tickets.ser"));
		out.writeObject(TICKET);
		out.close();
	}

	@Override
	public void load() throws Exception {
		// 反序列化：读取历史记录
		ObjectInputStream in=new 
				ObjectInputStream(new FileInputStream("tickets.ser"));
		 List<Ticket> ts=(List<Ticket>)in.readObject();
		 in.close();
		 //添加到当前销售记录中
		 TICKET.addAll(ts);
		
	}

}
