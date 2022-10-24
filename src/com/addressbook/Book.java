package com.addressbook;

import java.io.File;
import java.io.FileReader;
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
    void editContact()throws Exception
    {
        System.out.print("Enter Name of the contact to edit:");
        String contactName = sc.nextLine();
        if(voidContacts.contains(contactName))
        {
            System.out.println("Please fill the details of "+ contactName + " before editing it");
            return;
        }
        else if(!nonVoidContacts.contains(contactName))
        {
            System.out.println("Please create the contact "+ contactName +" before editing it");
            return;
        }
        System.out.println("\nThe details of " + contactName + " at present is:");
        readFile(contactName);
        System.out.println("\nEnter details to edit...\nFirst Name:\nLast Name:\nAddress:\nCity:\nState:\nZip:\nMobile Number: ");
        String newContent="";
        for (int i = 1; i <= 7; i++)
        {
            newContent += sc.nextLine() + "\n";
        }
        String option;
        do
        {
            System.out.println("Press\nS for SAVE        C for CANCEL");
            option = sc.nextLine();
        } while (!(option.equalsIgnoreCase("s")  || option.equalsIgnoreCase("c")));
        switch(option)
        {
            case "s":
            case "S":
                writeFile(contactName, newContent);
                System.out.println(contactName + " is saved with new content");
                break;
            case "c":
            case "C":
                System.out.println("changes are not saved");
                return;
            default:
                System.out.println("please select either S or C");
        }

    }
    void readFile(String fileName)throws Exception
    {
        FileReader fileReader = new FileReader(fileName);
        int character;
        while ((character = fileReader.read()) != -1)
        {
            System.out.print((char) character);
        }
        fileReader.close();
    }
    void writeFile(String fileName,String content)throws Exception
    {
        FileWriter fw = new FileWriter(fileName);
        fw.write(content);
        fw.close();
    }
    void deleteContact()
    {
        System.out.print("Enter contact name to delete:");
        String contactName = sc.nextLine().trim();
        File file = new File(contactName);
        if(file.exists())
        {
            if(file.delete())
            {
                if(voidContacts.contains(contactName))
                {
                    voidContacts.remove(contactName);
                }
                else
                {
                    nonVoidContacts.remove(contactName);
                }
                System.out.println(contactName + " is deleted Successfully..!");
            }
        }
        else
        {
            System.out.println(contactName + " doesn't exists");
        }
    }
}
