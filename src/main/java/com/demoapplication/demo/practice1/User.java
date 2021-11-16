package com.demoapplication.demo.practice1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class User {
    String filename;
    String currentline;

    public User(String filename) {
        this.filename = filename;
    }
    public List<Userclass> userop(){
            List<Userclass> user = new ArrayList<>();
        try {
            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            while ((currentline = br2.readLine() )!= null){
                String[] deatailed = currentline.split(",");
                String usercode = deatailed[0];
                String name = deatailed[1];
                int jobs_completed = Integer.parseInt(deatailed[2]);
                String preffered_location = deatailed[3];
                boolean inactive = Boolean.parseBoolean(deatailed[4]);
                user.add(new Userclass(usercode,name,jobs_completed,preffered_location,inactive));
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return user;
    }
}
