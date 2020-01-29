package ticket;

public class StandartTicket {
	int preis;
	TicketType tickettype;

	StandartTicket(int preis, TicketType tickettype) {
		this.preis = preis;
		this.tickettype = tickettype;
	}

	int getPreis() {
		return preis;
	}

	void setPreis(int preis) {
		this.preis = preis;
	}
}
