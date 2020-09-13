package school.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {

	@Id
	private String course;
	@Enumerated(EnumType.STRING)
	private Specialization specialization;
	@ManyToOne
	private Teacher teacher;
	@OneToMany(mappedBy="course", fetch = FetchType.EAGER, orphanRemoval=true,cascade = CascadeType.REMOVE)
	private List<Exam> exams=new ArrayList<Exam>();
	@ManyToMany(mappedBy="courses", fetch = FetchType.EAGER)
	private List<Student> students=new ArrayList<>();
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
