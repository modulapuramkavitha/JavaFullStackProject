package SpringProject.StudentManagementSystemUsingSpring.Model;

import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@DynamicUpdate
@Entity
public class School {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable=false, unique=true,length=10,updatable=true)
		private Integer schoolCode;
		@Column(nullable=false, unique=true,length=100,updatable=true)
		private String schoolName ;
		@Override
		public String toString() {
			return "School [schoolCode=" + schoolCode + ", schoolName=" + schoolName + ", schoolLocation=" + schoolLocation
					+ ", schoolFounder=" + schoolFounder + ", establishedYear=" + establishedYear + ", principalName="
					+ principalName + "]";
		}

		@Column(nullable=false, unique=true,length=100,updatable=true)
		private String schoolLocation;
		@Column(nullable=false, unique=true,length=100,updatable=false)
		private String schoolFounder;
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
		@Column(nullable=true, unique=true,length=100,updatable=false)
		private Date establishedYear;
		@Column(nullable=false, unique=true,length=100,updatable=true)
		private String principalName;
		public Integer getSchoolCode() {
			return schoolCode;
		}
		public void setSchoolCode(Integer schoolCode) {
			this.schoolCode = schoolCode;
		}
		public String getSchoolName() {
			return schoolName;
		}
		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}
		public String getSchoolLocation() {
			return schoolLocation;
		}
		public void setSchoolLocation(String schoolLocation) {
			this.schoolLocation = schoolLocation;
		}
		public String getSchoolFounder() {
			return schoolFounder;
		}
		public void setSchoolFounder(String schoolFounder) {
			this.schoolFounder = schoolFounder;
		}
		public Date getEstablishedYear() {
			return establishedYear;
		}
		public void setEstablishedYear(Date establishedYear) {
			this.establishedYear = establishedYear;
		}
		public String getPrincipalName() {
			return principalName;
		}
		public void setPrincipalName(String principalName) {
			this.principalName = principalName;
		}
	
	
	
	
	
}
