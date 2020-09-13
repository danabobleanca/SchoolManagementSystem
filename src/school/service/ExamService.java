package school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.dao.ExamDao;
import school.model.Exam;
import school.model.StudentGrade;

@Service
public class ExamService {

	@Autowired
	ExamDao examDao;
	
	public void saveExam(Exam exam) {
		examDao.saveExam(exam);
	}
	
	public List<Exam> getExamsPercentForCourse(String course){
		return examDao.getExamsPercentForCourse(course);
	}
	
	public Double getSumOfPercentExamsPerCourse(String course) {
		return examDao.getSumOfPercentExamsPerCourse(course);
	}
	public Exam getExamByType(String examType) {
		return examDao.getExamByType(examType);
	}
	public List<Exam> getExams(){
		return examDao.getExams();
	}
	
	public Exam getExamById(Integer id) {
		return examDao.getExamById(id);
	}
}
