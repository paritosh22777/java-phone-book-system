package com.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PhoneBook {
	private static List<Contact> phonebook = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public String createPhoneBook() {
		System.out.print("Enter the username for the phonebook: ");
		String name = sc.next();
		System.out.println("\nPhonebook with name " + name + " created.");
		return name;
	}

	public void addContact() throws PhoneBookException {
		System.out.print("Enter the contact name: ");
		String name = sc.next();
		System.out.print("Enter the phone number: ");
		String phoneNumber = sc.next();
		if (!phoneNumber.matches("\\d+")){
			throw new PhoneBookException("Phone number should contain digits only.");
		}		if (phoneNumber.length() != 10) {
			throw new PhoneBookException("Phone number must contain 10 digits only.");
		}
		Contact contact = new Contact(name, phoneNumber);
		phonebook.add(contact);
		System.out.println("Contact added to the phonebook.");
	}

	public void searchContact() {
		if (phonebook.isEmpty()) {
			System.out.println("The phone book is empty. Please insert some contacts.");
			return;
		}
		boolean flag = false;
		System.out.print("Enter a name or pattern to search: ");
		String pattern = sc.next();		
		for (Contact contact : phonebook) {
			System.out.println("Search results:");
			if (contact.getName().contains(pattern) || contact.getPhoneNumber().contains(pattern)) {
				flag = true;
				System.out.println(contact);
			}
		}
		if (!flag) {
			System.out.println("Contact with pattern " + pattern + " does not exist.");
		}
	}

	public void updateContact() throws PhoneBookException {
		if (phonebook.isEmpty()) {
			System.out.println("The phone book is empty. Please insert some contacts.");
			return;
		}
		System.out.print("Enter the name of the contact to update: ");
		String name = sc.next();
		for (Contact contact : phonebook) {
			if (contact.getName().equals(name)) {
				System.out.print("Enter the new phone number: ");
				String phoneNumber = sc.next();
				if (!phoneNumber.matches("\\d+")){
					throw new PhoneBookException("Phone number should contain digits only.");
				}
				if (phoneNumber.length() != 10) {
					throw new PhoneBookException("Phone number must contain 10 digits only.");
				}
				contact.setPhoneNumber(phoneNumber);
				System.out.println("Contact updated.");
				return;
			}
		}
		System.out.println("Contact not found in the phonebook.");
	}

	public void deleteContact() {
		if (phonebook.isEmpty()) {
			System.out.println("The phone book is empty. Please insert some contacts.");
			return;
		}
		System.out.print("Enter the name of the contact to delete: ");
		String name = sc.next();
		for (Contact contact : phonebook) {
			if (contact.getName().equals(name)) {
				phonebook.remove(contact);
				System.out.println("Contact deleted.");
				return;
			}
		}
		System.out.println("Contact not found in the phonebook.");
	}
}