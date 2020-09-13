package school.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import school.model.Course;
import school.model.Exam;
import school.service.CourseService;
import school.service.ExamService;

@Controller
public class ExamController {
	
	@Autowired
	CourseService courseService;
	@Autowired
	ExamService examService;
	
	@RequestMapping(method=RequestMethod.GET, value="/exam")
	public String examPage() {
		return "exam";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/examOption")
	public ModelAndView examOptions(ModelAndView mv,HttpServletRequest request) {
		List<Course> courses=courseService.getCourses();
		mv.addObject("courses", courses);
		if(request.getParameter("addExam")!=null) {
			if(courses.get(0).getCourse().equals("No courses registered")){
				mv.setViewName("noCourses");
			}else {
				mv.setViewName("selectExam");
			}
		}else if(request.getParameter("viewExams")!=null) {
			if(examService.getExams().size()<1){
				mv.setViewName("noExams");
			}else{
				mv.setViewName("viewExams");
			}
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addExam")
	public ModelAndView selectExam(ModelAndView mv, @RequestParam("examSelected") String courseSelected, HttpSession session) {
		session.setAttribute("courseSelected", courseSelected);
		List<Exam> exams=examService.getExamsPercentForCourse(courseSelected);
		Double percentExams=examService.getSumOfPercentExamsPerCourse(courseSelected);
		if(percentExams>=100.00) {
			mv.setViewName("addExamFailed");
		}else {
			mv.addObject("exam", courseSelected);
			mv.addObject("exams", exams);
			mv.setViewName("addExams");	
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addExams")
	public ModelAndView addNewExam(ModelAndView mv, HttpServletRequest request) {
	if(request.getParameter("evp")!=null) {
		mv.setViewName("addTest");
	}else if(request.getParameter("session")!=null) {
		mv.setViewName("addSession");
	}else if(request.getParameter("project")!=null) {
		mv.setViewName("addProject");
	}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/saveTestPercent")
	public ModelAndView getTestPercent(ModelAndView mv, HttpSession session,@RequestParam("testPercent") Double percent, @RequestParam("date") String date) throws ParseException {
		String course=(String) session.getAttribute("courseSelected");
		Course courseName=courseService.getCourseByName(course);
		Double sumPercent=examService.getSumOfPercentExamsPerCourse(course);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date dateConverted=sdf.parse(date);
		String examType="EVP Test";
		if(percent>100 ||(sumPercent+percent)>100) {
			mv.setViewName("addExamFailed");
		}else {
			Exam exam=new Exam();
			exam.setCourse(courseName);
			exam.setPercent(percent);
			exam.setExamType(examType);
			exam.setDateOfExam(dateConverted);
			courseName.getExams().add(exam);
			examService.saveExam(exam);
			courseService.updateCourse(courseName);
			mv.setViewName("testPercentSaved");
			mv.addObject("course", courseName);
			mv.addObject("percent", percent);
			mv.addObject("examType", examType);
			mv.addObject("date", date);
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/saveProjectPercent")
	public ModelAndView getProjectPercent(ModelAndView mv, HttpSession session,@RequestParam("projectPercent") Double percent, @RequestParam("date") String date) throws ParseException {
		String course=(String) session.getAttribute("courseSelected");
		Course courseName=courseService.getCourseByName(course);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date dateConverted=sdf.parse(date);
		String examType="PROJECT";
		Double sumPercent=examService.getSumOfPercentExamsPerCourse(course);
		if(percent>100 ||(sumPercent+percent)>100) {
			mv.setViewName("addExamFailed");
		}else {
			Exam exam=new Exam();
			exam.setCourse(courseName);
			exam.setPercent(percent);
			exam.setExamType("PROJECT");
			exam.setDateOfExam(dateConverted);
			courseName.getExams().add(exam);
			examService.saveExam(exam);
			courseService.updateCourse(courseName);
			mv.setViewName("projectPercentSaved");
			mv.addObject("course", courseName);
			mv.addObject("percent", percent);
			mv.addObject("examType", examType);
			mv.addObject("date", date);
		}
		return mv;
	}
	@RequestMapping(method=RequestMethod.POST, value="/saveSessionPercent")
	public ModelAndView getSessionPercent(ModelAndView mv, HttpSession session,@RequestParam("sessionPercent") Double percent, @RequestParam("date") String date) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date dateConverted=sdf.parse(date);
		String course=(String) session.getAttribute("courseSelected");
		Course courseName=courseService.getCourseByName(course);
		Double sumPercent=examService.getSumOfPercentExamsPerCourse(course);
		String examType="SESSION";
		if(percent>100 ||(sumPercent+percent)>100) {
			mv.setViewName("addExamFailed");
		}else {
			Exam exam=new Exam();
			exam.setCourse(courseName);
			exam.setPercent(percent);
			exam.setExamType("SESSION");
			exam.setDateOfExam(dateConverted);
			courseName.getExams().add(exam);
			examService.saveExam(exam);
			courseService.updateCourse(courseName);
			mv.setViewName("sessionPercentSaved");
			mv.addObject("course", courseName);
			mv.addObject("percent", percent);
			mv.addObject("examType", examType);
			mv.addObject("date", date);
		}
		return mv;
	}
}
