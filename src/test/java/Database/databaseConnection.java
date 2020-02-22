package Database;

import org.junit.Test;

import java.sql.*;
import java.util.*;

public class databaseConnection {

    // ec2-54-198-30-70.compute-1.amazonaws.com

    String dbURL = "jdbc:oracle:thin:@ec2-54-198-30-70.compute-1.amazonaws.com:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void dbConnectionJDBC() throws SQLException {
        Connection con = DriverManager.getConnection(dbURL,dbUsername,dbPassword);

    }

    /**
     * dbConnectionJDBC will set a connection to ORACLE db
     * Connection takes dbURL, dbUsername, dbPassword as parameters
     * Statement will allow us to scroll
     * ResulSet will execute query
     * Example in executeQuery: select * from employees
     * @throws java.sql.SQLException
     *
     */


    /**
     * Write a query that will print the count of employees working in department_id 100
     */

    /**
     * Query the first 5 employees in the table
     */

@Test
    public void dbMetadata() throws SQLException {
    Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    String query = "SELECT employee_id, last_name, job_id, salary FROM employees";

    ResultSet resultSet = statement.executeQuery(query);

    //Database SQL collect the metadata
    DatabaseMetaData dbMetadata = connection.getMetaData();
    System.out.println("User: " + dbMetadata.getUserName());
    System.out.println("Database type: " + dbMetadata.getDatabaseProductName());

    //Result set Metadata
    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    System.out.println("Columns count " + resultSetMetaData.getColumnCount());
    System.out.println(resultSetMetaData.getColumnName(1));

//    for(int i = 0 ; i < resultSetMetaData.getColumnCount(); i++){
//        System.out.println(i + " ---> " + resultSetMetaData.getColumnName(i));
//    }

    List<Map<String, Object>> mapList = new ArrayList<>();
    ResultSetMetaData resultSetMetaData1 = resultSet.getMetaData();

    int colCount = resultSetMetaData1.getColumnCount();

    while(resultSet.next()){
        Map<String, Object> rowMap = new HashMap<>();
        for(int col = 1; col <= colCount; col++){
            rowMap.put(resultSetMetaData1.getColumnName(col),resultSet.getObject(col));
        }
        mapList.add(rowMap);
//        System.out.println(mapList.keySet() + " ---> " + mapList.values());
    }

        for (Map<String,Object> toPrint : mapList) {
//            System.out.println(toPrint);
            System.out.println(toPrint.get("SALARY"));
    }






//    while(resultSet.next()) {
//        mapList.put()
//    }
}
}
