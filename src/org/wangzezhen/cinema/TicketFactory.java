package org.wangzezhen.cinema;
/**
 * 电影票工厂
 * @author 王泽振
 *2016年2月22日 上午11:44:33
 */
public class TicketFactory {

	public static  Ticket createTicket(Movie movie,int m){
		Ticket ticket  = null;
		
		switch (m) {
		case 1:
			 ticket = new Ticket(movie);
			break;

		case 2:
			 ticket = new StudentTicket(movie);
			break;
			
		case 3:
			 ticket = new FreeTicket(movie);
			break;
			
			default :
				ticket  = null;
		}
		
		
		return ticket;
		
	}
}
