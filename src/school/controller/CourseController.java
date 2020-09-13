package school.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import school.model.Course;
import school.model.Specialization;
import school.model.Student;
import school.service.CourseService;
import school.service.StudentService;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET, value="/course")
	public String coursePage() {
		return "course";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/courseOption")
	public ModelAndView courseOption(ModelAndView mv, HttpServletRequest request) {
		if(request.getParameter("addCourse")!=null) {
			List<Specialization> specialization=Specialization.getSpecialization();
			mv.addObject("specialization", specialization);
			mv.setViewName("addCourse");
		}else if(request.getParameter("viewCourses")!=null){
			List<Course> courses=courseService.getCourses();
			mv.addObject("courses", courses);
			mv.setViewName("viewCourses");
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/courseDetails")
	public ModelAndView courseDetails(ModelAndView mv, @RequestParam("specialization") String specialization, @RequestParam("courseName") String courseName) {
		Specialization specializationName=Specialization.valueOf(specialization);
		List<Student> students=studentService.getStudentBySpecialization(specializationName);
		Course course=new Course();
		course.setCourse(courseName);
		course.setSpecialization(specializationName);
		try {
			courseService.saveCourse(course);
			mv.setViewName("courseDetails");
		}catch(Exception e) {
			mv.setViewName("courseExists");
		}
		for(Student s:students) {
			s.getCourses().add(course);
			studentService.updateStudent(s);
		}
		mv.addObject("specialization", specialization);
		mv.addObject("course", courseName);
		return mv;
	}
}
