package com.techelevator.dao;

import com.techelevator.model.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getCourses();

    Course getCourseByID(int id);

    Course findByCourseName(String courseName) throws Exception;
}
