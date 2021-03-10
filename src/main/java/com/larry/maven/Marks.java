package com.larry.maven;

import java.math.BigDecimal;

public class Marks {

    private final Student student;
    private final String subjectId;
    private final BigDecimal marks;

    public Marks(Student student, String subjecttId, BigDecimal marks){

        this.student = student;
        this.subjectId = subjecttId;
        this.marks = marks;
    }

    public BigDecimal getMarks() {

        return marks;
    }
}
