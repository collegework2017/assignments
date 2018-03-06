import java.util.Scanner;
import java.io.IOException;

public class Test {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter q to exit");
		
		String username, password;
		while(true) {
			System.out.print("Please Enter username:");
			username = userInput.nextLine();
			
			System.out.print("Please Enter password:");
			password = userInput.nextLine();
			
			if(username == null && password == null) continue;
			
			if(username.equalsIgnoreCase("q") || password.equalsIgnoreCase("q")) break;
			
			*//if(username == null && password == null)
 			//	JOptionPane.showMessageDialog(null, "ble ble ble....";

			//else if(!(username.matches("(\\w+\\W+)")) || (password.matches("(\\w+\\W+)")))
 			//	JOptionPane.showMessageDialog(null, "ble ble ble....";
			//else
							      {
			//*
			try {
				System.out.println((MiscUtils.isValidUser(username, password))
					? "User is Valid" : "User is invalid");
			} catch(IOException ex) {
				System.out.println("Error Checking file:" + ex);
			}
		}
		userInput.close();
		System.out.println("Application Finished");
	}
}
