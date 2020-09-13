package school.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import school.model.Course;
import school.model.Specialization;
import school.model.Student;

@Repository
public class CourseDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void saveCourse(Course course) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(course);
		tx.commit();
	}
	
	public List<Course> getCourses() {
		String query="SELECT c FROM Course c";
		Query courses=hibernateTemplate.getSessionFactory().openSession().createQuery(query);
		List<Course> coursesList=courses.list();
		if(coursesList.size()>0) {
			return coursesList;
		}else {
			Course course=new Course();
			course.setCourse("No courses registered");
			coursesList.add(course);
			return coursesList;
		}
	}
	
	public Course getCourseByName(String courseName){
		String query="SELECT c FROM Course c WHERE c.course=:courseName";
		List<Course> courses=(List<Course>) hibernateTemplate.findByNamedParam(query, "courseName" ,courseName);
		if(courses.size()>0) {
			return courses.get(0);
		}else {
			return null;
		}
	}
	
	public List<Course> getCoursesBySpecialization(Specialization specialization){
		List<Course> coursesBySpecialization=new ArrayList<Course>();
		for(Course c:getCourses()) {
			//Specialization sp=Specialization.valueOf(c.getSpecialization());
				if(c.getSpecialization().equals(specialization)) {
					coursesBySpecialization.add(c);
				}
			}
		return coursesBySpecialization;
	}
	
	public void setTeacherForCourseAsNull(String registrationNo) {
		String setTeacherAsNull="UPDATE Course c SET c.teacher=null WHERE c.teacher.registrationNo=:registrationNo";
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(setTeacherAsNull);
		query.setParameter("registrationNo", registrationNo);
		query.executeUpdate();
		tx.commit();	
	}
	
	public void updateCourse(Course course) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.merge(course);
		tx.commit();
	}
}
