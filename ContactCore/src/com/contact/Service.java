package com.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Service {
		
	Scanner value = new Scanner(System.in);
	private static List<Contact> list;
	Contact enter = new Contact();
	Data valid = new Data();

	Service() {
		Service.list = new ArrayList<Contact>();
		Contact no1 = new Contact("Deve", "Siva", "8940833838", "2662792280", "sunderviju@icloude.com", true);
		Contact no2 = new Contact("Deva", "Linga", "8547693287", "2662785622", "sunderviju@gmail.com", false);
		Contact no3 = new Contact("surya", "ganesh", "9486929160", "1662788722", "surya@gmail.com", true);
		list.add(no1);
		list.add(no2);
		list.add(no3);
	}

	public void display() {
		for (Contact key : list) {
			System.out.println(key.toString());
		}
	}

	public void addContact() {
		System.out.println("Enter First Name");
		String firstName = value.next();
		if (valid.isValid(firstName)) {
			enter.setFirstName(firstName);	
		} else {
			System.out.println("Invalide Name");
			enter.setFirstName("");
		}
		System.out.println("Enter Last Name");
		String lastName = value.next();
		if (valid.isValid(lastName)) {
			enter.setLastName(lastName);
		} else {
			System.out.println("Invalide Name");
			enter.setLastName("");
		}
		boolean val = true;
		while(val) 
		{
		System.out.println("Enter Mobile Number");
		String mobileNumber = value.next();
		if (valid.isValidNo(mobileNumber)) {
			enter.setMobileNumber(mobileNumber);
			val = false;
		} else {
			System.out.println("Invalide Mobile No");
			enter.setMobileNumber(null);
			val =true;
		}}
		System.out.println("Enter Home Number");
		String homeNumber = value.next();
		if (valid.isValidNo(homeNumber)) {
			enter.setHomeNumber(homeNumber);
			System.out.println("valid" + homeNumber);
		} else {
			System.out.println("Invalide Home No");
			enter.setHomeNumber(null);
		}
		System.out.println("Enter EmailId");
		String emailId = value.next();
		if (valid.isValidEmail(emailId)) {
			enter.setEmailId(emailId);
			System.out.println("valid " + emailId);
		} else {
			System.out.println("Invalid Email Id");
			enter.setEmailId(null);
		}
		System.out.println("Favourites yes or no");
		String fav = value.next();
		if (fav.equals("yes")) {
			list.add(new Contact(enter.getFirstName(), enter.getLastName(), enter.getMobileNumber(),
					enter.getHomeNumber(), enter.getEmailId(), true));
		} else {
			list.add(new Contact(enter.getFirstName(), enter.getLastName(), enter.getMobileNumber(),
					enter.getHomeNumber(), enter.getEmailId(), false));
		}
		display();
	}

	public void deleteContact() {
		try {
			System.out.println("Enter the Delete Number");
			String num = value.next();
			boolean status = false;
				for(Contact key : list) {
					if(key.getMobileNumber().equals(num)) {
						list.remove(key);
						status = true;
					}
					
				}
			if (status == false) {
				System.out.println("Invalid No");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//display();
	}

	public void replace() {
		try {
			System.out.println("Enter the replace number");
			String number = value.next();
			boolean status = false;
			for (Contact key : list) {
				if (key.getMobileNumber().equals(number)) {
					list.remove(key);
					status = true;
				}
			}
			if (status == false) {
				System.out.println("no valid");
			}else {
				addContact();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String search(String number) {
		try {
			boolean status = false;
			for (Contact key : list) {
				if (key.getMobileNumber().equals(number)) {
					status = true;
					return key.toString();
				}
			}
			if (status == false) {
				return "invalid";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void sortData() {
		Collections.sort(list, new Order());
		display();
	}
	
	public void favourite() {
		for(Contact key : list) {
			if(key.isFavourite()) {
				System.out.println(key.toString());
			}
		}
	}
}

class Order implements Comparator<Contact> {

	public int compare(Contact o1, Contact o2) {
		if (o1.getFirstName().equals(o2.getFirstName())) {
			return o1.getLastName().compareTo(o2.getLastName());
		} else {
			return o1.getFirstName().compareTo(o2.getFirstName());
		}
	}
}