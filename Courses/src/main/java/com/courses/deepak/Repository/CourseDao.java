package com.courses.deepak.Repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courses.deepak.models.Course;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {

	 //List<Course> findByIdIn(List<Long> id);
}
