package school.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import school.model.Course;
import school.model.Teacher;
import school.service.CourseService;
import school.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(method=RequestMethod.GET, value="/teacher")
	public String teacherPage() {
		return "teacher";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/teacherOption")
	public ModelAndView teacherOption(ModelAndView mv, Model model, HttpServletRequest request) {
		if(request.getParameter("addTeacher")!=null) {
			List<Course> courses=courseService.getCourses();
			if(courses.get(0).getCourse().equals("No courses registered")){
				mv.setViewName("noCourses");
			}else {
				model.addAttribute("teacher", new Teacher());
				mv.setViewName("addTeacher");
				mv.addObject("courses", courses);
			}
		}else if(request.getParameter("viewTeachers")!=null) {
			List<Teacher> teachers=teacherService.getTeachers();
			mv.addObject("teachers", teachers);
			mv.setViewName("viewTeachers");
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/teacherDetails")
	public ModelAndView teacherDetails(ModelAndView mv, @ModelAttribute("teacher") Teacher teacher, @RequestParam("course") String[] courses) {
		List<Course> coursesList=new ArrayList<>();
		Course course=new Course();
		for(String c:courses) {
			course.setCourse(c);
			coursesList.add(course);
		}
		Teacher teacherDetails=new Teacher(teacher.getRegistrationNo(),teacher.getName(),teacher.getPhoneNo(),  teacher.getEmail(),coursesList);
		try {
			teacherService.saveTeacher(teacherDetails);
			mv.setViewName("teacherDetails");
		}catch(Exception e){
			mv.setViewName("teacherExists");
		}
		for(String c:courses) {
			Course courseByName=courseService.getCourseByName(c);
			if(courseByName!=null) {
				courseByName.setTeacher(teacherDetails);
				courseService.updateCourse(courseByName);
			}
		}
		mv.addObject("courses", courses);
		mv.addObject("teacher", teacherDetails);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/deleteOrUpdateTeacher")
	public ModelAndView deleteOrUpdate(ModelAndView mv, HttpServletRequest request) {
		List<Teacher> teachers=teacherService.getTeachers();
		for(Teacher t:teachers) {
			if(request.getParameter(t.getRegistrationNo())!=null) {
				String name=request.getParameter(t.getRegistrationNo());
				if(name.equals("Update")) {
					mv.setViewName("updateTeacher");
					List<Course> courses=courseService.getCourses();
					List<Course> teacherCourses=t.getCourses();
					List<Course> uncheckedCourses=new ArrayList<>();
					List<String> courseString=new ArrayList<>(); 
					for(Course c:teacherCourses) {
						courseString.add(c.getCourse());
					}
					for(Course c:courses) {
						if(!courseString.contains(c.getCourse())) {
							uncheckedCourses.add(c);
						}
					}
					mv.addObject("teacherCourses", teacherCourses);
					mv.addObject("courses", courses);
					mv.addObject("teacherToUpdate", t);
					mv.addObject("uncheckedCourses", uncheckedCourses);
				}else if(name.equals("Delete")) {
					mv.setViewName("teacherDeleted");
					mv.addObject("teacher", t);
					courseService.setTeacherForCourseAsNull(t.getRegistrationNo());
					teacherService.deleteTeacher(t.getRegistrationNo());
				}
			}else {
				continue;
			}
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/teacherUpdated")
	public ModelAndView updateTeacher(ModelAndView mv, @ModelAttribute("teacherToUpdate") Teacher teacher,@RequestParam("course") String[] courses) {
		List<Course> coursesList=new ArrayList<>();
		Course course=new Course();
		for(String c:courses) {
			course.setCourse(c);
			coursesList.add(course);
		}
		teacher.setCourses(coursesList);
		teacherService.updateTeacher(teacher);
		for(String c:courses) {
			Course courseByName=courseService.getCourseByName(c);
			if(courseByName!=null) {
				courseByName.setTeacher(teacher);
				courseService.updateCourse(courseByName);
			}
		}
		mv.addObject("teacher", teacher);
		mv.addObject("courses", courses);
		mv.setViewName("teacherUpdated");
		return mv;
	}
	
	
}
