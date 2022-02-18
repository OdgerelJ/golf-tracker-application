import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        BasicDataSource dataSource = new BasicDataSource();  // where we are getting the data from
        dataSource.setUrl("jdbc:postgresql://localhost:5432/golf_db"); // set the url for the local db UnitedStates
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  // set the JdbcTemplate to the dataSource

        try {

            String sql = "INSERT INTO temp_golf_courses (course_name, address, city, state_name, zipcode, lat, lng) VALUES (?, ?, ?, ?, ?, ?, ?)";

            File file = new File("7992.csv");
            Scanner fileScanner = new Scanner(file);
            String key = "AIzaSyAK5lkEFlfsXeuBKTAdVInZPq3pBveOZVo";
            fileScanner.nextLine();
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //System.out.println(line);
                String[] lineArr = line.split(",");

                String course_name = lineArr[0].substring(1,lineArr[0].length() - 1);
                String address = lineArr[1].substring(1,lineArr[1].length() - 1);
                String city = lineArr[2].substring(1,lineArr[2].length() - 1);
                String state_name = lineArr[3].substring(1,3);
                int zipcode;
                if(lineArr[4] == "" || lineArr[4].length() <= 7) {
                    continue;
                } else {
                    zipcode = Integer.parseInt(lineArr[4].substring(1,6));
                }
                String addr = "address=" +
                        address +", " + city + ", " + state_name + " " + zipcode + "&key=" + key;
                System.out.println("https://maps.googleapis.com/maps/api/geocode/json?address=" +
                        addr + "&key=" + key);

                RestTemplate rt = new RestTemplate();



                ObjectNode result = rt.getForObject("https://maps.googleapis.com/maps/api/geocode/json?"+ addr, ObjectNode.class);
                JsonNode object = result.get("results").get(0);
                double lat = 0;
                double lng = 0;
                try {
                    lat = object.findValue("lat").asDouble();
                    lng = object.findValue("lng").asDouble();
//                System.out.println(lat);
//                System.out.println(lng);

                    jdbcTemplate.update(sql, course_name, address, city, state_name, zipcode, lat, lng);
                } catch (Exception e){

                }
            }

            fileScanner.close();

            String distinctSql = "INSERT INTO golf_courses (course_name, address, city, state_name, zipcode) " +
                    "SELECT DISTINCT course_name, address, city, state_name, zipcode FROM temp_golf_courses";
            jdbcTemplate.update(distinctSql);

            jdbcTemplate.update("DROP TABLE if exists temp_golf_courses");


        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
                // write from db to file for future loads.


    }


}
