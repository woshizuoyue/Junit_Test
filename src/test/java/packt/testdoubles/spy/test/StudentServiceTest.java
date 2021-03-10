package packt.testdoubles.spy.test;

import com.larry.maven.Student;
import com.packt.testdoubles.spy.StudentService;
import com.packt.testdoubles.spy.StudentServiceSpy;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StudentServiceTest {
    StudentService service = new StudentService();
    StudentServiceSpy spy = new StudentServiceSpy();

    @Test
    public void enrolls_students() throws Exception{
        // create student objects

        Student bob = new Student("001","Robert Anthony");
        Student roy = new Student("002","Roy Noon");

        // set spy
        service.setSpy(spy);

        // enroll Bob and Roy
        service.enrollToCourse("english", bob);
        service.enrollToCourse("history", roy);

        // assert that the method was invoked twice

        Assert.assertEquals(2, spy.invocation("enrollToCourse"));

        // get the method arguments for the first call
        List<Object> methodArguments = spy.arguments("enrollToCourse", 1).getParams();

        // get the method arguments for 2nd call
        List<Object> methodArguments2 = spy.arguments("enrollToCourse", 2).getParams();

        // verify Bob
        Assert.assertEquals("english", methodArguments.get(0));
        Assert.assertEquals(bob, methodArguments.get(1));

        // verify Roy
        Assert.assertEquals("history", methodArguments2.get(0));
        Assert.assertEquals(roy, methodArguments2.get(1));
    }
}
