package com.courses.deepak.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.courses.deepak.models.Course;
import com.courses.deepak.service.CourseService;

@RestController
public class MyController {
	
	@Autowired  //creates the object of tthe implementation class of the interface and will inject inside the methods of interface(acc to ruleof injection)
	private CourseService courseService;
	
	@GetMapping("/test")
	public String courses() {
		 return "This is home page of the courses";
	}
	
	@GetMapping("/courses")
	public List<Course>  getCourses() //here it is demanding to service layer that give me all the courses
	                                    //so service layer will make interface and its implementation class
	{
	  	return this.courseService.getCourses(); //has a relation ,getcourse method of interface wiil be called as it has no implemented method it will call implementation class..runtime polymorphism
	}
	
	@GetMapping("/courses/{courseID}")
	public Course getCourses(@PathVariable String courseID) {
		return this.courseService.getCourses(Long.parseLong(courseID));
	}
	
	@PostMapping("/courses")  //@PostMapping(path="/courses",consumes="application/json")
	public Course addCourses(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseID}")
	public ResponseEntity<HttpStatus> deletCourse(@PathVariable String courseID){
		try {
			  this.courseService.deletCourse(Long.parseLong(courseID));
			 return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
