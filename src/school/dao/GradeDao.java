package school.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import school.model.Exam;
import school.model.StudentGrade;

@Repository
public class GradeDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void saveStudentGrades(StudentGrade grades) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(grades);
		tx.commit();
	}
	
	public void deleteGradesForStudent(String registrationNo) {
		String queryString="DELETE FROM StudentGrade sg WHERE sg.student.registrationNo=:registrationNo";
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(queryString);
		query.setParameter("registrationNo", registrationNo);
		query.executeUpdate();
		tx.commit();
	}
	
	
	public StudentGrade getStudentGrade(String registrationNo,String course, String examType, Date date) {
		String queryString="SELECT sg from StudentGrade sg WHERE sg.student.registrationNo=:registrationNo AND sg.exam.course.course=:course AND  sg.exam.examType=:examType AND sg.exam.dateOfExam=:date AND sg.grade is not NULL";
		Query query=hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("registrationNo",registrationNo);
		query.setParameter("course", course);
		query.setParameter("examType", examType);
		query.setParameter("date", date);
		List<StudentGrade> grades=query.list();
		if(grades.size()<1) {
			return null;
		}else {
			return grades.get(0);
		}
	}
	
	public void updateStudentGrades(StudentGrade grades) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.merge(grades);
		tx.commit();
	}
}
