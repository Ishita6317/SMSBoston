package jpa.entitymodels;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {
	@Id
	@Column(name = "id")
	private int cId;
	
	@Basic
	@Column(name = "name")
	private String cName;
	
	@Basic
	@Column(name = "instructor")
	private String cInstructorName;
	
	//Default constructor
	public Course() {
		
	}
	
	//Parameterized constructor
	public Course(int cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	//Getter and Setter
	public int getcId() {
		return cId;
	}
	
	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	//toString method
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cInstructorName=" + cInstructorName + "]";
	}
}
