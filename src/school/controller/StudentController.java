package school.controller;

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
import school.model.Exam;
import school.model.Specialization;
import school.model.Student;
import school.model.StudentGrade;
import school.service.CourseService;
import school.service.ExamService;
import school.service.GradeService;
import school.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	@Autowired
	ExamService examService;
	@Autowired
	GradeService gradeService;
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String welcome() {
		return "student";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/student")
	public ModelAndView studentPage(ModelAndView mv, HttpServletRequest request, Model model) {
		List<Student> students=studentService.getAllStudents();
		if(request.getParameter("addStudent")!=null) {
			mv.setViewName("addStudent");
			model.addAttribute("student", new Student());
			List<Specialization> specializations=Specialization.getSpecialization();
			mv.addObject("specializations", specializations);
		}else if(request.getParameter("viewStudents")!=null){
			mv.setViewName("viewStudents");
			mv.addObject("allStudents", students);
		}else if(request.getParameter("studentGrade")!=null) {
			mv.setViewName("gradesOption");
			mv.addObject("students", students);
	}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/studentDetails")
	public ModelAndView studentSaved(ModelAndView mv, @ModelAttribute("student") Student student) {
		Student studentData=new Student(student.getRegistrationNo(), student.getName(), student.getPhoneNo(), student.getEmail(), student.getSpecialization());
		studentData.setStudentYear(1);
		studentData.setCourses(courseService.getCoursesBySpecialization(student.getSpecialization()));
		try {
			mv.setViewName("studentDetails");
			studentService.saveStudent(studentData);
			mv.addObject("student", studentData);
		}catch(Exception e) {
			mv.setViewName("studentExists");
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/deleteOrUpdate")
	public ModelAndView deleteStudent(ModelAndView mv, HttpServletRequest request) {
		List<Student> students=studentService.getAllStudents();
		for(Student s:students) {
			if((request.getParameter(s.getRegistrationNo())!=null)){
				String name=request.getParameter(s.getRegistrationNo());
				if(name.equals("Delete")) {
					mv.setViewName("studentDeleted");
					gradeService.deleteGradesForStudent(s.getRegistrationNo());
					studentService.deleteStudent(s.getRegistrationNo());
					mv.addObject("student", s);
				}else if(name.equals("Update")) {
					mv.setViewName("updateStudent");
					mv.addObject("studentToUpdate", s);
					List<Specialization> specializations=Specialization.getSpecialization();
					mv.addObject("specializations", specializations);
				}
			}else {
				continue;
			}
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/studentUpdated")
	public ModelAndView updateStudent(ModelAndView mv, @ModelAttribute("studentToUpdate") Student student) {
		student.setCourses(courseService.getCoursesBySpecialization(student.getSpecialization()));
		studentService.updateStudent(student);
		mv.setViewName("studentUpdated");
		mv.addObject("student", student);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/gradesOption")
	public ModelAndView gradesOption(ModelAndView mv, HttpServletRequest request, HttpSession session) {
		List<Student> students=studentService.getAllStudents();
		for(Student s:students) {
			if(request.getParameter(s.getRegistrationNo())!=null) {
				String regNo=request.getParameter(s.getRegistrationNo());
				List<Course> courses=s.getCourses();
				session.setAttribute("studentToAddGrade", s);
				mv.addObject("courses", courses);
				if(regNo.equals("Add Grades")) {
					if(courses.size()==0) {
						mv.setViewName("noCourses");
					}else {
						mv.setViewName("selectCourse");
					}
					//mv.addObject("student", s);
				}else if(regNo.equals("View Student Grades")) {
					mv.setViewName("viewGrades");
					mv.addObject("student", s);
				}
			}else {
				continue;
			}
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/selectExamType")
	public ModelAndView selectExamType(ModelAndView mv, HttpSession session, HttpServletRequest request, @RequestParam("course") String courseName) {
		Student student=(Student) session.getAttribute("studentToAddGrade");
		Course course=courseService.getCourseByName(courseName);
		if(course.getExams().size()==0){
			mv.setViewName("noExams");
		}else {
			session.setAttribute("courseGrades", course);
			mv.addObject("student", student);
			mv.addObject("course", course);
			mv.setViewName("selectExamType");	
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addGrades")
	public ModelAndView addGrades(ModelAndView mv, HttpSession session, @RequestParam("examSelected") Integer id) {
		Student student=(Student) session.getAttribute("studentToAddGrade");
		Course course=(Course) session.getAttribute("courseGrades");
		Exam exam=examService.getExamById(id);
		session.setAttribute("exam", exam);
		mv.addObject("exam",exam);
		mv.addObject("student", student);
		mv.addObject("course", course);
		//mv.addObject("studentGrades", grades);*/
		mv.setViewName("addGrades");
		return mv;
	} 
	
	@RequestMapping(method=RequestMethod.POST, value="/gradeAdded")
	public ModelAndView gradeAdded(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		Student student=(Student) session.getAttribute("studentToAddGrade");
		Course course=(Course) session.getAttribute("courseGrades");
		Exam exam=(Exam) session.getAttribute("exam");
		//List<Exam> exams=course.getExams();
		//StudentGrade sg=new StudentGrade();
		String grade=request.getParameter(String.valueOf(exam.getId()));
		StudentGrade sg=gradeService.getStudentGrade(student.getRegistrationNo(), course.getCourse(), exam.getExamType(), exam.getDateOfExam());
		if(sg==null) {
			sg=new StudentGrade();
			sg.setExam(exam);
			sg.setStudent(student);
			sg.setGrade(Double.parseDouble(grade));
			gradeService.saveStudentGrades(sg);
			mv.setViewName("gradeAdded");
			studentService.updateStudent(student);
		}else if(sg!=null){
			mv.setViewName("gradeExists");
		}
		mv.addObject("course", course);
		mv.addObject("student", student);
		mv.addObject("exam", exam);
		mv.addObject("grade", Double.parseDouble(grade));
		
		return mv;
	}
}
