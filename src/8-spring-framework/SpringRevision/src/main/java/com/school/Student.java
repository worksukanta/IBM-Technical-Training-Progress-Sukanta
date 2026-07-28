package com.school;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private int roll;

    public void setName(String name){
        this.name = name;
    }
    public void setRoll(int roll){
        this.roll = roll;
    }
    

    public void display_details(){
        System.out.println("Name: "+this.name+", Roll: "+this.roll);
    }
}
