package Database;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class columnDBTest {
    /**
     *  String dbURL = "jdbc:oracle:thin:@ec2-54-198-30-70.compute-1.amazonaws.com:1521:xe";
     *     String dbUsername = "hr";
     *     String dbPassword = "hr";
     *
     */
    //Query the details for employees whos employee_ID in (150 or 160)
    //SELECT * FROM employees WHERE employee_id in (150 or 160);
    String dbURL = "jdbc:oracle:thin:@ec2-54-198-30-70.compute-1.amazonaws.com:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    /**
     * Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
     *     Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     *
     *     String query = "SELECT employee_id, last_name, job_id, salary FROM employees";
     */
    @Test
    public void allInEmployeeID() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT * FROM departments WHERE location_id IN (1400, 1500)";
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Map<String, Object>> mapList = new ArrayList<>();
        ResultSetMetaData resultSetMetaData1 = resultSet.getMetaData();

        int colCount = resultSetMetaData1.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> rowMap = new HashMap<>();
            for (int col = 1; col <= colCount; col++) {
                rowMap.put(resultSetMetaData1.getColumnName(col), resultSet.getObject(col));
            }
            mapList.add(rowMap);

        }

        for (Map<String, Object> toPrint : mapList) {
            System.out.println(toPrint);
        }
    }

}
