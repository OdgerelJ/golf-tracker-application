import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NewDBWriter {
    public static void main(String[] args) throws FileNotFoundException {
        BasicDataSource dataSource = new BasicDataSource();  // where we are getting the data from
        dataSource.setUrl("jdbc:postgresql://localhost:5432/golf_db"); // set the url for the local db UnitedStates
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  // set the JdbcTemplate to the dataSource
        String sql = "INSERT INTO golf_courses (course_name, address, city, state_name, zipcode, lat, lng) VALUES (?, ?, ?, ?, ?, ?, ?)";

        File file = new File("withLocation.csv");
        Scanner fileScanner = new Scanner(file);
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            //System.out.println(line);
            String[] lineArr = line.split(",");

            int courseID = Integer.parseInt(lineArr[0]);
            String course_name = lineArr[1];
            String address = lineArr[2];
            String city = lineArr[3];
            String state_name = lineArr[4];
            int zipcode = Integer.parseInt(lineArr[5]);

            double lat = Double.parseDouble(lineArr[6]);
            double lng = Double.parseDouble(lineArr[7]);

            jdbcTemplate.update(sql, course_name, address, city, state_name, zipcode, lat, lng);
        }
        fileScanner.close();
    }
}
