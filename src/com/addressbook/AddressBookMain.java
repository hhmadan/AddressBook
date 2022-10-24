package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {
        static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws Exception
        {
            Book addressBookMain = new Book();
            while (true)
            {
                System.out.println("-----------------------------");
                System.out.println("1.Create a new Contact");
                System.out.println("2. Enter Available Contact Details");
                System.out.println("3.Exit");
                System.out.print("Enter Option: ");
                int option = scanner.nextInt();
                switch (option)
                {
                    case 1:
                        addressBookMain.createNewContact();
                        break;
                    case 2:
                        addressBookMain.fillContactDetails();
                        break;
                    case 3:
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
