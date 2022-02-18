import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Location {


    public static void main(String[] args) throws FileNotFoundException {

        RestTemplate rt = new RestTemplate();

        File file = new File("dbCleaned.txt");
        Scanner fileScanner = new Scanner(file);
        String key = "AIzaSyAK5lkEFlfsXeuBKTAdVInZPq3pBveOZVo";
        fileScanner.nextLine();
//        int x = 0;

        PrintWriter writer = new PrintWriter(new File ("withLocation.csv"));

        while(fileScanner.hasNextLine()) { // && x <= 10) {
//            x++;

            String line = fileScanner.nextLine();

            String[] lineArr = line.split(",");

            String courseId = lineArr[0];
            String course_name = lineArr[1];
            String address = lineArr[2];
            String city = lineArr[3];
            String state_name = lineArr[4];
            int zipcode = Integer.parseInt(lineArr[5]);
            String addr = "address=" +
                    address + ", " + city + ", " + state_name + " " + zipcode + "&key=" + key;

            ObjectNode result = rt.getForObject("https://maps.googleapis.com/maps/api/geocode/json?" + addr, ObjectNode.class);
            JsonNode object = result.get("results").get(0);
            double lat = 0;
            double lng = 0;
            try {
                lat = object.findValue("lat").asDouble();
                lng = object.findValue("lng").asDouble();

                writer.println(courseId + "," + course_name + "," + address + "," + city + "," + state_name + "," + zipcode + "," + lat + "," + lng);

            } catch (Exception e) {
                System.out.println("Error with course id " + courseId);
            }
        }
        writer.close();
    }
}
