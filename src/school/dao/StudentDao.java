package school.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import school.model.Specialization;
import school.model.Student;
import school.service.GradeService;

@Repository
public class StudentDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	public void saveStudent(Student student) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(student);
		tx.commit();
	}
	
	public List<Student> getAllStudents(){
		String queryString="SELECT s FROM Student s";
		Query query=hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		List<Student> students=query.list();
		return students;
	}
	
	public void deleteStudent(String registrationNo) {
		String stringQuery="DELETE from Student WHERE registrationNo=:registrationNo";
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(stringQuery);
		query.setParameter("registrationNo", registrationNo);
		query.executeUpdate();
		tx.commit();
	}
	
	public Student getStudentByRegistrationNo(String registrationNo) {
		String queryString="SELECT s FROM Student s WHERE s.registrationNo=:registrationNo";
		List<Student> students=(List<Student>) hibernateTemplate.findByNamedParam(queryString, "registrationNo", registrationNo);
		if(students.size()>0) {
			return students.get(0);
		}else {
			return null;
		}
	}
	
	public void updateStudent(Student student) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.merge(student);
		tx.commit();
	}
	public List<Student> getStudentBySpecialization(Specialization specialization) {
		String select="SELECT s FROM Student s WHERE s.specialization=:specialization";
		List<Student> students=(List<Student>) hibernateTemplate.findByNamedParam(select, "specialization",specialization);
		return students;
	}
}
