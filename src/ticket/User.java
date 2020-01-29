package ticket;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class User {
	String getUsername() {

		return "ss";
	}

	public static void usernameAndPassword(String username, String password) {
		FileWriter fw;
		FileWriter pw;
		try {
			fw = new FileWriter("C:\\Users\\Maximilian Neuner\\Documents\\JavaTxtFiles\\usernames.txt", true);

			fw.write(username + "\n");
			fw.close();

			pw = new FileWriter("C:\\Users\\Maximilian Neuner\\Documents\\JavaTxtFiles\\password.txt", true);
			pw.write(password + "\n");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean usernameCheck(String username) {
		try {
			File us = new File("C:\\Users\\Maximilian Neuner\\Documents\\JavaTxtFiles\\usernames.txt");
			Scanner myReader = new Scanner(us);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.equals(username)) {
					myReader.close();
					return true;
				}
			}
			myReader.close();
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}
		return false;
	}

	public static boolean passwordCheck(String password) {
		try {
			File pw = new File("C:\\Users\\Maximilian Neuner\\Documents\\JavaTxtFiles\\password.txt");
			Scanner myReader = new Scanner(pw);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.equals(password)) {
					myReader.close();
					return true;
				}
			}
			myReader.close();
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}
		return false;
	}

}
