package school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import school.dao.TeacherDao;
import school.model.Teacher;

@Service
public class TeacherService {
	@Autowired
	TeacherDao teacherDao;
		
	public void saveTeacher(Teacher teacher) {
		teacherDao.saveTeacher(teacher);
	}
	
	public List<Teacher> getTeachers(){
		return teacherDao.getTeachers();
	}
	
	public void deleteTeacher(String registrationNo) {
		teacherDao.deleteTeacher(registrationNo);
	}
	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}
}
