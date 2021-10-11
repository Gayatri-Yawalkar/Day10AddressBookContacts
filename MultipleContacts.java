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
	public int displayMenu() {
		System.out.println("1.Add Contact");
		System.out.println("2.Edit Contact");
		System.out.println("3.Search Contact Details");
		System.out.println("4.Show All Contact");
		System.out.println("5.Delete Contact");
		System.out.println("6.Quit");
		System.out.println("Enter Your Choice from 1 to 6");
		return scanner.nextInt();
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
		arrayList.add(newContact);
		System.out.println("Contact is Successfully Added to AddressBook");
	}
	public void showContact() {
		int i=searchContact();
		if(i>=0) {
			System.out.println("Name="+arrayList.get(i).firstLastName);
			System.out.println("Address="+arrayList.get(i).address);
			System.out.println("City="+arrayList.get(i).city);
			System.out.println("State="+arrayList.get(i).state);
			System.out.println("Zip="+arrayList.get(i).zip);
			System.out.println("Mobile Number="+arrayList.get(i).phoneNum);
			System.out.println("Email"+arrayList.get(i).email);
		}
	}
	public void showAllContacts() {
		for(int i=0;i<arrayList.size();i++) {
			System.out.println("Contact "+(i+1)+" Detalis");
			System.out.println("Name="+arrayList.get(i).firstLastName);
			System.out.println("Address="+arrayList.get(i).address);
			System.out.println("City="+arrayList.get(i).city);
			System.out.println("State="+arrayList.get(i).state);
			System.out.println("Zip="+arrayList.get(i).zip);
			System.out.println("Mobile Number="+arrayList.get(i).phoneNum);
			System.out.println("Email="+arrayList.get(i).email);
		}
	}
	public int searchContact() {
		int index=-1;
		System.out.println("Enter Name of person");
		scanner.nextLine();
		String name=scanner.nextLine();
		for(int i=0;i<arrayList.size();i++) {
			if(name.equalsIgnoreCase(arrayList.get(i).firstLastName)) {
				index=i;
			}
		}
		if(index==-1) {
			System.out.println("Contact Details are not present in address book");
		}
		return index;
	}
	public void editContact() {
		int i=searchContact();
		if(i>=0) {
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
					System.out.println("Enter New Address of "+arrayList.get(i).firstLastName);
					scanner.nextLine();
					arrayList.get(i).address=scanner.nextLine();
					System.out.println("Address of "+arrayList.get(i).firstLastName+" is updated Successfully");
					break;

				case 2:
					System.out.println("Enter New City of "+arrayList.get(i).firstLastName);
					scanner.nextLine();
					arrayList.get(i).city=scanner.nextLine();
					System.out.println("City of "+arrayList.get(i).firstLastName+" is updated Successfully");
					break;
				case 3:
					System.out.println("Enter New State of "+arrayList.get(i).firstLastName);
					scanner.nextLine();
					arrayList.get(i).state=scanner.nextLine();
					System.out.println("State of "+arrayList.get(i).firstLastName+" is updated Successfully");
					break;
				case 4:
					System.out.println("Enter New Zip of "+arrayList.get(i).firstLastName);
					arrayList.get(i).zip=scanner.nextLong();
					System.out.println("Zip of "+arrayList.get(i).firstLastName+" is updated Successfully");
					break;
				case 5:
					System.out.println("Enter New Phone Number of "+arrayList.get(i).firstLastName);
					arrayList.get(i).phoneNum=scanner.nextLong();
					System.out.println("Phone Number of "+arrayList.get(i).firstLastName+" is updated Successfully");
					break;
				case 6:
					System.out.println("Enter New Email of "+arrayList.get(i).firstLastName);
					scanner.nextLine();
					arrayList.get(i).email=scanner.nextLine();
					System.out.println("Email of "+arrayList.get(i).firstLastName+" is updated Successfully");
					break;
				default:
					System.out.println("You have Entered Wrong Choice.Please enter choice between 1 to 6 ");
			}
		}
	}
	public void deleteContact() {
		int i=searchContact();
		if(i>=0) {
			arrayList.remove(i);
			System.out.println("Contact Details are Deleted");
		}
	}
	public static void main(String[] args) {
		MultipleContacts multiple=new MultipleContacts();
		int choice;
		String name;
		int flag=0;
		while(flag==0) {
			choice=multiple.displayMenu();
			switch(choice) {
				case 1:
					multiple.addContact();
					break;
				case 2:
					multiple.editContact();
					break;
				case 3:
					multiple.showContact();
					break;
				case 4:
					multiple.showAllContacts();
				case 5:
					multiple.deleteContact();
					break;
				case 6:
					flag=1;
					break;
				default:
					System.out.println("You have Entered Wrong Choice.Please enter option between 1 to 5");
			}
		}
	}
}
