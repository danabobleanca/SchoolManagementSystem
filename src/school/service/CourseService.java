package school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.dao.CourseDao;
import school.model.Course;
import school.model.Specialization;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;
	public void saveCourse(Course course) {
		courseDao.saveCourse(course);
	}
	
	public List<Course> getCourses(){
		return courseDao.getCourses();
	}
	
	public Course getCourseByName(String courseName){
		return courseDao.getCourseByName(courseName);
	}
	
	public List<Course> getCoursesBySpecialization(Specialization specialization){
		return courseDao.getCoursesBySpecialization(specialization);
	}
	public void setTeacherForCourseAsNull(String registrationNo) {
		courseDao.setTeacherForCourseAsNull(registrationNo);
	}
	
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}
}
