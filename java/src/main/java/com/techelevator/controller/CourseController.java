package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class CourseController {

    @Autowired
    CourseDao courses;

    @RequestMapping(path = "/allCourses" , method = RequestMethod.GET)
    public List<Course> listCourse(){
        logTimestamp("Getting all courses"); // logging time of request
        List<Course>allCourses = courses.getCourses(); //Get all courses from database

        return allCourses; //return the data requested
    }

    @GetMapping("course/{id}")
    public Course returnCourseById(@PathVariable int id) {
        logTimestamp("Returning course "+ id); // log time of request
        Course aCourse = courses.getCourseByID(id); // Get the course with the supplied id from the database
        return aCourse;
    }

    /**
     * Lecture m02d13-serverside API part1 lecture final
     * Return all courses that match a specific filter
     *
     * path course/filter?city=xxx&zipcode=yyy
     * @param city the city to filter by
     * @return courses that match the filter
     */
    @RequestMapping(path = "course/filter", method= RequestMethod.GET)
    public List<Course> filterByCity(@RequestParam String city){
        List<Course> courseList = listCourse(); //calling up top list all course method
        List<Course> filteredList = new ArrayList<>(); // empty list to add filtered courses
        logTimestamp("Getting all courses specific search by city " + city);
        for (Course course: courseList){ // looping through courseList
            if(course.getCity().equalsIgnoreCase(city)){
                filteredList.add(course);
            }
        }
        return filteredList;
    }

    @RequestMapping(path = "course/filterzipcode", method= RequestMethod.GET)
    public List<Course> filterByZipcode(@RequestParam int zipcode){
        List<Course> courseList = listCourse(); //calling up top list all course method
        List<Course> filteredList = new ArrayList<>(); // empty list to add filtered courses
        logTimestamp("Getting all courses specific search by zipcode number " + zipcode);
        for (Course course: courseList){ // looping through courseList
            if(course.getZipcode() ==(zipcode)){
                filteredList.add(course);
            }
        }
        return filteredList;
    }

    @RequestMapping(path = "/findCourses", method = RequestMethod.GET)
    public Course filterBySearch(@RequestParam String search) throws Exception {
        Course courseList = courses.findByCourseName(search);
        System.out.println(courseList);
        logTimestamp("Getting course by  " + search);
     return courseList;
    }


    static void logTimestamp(String msg) {    // log timestamp of request to Console
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }


}
