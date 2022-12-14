package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
            Book addressBookMain = new Book();
            while (true)
            {
                System.out.println("-----------------------------");
                System.out.println("1. Create a new Contact");
                System.out.println("2. Enter Available Contact Details");
                System.out.println("3. Edit Contact");
                System.out.println("4. Delete Contact");
                System.out.println("5. Exit");
                System.out.print("Enter Option: ");
                int option = sc.nextInt();
                switch (option)
                {
                    case 1:
                        addressBookMain.createNewContact();
                        break;
                    case 2:
                        addressBookMain.fillContactDetails();
                        break;
                    case 3:
                        addressBookMain.editContact();
                        break;
                    case 4:
                        addressBookMain.deleteContact();
                        break;
                    case 5:
                        System.out.println("exiting address book....");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error..! Please Enter valid Choice");
                        break;
                }

            }
    }
}
