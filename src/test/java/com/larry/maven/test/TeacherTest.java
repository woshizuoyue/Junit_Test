package com.larry.maven.test;

import com.larry.maven.DummyStudent;
import com.larry.maven.Grades;
import com.larry.maven.Marks;
import com.larry.maven.Teacher;
import org.junit.Test;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TeacherTest {
    @Test
    public void when_marks_above_seventy_five_percent_returns_very_good(){

        DummyStudent dummyStudent = new DummyStudent();

        Marks inEnglish = new Marks(dummyStudent, "English002", new BigDecimal("81.00"));

        Marks inMath = new Marks(dummyStudent, "Math005", new BigDecimal("97.00"));

        Marks inHistory = new Marks(dummyStudent, "History007", new BigDecimal("79.00"));

        List<Marks> marks = Arrays.asList(inHistory, inMath, inEnglish);

        Grades grade = new Teacher().generateGrade(marks);

        assertEquals(Grades.VeryGood, grade);
    }
}
