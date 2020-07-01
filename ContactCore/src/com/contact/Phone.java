package com.contact;

import java.util.Scanner;

public class Phone {

	public static void main(String[] args) {

		
		Service add = new Service();
		Scanner value = new Scanner(System.in);
		do {
			System.out.println("1.Add Contact \n2.Delete Contact \n3.Replace \n4.Search \n5.Sort \n6.favourite");
			int choose = value.nextInt();
			switch (choose) {
			case 1:
				add.addContact();
				//service.addContact();
				break;
			case 2:
				add.deleteContact();
				//service.deleteContact();
				break;
			case 3:
				add.replace();
				//service.replace();
				break;
			case 4://pass the input and print output hear
				System.out.println("Searching enter phone  no");
				String number = value.next();
				System.out.println(add.search(number));
				break;
			case 5:
				add.sortData();
				//service.sortData();
				break;
			case 6:
				add.favourite();
				break;
			default:
				System.out.println("Wrong option");
				System.exit(0);
			}
		} while (true);
	}

}
