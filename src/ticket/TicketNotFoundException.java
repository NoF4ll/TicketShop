package ticket;

@SuppressWarnings("serial")
public class TicketNotFoundException extends Exception {
	TicketNotFoundException()
	{
		
	}
	
	TicketNotFoundException(String msg)
	{
		super(msg);
	}

}
