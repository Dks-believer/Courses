package com.courses.deepak.service;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.deepak.Repository.CourseDao;
import com.courses.deepak.models.Course;

@Service
public class CourseServiceImpl implements CourseService {
    
	@Autowired
	private CourseDao courseDao;
//	List<Course>list= new ArrayList<>();
//	
//	
//	public CourseServiceImpl(List<Course> list) {
//		super();
//		list.add(new Course(123,"Java core","javastudents"));
//		list.add(new Course(9879,"Spring core","Spring students"));
//		
//		this.list = list;
//	}


	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();	}


	@Override
	public Course getCourses(long courseID) {
		//Course c= null;
//		 
//		 for(Course course:list) {
//			 if(course.getId()==courseID) {
//				 c=course;
//				 break;
//			 }
//		 }
//		return c;
		return courseDao.getOne(courseID);
	}


	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
		
	}


	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDesc(course.getDesc());
//			}
//		});
//		return course;
		courseDao.save(course);
		return course;
	}


	@Override
	public void deletCourse(long parseLong) {
		//list=this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());
		Course entity = courseDao.getById(parseLong);
		courseDao.delete(entity);
		
	}


	

}
