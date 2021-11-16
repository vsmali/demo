package com.demoapplication.demo.practice1;

import java.util.Scanner;

public class Useroperation {

        public void MainOperation(){
            System.out.println("Enter the file : ");
            UserOperations userOperations = new UserOperations();
            // checks the input file format.
            userOperations.CheckFileFormatOperation();
            int choice;
            do {
                System.out.println("----------------------------------------");
                System.out.println("1.Search the user record based on the UserCode.");
                System.out.println("2.Search the record of who has completed maximum jobs.");
                System.out.println("3.Print records in alphabetic order by name.");
                System.out.println("4.Write the records in a diff file which prefers a remote job.");
                System.out.println("5.Send email to support@gigvistas.com if there is an inactive member.");
                System.out.println("6.Exiting from the process.");
                System.out.println("----------------------------------------");
                System.out.println("Enter your choice: ");
                Scanner scan = new Scanner(System.in);
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("1.Search the user record based on the UserCode.");
                        userOperations.SearchUserCodeOperation();
                        break;

                    case 2:
                        System.out.println("2.Search the record of who has completed maximum jobs.");
                        userOperations.SearchMaxJobCompletion();
                        break;

                    case 3:
                        System.out.println("3.Print records in alphabetic order by name.");
                        userOperations.SortByAlphabeticOrder();
                        break;

                    case 4:
                        System.out.println("4.Write the records in a diff file which prefers a remote job.");
                        userOperations.CreateFileConsistRemoteJobs();
                        break;

                    case 5:
                        System.out.println("5.Send email to support@gigvistas.com if there is an inactive member.");
                        //userOperations.();
                        break;

                    default:
                        System.out.println("Exiting from the process....");
                        break;
                }
            } while (choice != 6);


        }
}
