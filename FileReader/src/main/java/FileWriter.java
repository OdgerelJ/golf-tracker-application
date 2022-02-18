import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

    public static void main(String[] args) throws FileNotFoundException {

        BasicDataSource dataSource = new BasicDataSource();  // where we are getting the data from
        dataSource.setUrl("jdbc:postgresql://localhost:5432/golf_db"); // set the url for the local db UnitedStates
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  // set the JdbcTemplate to the dataSource

        String fName = "dbCleaned.txt";
        PrintWriter writer = new PrintWriter(new File(fName));

        String readDbSql = "SELECT course_id, course_name, address, city, state_name, zipcode, lat, lng FROM golf_courses";
        SqlRowSet results = jdbcTemplate.queryForRowSet(readDbSql);

        while (results.next()){
            int course_id = results.getInt("course_id");
            String course_name = results.getString("course_name");
            String address = results.getString("address");
            String city = results.getString("city");
            String state_name = results.getString("state_name");
            int zipcode = results.getInt("zipcode");
            double lat = results.getDouble("lat");
            double lng = results.getDouble("lng");
            writer.println(course_id + "," + course_name + "," + address + "," + city + "," + state_name + "," + zipcode + "," + lat + "," + lng);
        }
        writer.close();
    }
}
