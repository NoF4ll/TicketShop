package ticket;

public enum TicketType {
	KONZERTKARTE("KonzertKarten Ticket"), SPORTVERANSTALTUNG("Sportveranstaltungs Ticket"), FESTIVALKARTE("Festivalkarten Ticket");
	String typ;
	TicketType(String typ)
	{
		this.typ=typ;
	}
}
