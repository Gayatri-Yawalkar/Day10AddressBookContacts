package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;
//Uc5
public class MultipleContacts {
	ArrayList<Contacts> arrayList;
	Scanner scanner;
	public MultipleContacts() {
		arrayList=new ArrayList<>();
		scanner=new Scanner(System.in);
	}
	public static void main(String[] args) {
		MultipleContacts multiple=new MultipleContacts();
		int numberOfContact;
		char choice;
		String name;
		System.out.println("How many number of contacts do you want to add");
		numberOfContact=multiple.scanner.nextInt();
		for(int i=1;i<=numberOfContact;i++) {
			System.out.println("Contact "+i);
			multiple.addContact();
		}
		System.out.println("Do you want to Edit any contact:y/n");
		choice=multiple.scanner.next().toUpperCase().charAt(0);
		if(choice=='Y') {
			System.out.println("Enter full name of person to edit contact details");
			multiple.scanner.nextLine();
			name=multiple.scanner.nextLine();
			multiple.editContact(name);
		}
		System.out.println("Do you want to Delete any contact:y/n");
		choice=multiple.scanner.next().toUpperCase().charAt(0);
		if(choice=='Y') {
			System.out.println("Enter full name of person to edit contact details");
			multiple.scanner.nextLine();
			name=multiple.scanner.nextLine();
			multiple.deleteContact(name);
		}
		System.out.println("Do you want to add new contact:y/n");
		choice=multiple.scanner.next().toUpperCase().charAt(0);
		if(choice=='Y') {
			multiple.addContact();
		}
		else {
			System.out.println("Thank You");
		}
	}
	public void addContactToAddressBook(Contacts contact) {
		arrayList.add(contact);
		System.out.println("Contact is Successfully Added to AddressBook");
	}
	public void editContactFromAddressBook(Contacts contact,int index) {
		arrayList.add(index,contact);
		System.out.println("Contact is Successfully Updated to AddressBook");
	}
	public void deleteContactFromAddressBook(Contacts contact,int index) {
		arrayList.remove(index);
	}
	public void addContact() {
		System.out.println("Enter Below Details to create new Contact");
		System.out.println("Enter Full Name");
		scanner.nextLine();
		String firstLastName=scanner.nextLine();
		System.out.println("Enter Address");
		String address=scanner.nextLine();
		System.out.println("Enter City");
		String city=scanner.nextLine();
		System.out.println("Enter State");
		String state=scanner.nextLine();
		System.out.println("Enter Zip");
		long zip=scanner.nextLong();
		System.out.println("Enter Phone Number");
		long phoneNum=scanner.nextLong();
		System.out.println("Enter Email");
		scanner.nextLine();
		String email=scanner.nextLine();
		Contacts newContact=new Contacts(firstLastName,address,city,state,zip,phoneNum,email);
		addContactToAddressBook(newContact);
	}
	public void editContact(String name) {
		int i;
		for(i=0;i<arrayList.size();i++) {
			if(name.equalsIgnoreCase(arrayList.get(i).firstLastName)) {
				Contacts contact=arrayList.get(i);
				System.out.println("Enter the field you want to change");
				System.out.println("1.Address");
				System.out.println("2.City");
				System.out.println("3.State");
				System.out.println("4.Zip");
				System.out.println("5.Phone Number");
				System.out.println("6.Email");
				System.out.println("Choose Option from 1 to 6");
				int choice=scanner.nextInt();
				switch(choice) {
					case 1:
						System.out.println("Enter New Address of "+contact.firstLastName);
						scanner.nextLine();
						contact.address=scanner.nextLine();
						editContactFromAddressBook(contact,i);
						break;
						
					case 2:
						System.out.println("Enter New City of "+contact.firstLastName);
						scanner.nextLine();
						contact.city=scanner.nextLine();
						editContactFromAddressBook(contact,i);
						break;
					case 3:
						System.out.println("Enter New state of "+contact.firstLastName);
						scanner.nextLine();
						contact.state=scanner.nextLine();
						editContactFromAddressBook(contact,i);
						break;
					case 4:
						System.out.println("Enter New Zip of "+contact.firstLastName);
						contact.zip=scanner.nextLong();
						
						editContactFromAddressBook(contact,i);
						break;
					case 5:
						System.out.println("Enter New Phone Number of "+contact.firstLastName);
						contact.phoneNum=scanner.nextLong();
						editContactFromAddressBook(contact,i);
						break;
					case 6:
						System.out.println("Enter New Email of "+contact.firstLastName);
						scanner.nextLine();
						contact.email=scanner.nextLine();
						editContactFromAddressBook(contact,i);
						break;
					default:
						System.out.println("You have Entered Wrong Choice.Please enter choice between 1 to 6 ");
				}
				break;
			}
		}
		if(i>=arrayList.size()) {
			System.out.println("You have Entered Name which is not Present in your Address Book");
		}
	}
	public void deleteContact(String name) {
		int i;
		for(i=0;i<arrayList.size();i++) {
			if(name.equalsIgnoreCase(arrayList.get(i).firstLastName)) {
				Contacts contact=arrayList.get(i);
				deleteContactFromAddressBook(contact,i);
				break;
			}
		}
		if(i>=arrayList.size()) {
			System.out.println("You have Entered Name which is not Present in your Address Book");
		}
	}
}
