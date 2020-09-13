package school.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	private String registrationNo;
	private String name;
	private String phoneNo;
	private String email;
	@OneToMany(mappedBy="teacher")
	private List<Course> courses=new ArrayList<Course>();
	
	public Teacher() {}
	public Teacher(String registrationNo, String name, String phoneNo, String email, List<Course> courses) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.courses = courses;
		this.registrationNo=registrationNo;
	}

	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

}
