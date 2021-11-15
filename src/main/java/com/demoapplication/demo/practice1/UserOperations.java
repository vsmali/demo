package com.demoapplication.demo.practice1;

import com.opencsv.CSVReader;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UserOperations {

    Scanner sc = new Scanner(System.in);
    File filename = new File(sc.nextLine());
    String f = filename.getName();
    String currentline;
    ArrayList<Userclass> user = new ArrayList<>();

    public void CheckFileFormatOperation()
    {
        // checks the input file format.
        try{
            if(filename.exists()){
                System.out.println("File exist");
                String regex = "([^\\s]+(\\.(?i)(csv|txt|xls))$)";
                if(f.matches(regex)){
                    System.out.println("File Format Matches \n"+f + " file extension is : " + FilenameUtils.getExtension(f));
                }
                else {
                    System.out.println("File not exist");
                }
            }
            else {
                System.out.println("File Doesnot Exist");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void SearchUserCodeOperation(){
        //Search the record based on user code.
        System.out.println("Enter usercode to search : ");
        String usercode = sc.next();
        String line = "";
        try{
            Scanner s = new Scanner(filename);
            while (s.hasNextLine()) {
                line = s.nextLine();
                if (line.startsWith(usercode)) {
                    System.out.println(line);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void SortByAlphabeticOrder() {
        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((currentline = br.readLine() )!= null){
                String[] deatailed = currentline.split(",");
                String usercode = deatailed[0];
                String name = deatailed[1];
                String jobs_completed = deatailed[2];
                String preffered_location = deatailed[3];
                String inactive = deatailed[4];
                user.add(new Userclass(usercode,name,jobs_completed,preffered_location,inactive));
            }
            System.out.println(user);
            Collections.sort(user);
            System.out.println(user);
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    public void SearchMaxJobCompletion(){
        try {
            CSVReader reader = new CSVReader(new FileReader(filename));
            String[] nextLine;
            int lineNumber = 0;
            String line = "";
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[2]);
            }
            int size = nextLine[2].length();
            String nextline1 = nextLine[2];
            System.out.println(nextline1);
//            for(int i = 0; i<size-1; i++)
//            {
//                for (int j = i+1; j<size; j++)
//                {
//                    //compares each elements of the array to all the remaining elements
//                    if(nextline1[i].compareTo(nextLine[2][j])>0)
//                    {
//                        //swapping array elements
//                        String temp = nextLine[2][i];
//                        nextLine[2][i] = nextLine[2][j];
//                        nextLine[2][j] = temp;
//                    }
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void CreateFileConsistRemoteJobs(){
        //Search the record based on user code.
        System.out.println("Enter usercode to search : ");
        String usercode = sc.next();
        String line = "";
        try{
            Scanner s = new Scanner(filename);
            while (s.hasNextLine()) {
                line = s.nextLine();
                if (line.startsWith(usercode)) {
                    System.out.println(line);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
