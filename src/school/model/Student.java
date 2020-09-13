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
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	private String registrationNo;
	private String name;
	private Integer studentYear;
	private String phoneNo;
	private String email;
	@Enumerated(EnumType.STRING)
	private Specialization specialization;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Course> courses=new ArrayList<>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy="student", orphanRemoval=true, cascade = CascadeType.REMOVE)
	private List<StudentGrade> grades=new ArrayList<StudentGrade>();
	

	public Student() {}
	public Student(String registrationNo, String name, String phoneNo, String email, Specialization specialization) {
		super();
		this.registrationNo = registrationNo;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.specialization = specialization;
		//this.courses=courses;
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStudentYear() {
		return studentYear;
	}
	public void setStudentYear(Integer studentYear) {
		this.studentYear = studentYear;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<StudentGrade> getGrades() {
		return grades;
	}
	public void setGrades(List<StudentGrade> grades) {
		this.grades = grades;
	}
	
}
