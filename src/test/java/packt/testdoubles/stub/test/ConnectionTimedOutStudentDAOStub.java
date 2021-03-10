package packt.testdoubles.stub.test;

import com.packt.testdoubles.stub.StudentDAO;

import java.sql.SQLException;

public class ConnectionTimedOutStudentDAOStub implements StudentDAO {
    @Override
    public String create(String name, String className) throws SQLException {
        throw new SQLException("DB connection timed out");
    }
}
