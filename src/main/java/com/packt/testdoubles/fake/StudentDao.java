package com.packt.testdoubles.fake;

import com.larry.maven.Student;

import java.util.List;

public interface StudentDao {
    public void batchUpdate(List<Student> students);
}
