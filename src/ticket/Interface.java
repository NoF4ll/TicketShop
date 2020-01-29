package ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	static Scanner sc = new Scanner(System.in);
	static boolean check = false;
	static boolean login = false;
	static int preis;
	static int user;
	static String username;
	static String password;
	static String adresse;


	public static void main(String[] args) {

		StandartTicket[] tickets = new StandartTicket[3];
		ArrayList<StandartTicket> warenkorb = new ArrayList<StandartTicket>();

		tickets[0] = new StandartTicket(30, TicketType.KONZERTKARTE);
		tickets[1] = new StandartTicket(50, TicketType.FESTIVALKARTE);
		tickets[2] = new StandartTicket(15, TicketType.SPORTVERANSTALTUNG);
		while (check == false) {
			while(login == false)
			{
				System.out.println("Wollen Sie sich registrieren oder anmelden?\n 1 ... Registrieren\n 2 ... Anmelden");
				user = sc.nextInt();
				if(user == 1)
				{
					login = true;
					System.out.println("Geben sie ihren username ein : ");
					username = sc.next();
					System.out.println("Geben Sie ihr passwort ein : ");
					password = sc.next();
					User.usernameAndPassword(username,password);
				}
				if(user == 2)
				{
					login = true;
					boolean ok = false;
					while(ok == false)
					{
						System.out.println("Username : ");
						username = sc.next();
						System.out.println("Passwort : ");
						password = sc.next();
						
						if(User.usernameCheck(username)&&User.passwordCheck(password))
						{
							ok = true;
						}
						else {
							System.out.println("Username oder Passwort sind falsch!");
						}
					}
				}
			
			}
				System.out.println("Was für Ticket wollen sie kaufen? ");
			for (int i = 0; i < tickets.length; i++) {
				System.out
						.println("Drücken Sie " + (i + 1) + " um ein " + tickets[i].tickettype.typ + " hinzuzufügen!");
			}
			int eingabe = sc.nextInt();
			try {
				if (eingabe < 1 || eingabe > tickets.length)
					throw new TicketNotFoundException("Gebe eine Zahl zwischen 1  und " + tickets.length + " ein");
			} catch (TicketNotFoundException e) {
				e.printStackTrace();
			}
			boolean ok = false;
			while (ok == false) {
				System.out.println("In welcher Reihe wollen Sie sitzen?");
				System.out.println("VIP Ticket ... 4\n1. Reihe ... 3\n2. Reihe... 2\n3. Reihe... 1");
				int preisCalc = sc.nextInt();
				if (preisCalc < 1 || preisCalc > 4) {
					ok = false;
					System.out.println("Sie müssen eine Zahl zwischen 1 und 4 eingeben!");
				} else {
					ok = true;
				}
				tickets[eingabe - 1].setPreis(preisCalc * tickets[eingabe - 1].getPreis());
			}
			System.out.println("Du hast einmal " + tickets[eingabe - 1].tickettype.typ + "zum Warenkorb hinzugefügt!");
			warenkorb.add(tickets[eingabe - 1]);
			System.out.println("Wollen Sie ein weiteres Ticket kaufen?\n Drücken Sie j für Ja und n für Nein");
			String antwort = sc.next();

			if (antwort.equals("n")) {
				check = true;
			}
		}
		for (int i = 0; i < warenkorb.size(); i++) {
			preis = preis + warenkorb.get(i).getPreis();
		}
		System.out.println("In ihrem Warenkorb befinden sich " + warenkorb.size()
				+ " Artikel mit einen Gesamtbetrag von " + preis + " Euro");
		System.out.println("Geben Sie ihre Adresse ein : ");
		adresse = sc.next();
		System.out.println("Die Tickets und die Rechnung wurden zur dieser Adresse versendet\n"+adresse);
	}
}