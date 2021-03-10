package com.packt.testdoubles.stub;

import com.larry.maven.Student;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO){

        this.studentDAO = studentDAO;

    }

    @Override
    public CreateStudentResponse create(String name, String studentOfclass) {

        CreateStudentResponse response = null;

        try{
            String roleNum = studentDAO.create(name, studentOfclass);

            response = new CreateStudentResponse(null, new Student(roleNum, name));

        }catch (SQLException e) {

            response = new CreateStudentResponse("SQLException" + e.getMessage(), null);
        }

        catch (Exception e){

            response = new CreateStudentResponse(e.getMessage(), null);
        }

        return response;

    }
}
