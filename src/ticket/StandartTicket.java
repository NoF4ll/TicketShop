package ticket;

public class StandartTicket {
	int preis;
	int ticketAnzahl;
	TicketType tickettype;

	StandartTicket(int preis,int ticketAnzahl, TicketType tickettype) {
		this.preis = preis;
		this.tickettype = tickettype;
		this.ticketAnzahl=ticketAnzahl;
	}

	int getPreis() {
		return preis;
	}

	void setPreis(int preis) {
		this.preis = preis;
	}
	
	int getAnzahl()
	{
		return ticketAnzahl;
	}
	
	void setAnzahl(int ticketAnzahl)
	{
		this.ticketAnzahl = ticketAnzahl;
	}
}
