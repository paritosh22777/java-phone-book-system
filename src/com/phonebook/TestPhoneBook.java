package com.phonebook;

import java.util.Scanner;

public class TestPhoneBook {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		PhoneBook phoneBook = new PhoneBook();
		String user = phoneBook.createPhoneBook();
		System.out.println(user + "'s Phone Book");
		while (true) {
			try {
				System.out.println(
						"\n1. Press 1 to add a contact\n2. Press 2 to search a contact\n3. Press 3 to update a contact\n4. Press 4 to delete a contact\n5. Press 5 to exit the application\n");
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:					
					phoneBook.addContact();
					break;
				case 2:
					phoneBook.searchContact();
					break;
				case 3:
					phoneBook.updateContact();
					break;
				case 4:
					phoneBook.deleteContact();
					break;
				case 5:
					System.out.println("Exiting the application. Goodbye " + user + "!");
					System.exit(0);
					sc.close();
				default:
					System.out.println("Invalid choice. Please enter a valid option.");

				}
			} catch (PhoneBookException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
