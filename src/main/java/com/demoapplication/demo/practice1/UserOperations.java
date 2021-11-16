package com.demoapplication.demo.practice1;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.Callable;

public class UserOperations {

    Scanner sc = new Scanner(System.in);
    File filename = new File(sc.nextLine());
    String f = filename.getName();

    String currentline;
    int count=0;
    List<Userclass> user = new ArrayList<>();

    public void CheckFileFormatOperation(){
        try{
            if(filename.exists()){
                System.out.println("File exist");
//                String regex = "([^\\s]+(\\.(?i)(csv|txt|xls))$)";
//                if(f.matches(regex)){
                    System.out.println("File Format Matches \n"+f + " file extension is : " + FilenameUtils.getExtension(f));
                }
                else {
                    System.out.println("File Does not exist");
                }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void SearchUserCodeOperation(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            System.out.println("Enter usercode to search : ");
            String usercode1 = sc.next();
            while ((currentline = br.readLine()) != null) {
                String[] deatailed = currentline.split(",");
                String usercode = deatailed[0];
                String name = deatailed[1];
                int jobs_completed = Integer.parseInt(deatailed[2]);
                String preffered_location = deatailed[3];
                boolean inactive = Boolean.parseBoolean(deatailed[4]);
                user.add(new Userclass(usercode, name, jobs_completed, preffered_location, inactive));
                if (usercode1.equals(usercode)) {
                    count++;
                    System.out.println(usercode + "," + name + "," + jobs_completed + "," + preffered_location + "," + inactive);
                }
            }
        }
        catch (Exception e){
            System.out.println("User not exist!");
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
                int jobs_completed = Integer.parseInt(deatailed[2]);
                String preffered_location = deatailed[3];
                boolean inactive = Boolean.parseBoolean(deatailed[4]);
                user.add(new Userclass(usercode,name,jobs_completed,preffered_location,inactive));
            }
            Collections.sort(user);
            System.out.println("After sorting : ");
            System.out.println(user);
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    public void SearchMaxJobCompletion(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            List<Integer> ls = new ArrayList<Integer>();
            while ((currentline = br.readLine()) != null) {
                String[] deatailed = currentline.split(",");
                String usercode = deatailed[0];
                String name = deatailed[1];
                int jobs_completed = Integer.parseInt(deatailed[2]);
                String preffered_location = deatailed[3];
                boolean inactive = Boolean.parseBoolean(deatailed[4]);
                user.add(new Userclass(usercode, name, jobs_completed, preffered_location, inactive));
                ls.add(jobs_completed);
            }
            System.out.println(Collections.max(ls));
        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }

    public void CreateFileConsistRemoteJobs(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            System.out.println("Enter Preferred Location : ");
            String location = sc.next();
            FileWriter writer = new FileWriter("E:\\1.Practice\\demo\\sample.csv");
            while ((currentline = br.readLine() )!= null){
                String[] deatailed = currentline.split(",");
                String usercode = deatailed[0];
                String name = deatailed[1];
                int jobs_completed = Integer.parseInt(deatailed[2]);
                String preffered_location = deatailed[3];
                boolean inactive = Boolean.parseBoolean(deatailed[4]);
                user.add(new Userclass(usercode,name,jobs_completed,preffered_location,inactive));
                if(location.equals(preffered_location))
                {
                    count ++;
                    System.out.println(usercode+","+name+","+jobs_completed+","+preffered_location+","+inactive );
                    writer.append(usercode);
                    writer.append(",");
                    writer.append(name);
                    writer.append(",");
                    writer.append(Integer.toString(jobs_completed));
                    writer.append(",");
                    writer.append(preffered_location);
                    writer.append(",");
                    writer.append(Boolean.toString(inactive));
                    writer.append("\n");
                }

            } writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
