package school.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.dao.ExamDao;
import school.dao.GradeDao;
import school.model.StudentGrade;

@Service
public class GradeService {

	@Autowired
	GradeDao gradeDao;
	
	public void saveStudentGrades(StudentGrade grade) {
		gradeDao.saveStudentGrades(grade);
	}
	
	public void deleteGradesForStudent(String registrationNo) {
		gradeDao.deleteGradesForStudent(registrationNo);
	}
	
	public void updateStudentGrades(StudentGrade grades) {
		gradeDao.updateStudentGrades(grades);
	}
	
	public StudentGrade getStudentGrade(String registrationNo,String course, String examType, Date date) {
		return gradeDao.getStudentGrade(registrationNo, course, examType, date);
	}
}
