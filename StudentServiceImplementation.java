package SpringProject.StudentManagementSystemUsingSpring.StudentServiceImplementation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SpringProject.StudentManagementSystemUsingSpring.Model.Student;
import SpringProject.StudentManagementSystemUsingSpring.Repository.StudentRepository;
import SpringProject.StudentManagementSystemUsingSpring.Service.StudentService;

/*this class level annotation @Service provides all the services required for the controller
  It's control will move to the student repository to insert/update/get/delete records        */
@Service
public class StudentServiceImplementation implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	private EmailService emailService;

	//constructor method
	public StudentServiceImplementation(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	//method going to DB to save the details of student
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);  //
	}

	//this method is going to DB to retrieve a particular student by Id
	@Override
	public Student getStudentById(int rollNum) { //23
		Optional<Student> student = studentRepository.findById(rollNum);  //null , or it can 5tg person rec
		if(student.isPresent()) {
			return student.get();
		}
		else {
			return null;
		}
	}

	//this method is going to update the details in the database
	@Override
	public Student updateStudentDetails(Student updatedValue, int rollNum) {

		Optional<Student> student = studentRepository.findById(rollNum);
		if(student.isPresent()) {
			Student existingStudent = student.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingStudent.setStudentName(updatedValue.getStudentName());
			existingStudent.setRollNum(updatedValue.getRollNum());
	
			existingStudent.setAddress(updatedValue.getAddress());
			existingStudent.setGender(updatedValue.getGender());
			existingStudent.setIsSecondaryStudent(updatedValue.getIsSecondaryStudent());
			existingStudent.setStudentQualification(updatedValue.getStudentQualification());
			existingStudent.setSchoolName(updatedValue.getSchoolName());
			existingStudent.setStudentMarks(updatedValue.getStudentMarks());
			studentRepository.save(existingStudent);
			emailService.sendEmail("modulapuramkavitha996@gmail.com", "Student Management System", "Given details are updated");
			return existingStudent;
		}
		else {
			return null;
		}
	}

	//method is going to DB to fetch students by the student name
	@Override
	public Iterable<Student> fetchFilteredStudents(String studentName) {
		Iterable<Student> student=studentRepository.findByStudentNameContainingIgnoreCase(studentName);
		return student;
	}

	//method is going to database to to retrieve all the records from the table 
	@Override
	public List<Student> getAllStudentFromDb( ) {
		return studentRepository.findAll();
	}

	//method is going to database to delete all values from the table
	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();		
	}

	//method going to DB TO delete a particular student by Id/rollNum
	@Override
	public void deleteStudentById(int rollNum) {
		Optional<Student>studentObj = studentRepository.findById(rollNum);
		if(studentObj.isPresent()) {
			studentRepository.deleteById(rollNum);
		}
	}

	//method is going to database to check wheather student is Secondary student
//	public List<Student>findByIsSecondaryStudent(Boolean booleanObj)throws Exception {
//
//		List<Student> studentObj = studentRepository.findByIsSecondaryStudent(true);
//		return  studentObj;			
//	}
	public List<Student> checkIfStudentIsSecondary (Boolean booleanobj){
		List<Student> student=studentRepository.findByIsSecondaryStudent(true);
		return student;
		
	}
	

	//method is going to database to check wheather student is not Secondary student
//	public List<Student>findByIsNotSecondaryStudent(Boolean booleanObj)throws Exception {
//
//		List<Student> studentObj = studentRepository.findByIsSecondaryStudent(false);
//		return  studentObj;			
//	}
	public List<Student> checkIfStudentIsNotSecondary (Boolean booleanobj){
		List<Student> student=studentRepository.findByIsSecondaryStudent(false);
		return student;
		
	}

	public List<Student> getAllStudentsBySchoolName(String schoolName) {
		 
		List<Student> studentsList = new ArrayList<>();
				studentRepository.findBySchoolNameContainingIgnoreCase(schoolName).forEach(studentsList::add);
		return studentsList;
	}
	
	
	
	

//	private Sort.Direction getSortDirection(String direction) {
//	    if (direction.equals("asc")) {
//	      return Sort.Direction.ASC;
//	    } else if (direction.equals("desc")) {
//	      return Sort.Direction.DESC;
//	    }
//
//	    return Sort.Direction.ASC;
//	  }

}







//public List<Student> fetchAllRollNumbersAndMobileNumbers(int rollNum,Long mobileNumber) {
//return studentRepository.findByRollNumAndMobileNumber(rollNum,mobileNumber);
//
//}
//
//public List<Student> findByStudentNameOrRollNum(String student_name,int rollNum) {
//
//return studentRepository.findByStudent_nameOrRollNum(student_name, rollNum);
//}
//
//public List<Student>findByAddressOrderByStudentName(String address){
//return  studentRepository.findByAddressOrderByStudent_name(address);
//}