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
public class ExamDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	public void saveExam(Exam exam) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.merge(exam);
		tx.commit();
	}

	public List<Exam> getExamsPercentForCourse(String course){
		String query="SELECT e from Exam e, Course c WHERE c.course=e.course AND c.course=:course";
		List<Exam> listExams=(List<Exam>) hibernateTemplate.findByNamedParam(query, "course", course);
		return listExams;
	}
	
	public Double getSumOfPercentExamsPerCourse(String course) {
		List<Exam> exams=getExamsPercentForCourse(course);
		Double sumPercent=0.00;
		for(Exam e:exams) {
			sumPercent+=e.getPercent();
		}
		return sumPercent;
	}
	public Exam getExamByType(String examType) {
		String query="SELECT e FROM Exam e WHERE e.examType=:examType";
		List<Exam> exam=(List<Exam>) hibernateTemplate.findByNamedParam(query, "examType", examType);
		return exam.get(0);
	}
	
	public Exam getExamById(Integer id) {
		String query="SELECT e FROM Exam e WHERE e.id=:id";
		List<Exam> exam=(List<Exam>) hibernateTemplate.findByNamedParam(query, "id", id);
		return exam.get(0);
	}
	
	public List<Exam> getExams(){
		String queryString="SELECT e FROM Exam e";
		Query query=hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		List<Exam> exams=query.list();
		return exams;
	}
}
