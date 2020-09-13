package school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StudentGrade{

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	@OneToOne(orphanRemoval=true)
	private Exam exam;
	private Double grade;
	@ManyToOne
	private Student student;
	
	public StudentGrade() {}
	public StudentGrade(Exam exam, Double grade, Student student) {
		super();
		this.exam = exam;
		this.grade = grade;
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
}
