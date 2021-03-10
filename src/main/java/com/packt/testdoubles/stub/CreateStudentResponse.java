package com.packt.testdoubles.stub;

import com.larry.maven.Student;

public class CreateStudentResponse {

    private final String errorMessage;
    private final Student student;

    public CreateStudentResponse(String errorMessage, Student student){
        this.errorMessage = errorMessage;
        this.student = student;
    }

    public boolean isSuccess(){

        return null == errorMessage;
    }
    public Student getStudent() {
        return student;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
