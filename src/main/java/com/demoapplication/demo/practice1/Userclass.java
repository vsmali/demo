package com.demoapplication.demo.practice1;

public class Userclass implements Comparable {
    private String usercode;
    private String name;
    private String  jobs_completed;
    private String preffered_location;
    private String inactive;

    public Userclass() {
    }

    public Userclass(String usercode,
                     String name,
                     String jobs_completed,
                     String preffered_location,
                     String inactive) {
        this.usercode = usercode;
        this.name = name;
        this.jobs_completed = jobs_completed;
        this.preffered_location = preffered_location;
        this.inactive = inactive;
    }


    @Override
    public String toString() {
        return usercode+","+name+","+jobs_completed+","+preffered_location+","+inactive;
    }

    @Override
    public int compareTo(Object o) {
        Userclass comparingTo = (Userclass)o;
        int diff = name.compareTo(comparingTo.name);
        return diff;
    }


}

