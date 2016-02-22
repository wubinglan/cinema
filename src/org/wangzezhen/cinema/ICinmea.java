package org.wangzezhen.cinema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 放映厅
 * @author 王泽振
 *2016年2月22日 上午10:30:32
 */
public interface ICinmea {

	//电影的集合
	Map<String, Movie> MOVIE = new HashMap<String, Movie>();
	
	
	//浏览所有电影
	void showInfo();
	
	//根据电影名称获取具体的电影信息
	Movie getMovieByName(String name);
	
	
	//已经售票的集合
	List<Ticket> TICKET = new ArrayList<Ticket>(600);
	
	//添加已售票
	void addTicket(Ticket ticket);
	
	//查询已售票
	void showTickets();
	
	//序列化
	void save()throws IOException;
	//反序列化
	void load()throws Exception;
	
}
