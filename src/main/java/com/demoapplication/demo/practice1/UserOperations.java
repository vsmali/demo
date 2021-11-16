package com.demoapplication.demo.practice1;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class UserOperations {

    Scanner sc = new Scanner(System.in);
    String filename;
    List<Userclass> users = new ArrayList<>();

    public UserOperations(List<Userclass> user) {
        this.users = user;
    }


    public  void CheckFileFormatOperation(){
//        File file = new File(filename);
//        if(file.exists())
//        {
//            System.out.println("File Exist and File Extension is : "+ FilenameUtils.getExtension(filename));
//        }
//        else{
//                System.out.println("File does not exist");
//        }
    }


    public void SearchUserCodeOperation(){
        System.out.println("Enter the user code");
        String userCode = sc.next();
        for (Userclass user : users) {
            if (userCode.equals(user.getUsercode())) {
                System.out.println(user.toString());
            }
        }
    }


    public void SortByAlphabeticOrder() {
            Collections.sort(users);
            System.out.println("After sorting : ");
            System.out.println(users);

        }

    public void SearchMaxJobCompletion(){
        for (Userclass u3 : users){
//            users.sort(Comparator.comparing(Userclass::getJobs_completed));
//            List<Integer> ls = new ArrayList<Integer>();
//            ls.add(u3.getJobs_completed());
//            Collections.max(ls);
//            System.out.println(u3.getUsercode() + "," + u3.getName() + "," + u3.getJobs_completed() + "," + u3.getPreffered_location() + "," + u3.isInactive());
            System.out.println(users);
        }
    }

    public void CreateFileConsistRemoteJobs(){
        try{
            System.out.println("Enter Preferred Location : ");
            String location = sc.next();
            FileWriter writer = new FileWriter("E:\\1.Practice\\demo\\sample.csv");
            for (Userclass u2 : users) {
                if (location.equals(u2.getPreffered_location())) {
                    System.out.println(u2.getUsercode() + "," + u2.getName() + "," + u2.getJobs_completed() + "," + u2.getPreffered_location() + "," + u2.isInactive());
                    writer.append(u2.getUsercode());
                    writer.append(",");
                    writer.append(u2.getName());
                    writer.append(",");
                    writer.append(Integer.toString(u2.getJobs_completed()));
                    writer.append(",");
                    writer.append(u2.getPreffered_location());
                    writer.append(",");
                    writer.append(Boolean.toString(u2.isInactive()));
                    writer.append("\n");
                }
            }

            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
