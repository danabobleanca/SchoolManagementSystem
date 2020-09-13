package school.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.dao.StudentDao;
import school.model.Specialization;
import school.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	public void deleteStudent(String registrationNo) {
		studentDao.deleteStudent(registrationNo);
	}
	
	public Student getStudentByRegistrationNo(String registrationNo) {
		return studentDao.getStudentByRegistrationNo(registrationNo);
	}
	
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}
	
	public List<Student> getStudentBySpecialization(Specialization specialization){
		return studentDao.getStudentBySpecialization(specialization);
	}
}
