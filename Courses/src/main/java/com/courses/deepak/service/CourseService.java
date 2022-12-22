package com.courses.deepak.service;

import java.util.List;



import com.courses.deepak.models.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course  getCourses(long courseID);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deletCourse(long parseLong);

	
	
}
