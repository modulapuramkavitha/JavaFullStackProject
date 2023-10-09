package SpringProject.StudentManagementSystemUsingSpring.Model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student_table")
@DynamicUpdate
/*this class works as a blueprint ,here we have taken private attributes ,
and implement setters and getters for them .*/
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollNum;
	private String studentName;
	private String studentGrade;
	private Integer studentMarks;
	private String studentQualification;	
	private String gender;	
	private String address;
	private Long mobileNumber;
	private Boolean isSecondaryStudent;
	private String schoolName;
	
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", studentName=" + studentName + ", studentGrade=" + studentGrade
				+ ", studentMarks=" + studentMarks + ", studentQualification=" + studentQualification + ", gender="
				+ gender + ", address=" + address + ", mobileNumber=" + mobileNumber + ", isSecondaryStudent="
				+ isSecondaryStudent + ", schoolName=" + schoolName + "]";
	}
	public Integer getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(Integer studentMarks) {
		this.studentMarks = studentMarks;
	}


	public String getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Boolean getIsSecondaryStudent() {
		return isSecondaryStudent;
	}
	
	public void setIsSecondaryStudent(Boolean isSecondaryStudent) {
		this.isSecondaryStudent = isSecondaryStudent;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}
	
	public Integer getRollNum() {
		return rollNum;
		
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentQualification() {
		return studentQualification;
	}
	public void setStudentQualification(String studentQualification) {
		this.studentQualification = studentQualification;
	}
	
	
	
	
}
