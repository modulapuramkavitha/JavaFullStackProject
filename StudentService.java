package SpringProject.StudentManagementSystemUsingSpring.Service;

//import org.hibernate.mapping.List;
import java.util.*;

import SpringProject.StudentManagementSystemUsingSpring.Model.Student;

//this service interface has the abstract methods which are going to be handled by the StudentServiceImplementation
public interface StudentService {
	Student saveStudent(Student student);

	Student getStudentById(int rollNum);

	Iterable<Student> fetchFilteredStudents(String studentName);

	Student updateStudentDetails(Student updatedValue, int rollNum);

	void deleteStudentById(int rollNum);

	void deleteAllStudents();

	List<Student> getAllStudentFromDb();
    List<Student>getAllStudentsBySchoolName(String schoolName);

}








//List<Student> fetchAllRollNumbersAndMobileNumbers(int rollNum,Long mobileNumber);
//List<Student> findByStudentNameOrRollNum(String student_name,int rollNum);
//List<Student> findByAddressOrderByStudentName(String address);