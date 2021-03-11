package packt.testdoubles.fake.test;

import com.larry.maven.Student;
import com.packt.testdoubles.fake.StudentDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest {
    private TestableStudentDao dao;
    private Map<String, Integer> sqlCount = null;

    @Before
    public void setup(){
        dao = new TestableStudentDao();
        sqlCount = new HashMap<String, Integer>();
    }

    @Test(expected = IllegalStateException.class)
    public void when_row_count_does_not_match_then_rollbacks_transaction(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(null, "Gautam Kohli"));

        int[] expect_udpate_fails_count = {0};
        dao.valuesToReturn = expect_udpate_fails_count;
        dao.batchUpdate(students);
    }

    @Test
    public void when_new_student_then_creates_student(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(null, "Gautam Kohli"));

        int[] expect_update_sucess = {1};
        dao.valuesToReturn = expect_update_sucess;
        dao.batchUpdate(students);

        int actualInsertCount = sqlCount.get("insert");
        int expectedInsertCount = 1;
        Assert.assertEquals(expectedInsertCount, actualInsertCount);
    }

    @Test
    public void when_existing_student_then_updates_student_successfully(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("001", "Mark Leo"));
        int[] expect_update_success = {1};
        dao.valuesToReturn = expect_update_success;
        dao.batchUpdate(students);

        int actualUpdateCount = sqlCount.get("update");
        int expectedUpdate = 1;
        Assert.assertEquals(expectedUpdate, actualUpdateCount);
    }

    @Test
    public void when_new_and_existing_students_then_creates_and_updates_students(){
        List<Student> students = new ArrayList<>();

        students.add(new Student("001", "Mark Joffe"));
        students.add(new Student(null, "John Villare"));
        students.add(new Student("002", "Maria, Rubinho"));

        dao.batchUpdate(students);
    }
    class TestableStudentDao extends StudentDaoImpl{
        int[] valuesToReturn;
        int[] update(String sql, List<Map<String, Object>> params){
            Integer count = sqlCount.get(sql);
            if(count == null){
                sqlCount.put(sql, params.size());

            }else{
                sqlCount.put(sql, count + params.size());
            }

            if(valuesToReturn != null){
                return valuesToReturn;
            }

            int[] val = new int[params.size()];
            for(int i = 0; i<params.size(); i++){
                val[i] = 1;
            }

            return val;
        }
    }
}
