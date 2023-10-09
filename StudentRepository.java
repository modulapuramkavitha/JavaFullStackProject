package SpringProject.StudentManagementSystemUsingSpring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringProject.StudentManagementSystemUsingSpring.Model.Student;

/*this interface connects to the database as StudentRepository extending JpaRepository...
JpaRepository will use hibernate and providing flexibility to perform [POST,GET,DELETE,UPDATE]*/

@Repository //this annotation is used to connect with the database
public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByIsSecondaryStudent(Boolean booleanObj);

	Iterable<Student> findByStudentNameContainingIgnoreCase(String studentName);

	List<Student> findBySchoolNameContainingIgnoreCase(String schoolName);

}





//List<Student> findByStudent_nameOrRollNum(String student_name, int rollNum);
//List<Student> findByAddressOrderByStudent_name(String address);
//List<Student> findByRollNumAndMobileNumber(int rollNum, Long mobileNumber);