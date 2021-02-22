package jpa.entitymodels;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@Column(name = "email")
	private String sEmail;
	
	@Basic
	@Column(name = "name")
	private String sName;
	
	@Basic
	@Column(name = "password")
	private String sPass;
	
	@OneToMany(targetEntity = Course.class)
	private List<Course> sCourses;
	
	//Default constructor
	public Student() {}

	//Parameterized constructor
	public Student(String sEmail, String sName, String sPass) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
	}
	
	//Constructor with list
	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	//Getters and Setters
	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getCourseList() {
		return sCourses;
	}

	public void setCourseList(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

	//toString method
	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPass=" + sPass + ", sCourses=" + sCourses + "]";
	}
}
