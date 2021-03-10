package com.larry.maven;

public class DummyStudent extends Student{

    public DummyStudent(){
        super(null, null);
    }

    public String getRoleNumebr(){

        throw new RuntimeException("Dummy student");
    }

    public String getName(){
        throw new RuntimeException("Dummy student");
    }
}
