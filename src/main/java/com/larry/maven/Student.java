package com.larry.maven;

public class Student {
    private final String roleNumber;
    private final String name;

    public Student(String roleNumber, String name){
        this.roleNumber = roleNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRoleNumber() {
        return roleNumber;
    }

}
