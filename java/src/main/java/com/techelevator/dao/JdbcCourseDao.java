package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.security.PermitAll;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcCourseDao implements CourseDao {
    private JdbcTemplate template;

    public JdbcCourseDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }
    //display first 10 Courses
    @PreAuthorize("permitAll")
    public List<Course> getCourses() {
        List<Course> courseList = new ArrayList<>();
        String sql = "SELECT * from golf_courses ORDER BY course_name ASC";
        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
            courseList.add(mapResultToCourse(results));
        }
        return courseList;
    }



    public Course getCourseByID(int id)  {
        String sqlGetCourse = "SELECT * FROM golf_courses WHERE course_id = ?";
        SqlRowSet result = template.queryForRowSet(sqlGetCourse, id);
        if (result.next()) {
            return mapResultToCourse(result);
        } else {
            throw new RuntimeException("CourseId "+id+" was not found.");
        }
    }

//    public List<Course> findByCourseName(String courseName){
//        List<Course> courseList = new ArrayList<>();
//        String sql = "SELECT course_name, address, city, state_name, zipcode FROM golf_courses WHERE course_name ILIKE ? ";
//        SqlRowSet results = template.queryForRowSet(sql, courseName);
//        while (results.next()) {
//            courseList.add(mapResultToCourse(results));
//        }
//        return courseList;
//    }

    public Course findByCourseName(String courseName) throws Exception{
        for(Course course: this.getCourses()){
            if(course.getCourseName().toLowerCase().contains(courseName.toLowerCase())){
                return course;
            }
        }
        throw new Exception("Course "+ courseName +  " was not found");
    }


//    Search by Zipcode need to test
    public Course findByZipcode(int zipcode){
        String sql = "SELECT course_name, address, city, state_name, zipcode FROM golf_courses WHERE zipcode ILIKE ? ";
        SqlRowSet result = template.queryForRowSet(sql, zipcode);
        if(result.next()){
            return mapResultToCourse(result);
        }
        throw new RuntimeException("Course named " + zipcode + " was not found.");
    }


    private Course mapResultToCourse(SqlRowSet rs) {
        Course course = new Course();
        course.setCourseId(rs.getInt("course_id"));
        course.setCourseName(rs.getString("course_name"));
        course.setAddress(rs.getString("address"));
        course.setCity(rs.getString("city"));
        course.setStateName(rs.getString("state_name"));
        course.setZipcode(rs.getInt("zipcode"));
        course.setLatitude(rs.getDouble("lat"));
        course.setLongitude(rs.getDouble("lng"));

        return course;
    }

}
