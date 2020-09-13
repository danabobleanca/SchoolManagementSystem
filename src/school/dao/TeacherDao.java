package school.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import school.model.Student;
import school.model.Teacher;

@Repository
public class TeacherDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void saveTeacher(Teacher teacher) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(teacher);
		tx.commit();
	}
	
	public List<Teacher> getTeachers(){
		String queryString="SELECT t FROM Teacher t";
		Query query=hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		List<Teacher> teachers=query.list();
		return teachers;
	}
	
	public void deleteTeacher(String registrationNo) {
		String queryString="DELETE from Teacher WHERE registrationNo=:registrationNo";
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(queryString);
		query.setParameter("registrationNo", registrationNo);
		query.executeUpdate();
		tx.commit();
	}
	
	public void updateTeacher(Teacher teacher) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.merge(teacher);
		tx.commit();
	}
}
