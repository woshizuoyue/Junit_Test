package com.larry.maven.test;

import com.packt.testdoubles.stub.CreateStudentResponse;
import com.packt.testdoubles.stub.StudentService;
import com.packt.testdoubles.stub.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import packt.testdoubles.stub.test.ConnectionTimedOutStudentDAOStub;

public class StudentServiceTest {
    private StudentService studentService;

    @Test
    public void when_connection_times_out_then_the_student_is_not_saved(){

        studentService = new StudentServiceImpl(new ConnectionTimedOutStudentDAOStub());

        String classNine = "IX";
        String johnSmith = "john Smith";

        CreateStudentResponse resp = studentService.create(johnSmith, classNine);

        Assert.assertFalse(resp.isSuccess());
    }
}
