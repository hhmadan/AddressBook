package com.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    static final Scanner sc = new Scanner(System.in);
    static ArrayList<String> voidContacts = new ArrayList<>();
    static ArrayList<String> nonVoidContacts = new ArrayList<>();

    void createNewContact() throws Exception
    {
        System.out.print("Enter New Contact Name: ");
        String contactName = sc.nextLine();
        File file = new File(contactName);
        if (file.exists())
        {
            System.out.println(file.getName() + " Already exists..!");
        }
        else
        {
            if (file.createNewFile())
            {
                System.out.println("New Contact " + file.getName() + " is created Successfully..!");
                voidContacts.add(file.getName());
            }
        }

    }
    void fillContactDetails() throws Exception
    {
        System.out.print("Enter Contact Name having details missing:");
        String contactName = sc.nextLine();
        if (voidContacts.contains(contactName))
        {

            FileWriter fw = new FileWriter(contactName);
            String details = "";
            System.out.print("Enter first name:");
            details += sc.nextLine() + "\n";
            System.out.print("Enter last name:");
            details += sc.nextLine() + "\n";
            System.out.print("Enter address:");
            details += sc.nextLine() + "\n";
            System.out.print("Enter city:");
            details += sc.nextLine() + "\n";
            System.out.print("Enter state:");
            details += sc.nextLine() + "\n";
            System.out.print("Enter zip:");
            details += sc.nextLine() + "\n";
            System.out.print("Enter mobile number:");
            details += sc.nextLine() + "\n";
            fw.write(details);
            voidContacts.remove(contactName);
            nonVoidContacts.add(contactName);
            System.out.println("Contact Saved Successfully..!");
            fw.close();
        }
        else
        {
            System.out.println(contactName + " Already exists or Not created..!");
        }

    }

}
