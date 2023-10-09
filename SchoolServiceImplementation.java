package SpringProject.StudentManagementSystemUsingSpring.StudentServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringProject.StudentManagementSystemUsingSpring.Model.School;
import SpringProject.StudentManagementSystemUsingSpring.Repository.SchoolRepository;
import SpringProject.StudentManagementSystemUsingSpring.Service.SchoolService;


@Service
public class SchoolServiceImplementation implements SchoolService{
		@Autowired
		private SchoolRepository schoolRepository;

		public School saveSchool(School nameofschool) {
			return schoolRepository.save(nameofschool);

		}

		public List<School> getAllSchools() {
			List<School> schools = new ArrayList<School>();
			schools = schoolRepository.findAll();
			return schools;
		}
		public School getSchoolByCode(int schoolCode) {
			Optional<School>school = schoolRepository.findById(schoolCode);  
			if(school.isPresent()) {
				return school.get();
			}
			else {
				return null;
				}
			}
		  public School  updateSchoolDetails(int schoolCode  ,School updatedSchoolName) {
			  Optional<School> school= schoolRepository.findById(schoolCode);
				if(school.isPresent()) {
					School  existingSchool = school.get();
					existingSchool.setSchoolCode(updatedSchoolName.getSchoolCode());
				existingSchool.setSchoolName(updatedSchoolName.getSchoolName());
				existingSchool.setSchoolLocation(updatedSchoolName.getSchoolLocation());
				existingSchool.setPrincipalName(updatedSchoolName.getPrincipalName());
				//existingSchool.setEstablishedYear(updatedSchoolName.getEstablishedYear()); //as updatable =false
				//existingSchool.setSchoolFounder(updatedSchoolName.getSchoolFounder());//as updatable =false
				existingSchool.setPrincipalName(updatedSchoolName.getPrincipalName());
					schoolRepository.save(existingSchool);
					return existingSchool;
				}
				else {
					return null;
				}
		  }
		

	public Optional<School> deleteSchoolByCode(int schoolCode) {
		Optional<School>school = schoolRepository.findById(schoolCode);  
		if(school.isPresent()) {
			schoolRepository.deleteById(schoolCode);
		}
		return school;
	}
	public void deleteAllSchools() {
		schoolRepository.deleteAll();
		System.out.println("All Schools Deleted");
	}

	
	
	
	
	
}
