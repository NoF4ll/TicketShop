package ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	static Scanner sc = new Scanner(System.in);
	static int preis = 0;
	static boolean check = false;

	public static void main(String[] args) {

		StandartTicket[] tickets = new StandartTicket[3];
		ArrayList<StandartTicket> warenkorb = new ArrayList<StandartTicket>();

		tickets[0] = new StandartTicket(preis, TicketType.KONZERTKARTE);
		tickets[1] = new StandartTicket(preis, TicketType.FESTIVALKARTE);
		tickets[2] = new StandartTicket(preis, TicketType.SPORTVERANSTALTUNG);
		while (check == false) {
			System.out.println("Was f�r Ticket wollen sie kaufen? ");
			for (int i = 0; i < tickets.length; i++) {
				System.out
						.println("Dr�cken Sie " + (i + 1) + " um ein " + tickets[i].tickettype.typ + " hinzuzuf�gen!");
			}
			int eingabe = sc.nextInt();
			try {

				if (eingabe < 1 || eingabe > tickets.length)
					throw new TicketNotFoundException("Gebe eine Zahl zwischen 1  und " + tickets.length + " ein");
			} catch (TicketNotFoundException e) {

				e.printStackTrace();
			}

			System.out.println("Du hast Einmal " + tickets[eingabe - 1].tickettype.typ + "zum Warenkorb hinzugef�gt!");
			warenkorb.add(tickets[eingabe - 1]);
			
			System.out.println("Wollen sie ein weiteres Ticket kaufen?\n Dr�cken Sie j f�r Ja und n f�r Nein");
			String antwort = sc.next();
			
			if(antwort.equals("n")) {
				check = true;
			}
		}

	}

}
