package SpringProject.StudentManagementSystemUsingSpring.StudentController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringProject.StudentManagementSystemUsingSpring.Model.Student;
import SpringProject.StudentManagementSystemUsingSpring.StudentServiceImplementation.StudentServiceImplementation;
@CrossOrigin
@RestController
@RequestMapping("/studentmanagementsystem.com")
/*this CONTROLLER class handles all the requests i.e. it receives requests and responds back to that
 the control of controller moves to the service class i.e studentServiceImplementation ,
 @Controller to the @Service class*/
public class StudentController {	


	@Autowired
	public StudentServiceImplementation studentService;
	public StudentController(StudentServiceImplementation studentService) {
		this.studentService = studentService;
	}

	//POST Api-to insert record into the database
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		try {
			return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//PUT Api-to update record in the table by specific id/rollNum in DB
	@PutMapping("/updateStudents/{rollNum}")
	public ResponseEntity<Student> updateStuDetailsById(@PathVariable("rollNum") int rollNum, @RequestBody Student student){
		try {
			return new ResponseEntity<Student>(studentService.updateStudentDetails(student, rollNum), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//GET Api-to retrieve all records from the table in database
	@GetMapping("/readAllStudents")
	public ResponseEntity<List<Student>> getAllStudentFromDb(@RequestParam(required = false) String studentName) {

		try {
			List<Student> students = new ArrayList<Student>();

			if (studentName == null)
				studentService.getAllStudentFromDb().forEach(students::add);
			else
				studentService.fetchFilteredStudents(studentName).forEach(students::add);

			if (students.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(students, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	//GET Api-to retrieve all records from the table in database
		@GetMapping("/readAllStudentsBySchoolName")
		public ResponseEntity<List<Student>> getAllStudentBySchoolName(@RequestParam(required = true) String schoolName) {

			try {
				List<Student> students = studentService.getAllStudentsBySchoolName(schoolName);
				if (students.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(students, HttpStatus.OK);
			} 
			catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}		
		}
	
	
	
	
	//GET Api-to retrieve a particular record from the table in the DB
	@GetMapping("/readStudent/{rollNum}")
	public ResponseEntity<Student>  getStudentById(@PathVariable("rollNum")  int rollNum){
		try {
			return new ResponseEntity<Student>(studentService.getStudentById(rollNum), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//DELETE Api - to delete a record from the table in DB
	@DeleteMapping("/deleteStudent/{rollNum}")
	public void deleteStudentById(@PathVariable("rollNum")  int rollNum){
		try {
			studentService.deleteStudentById(rollNum);
		}
		catch(Exception exe) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//DELETE Api - to delete all records from table in DB
	@DeleteMapping("/deleteAllStudents")
	public void deleteAllTheStudents() {
		try {
			studentService.deleteAllStudents();
		}
		catch(Exception exe) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//retrieving wheather a student is secondary student
	//@GetMapping("/Student/SecondaryStudent")
	
	@GetMapping("/isSecondary")
	public ResponseEntity<List<Student>>getSecondaryStudents(){
		try {
			return new ResponseEntity<List<Student>>(studentService.checkIfStudentIsSecondary(true),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	public ResponseEntity<List<Student>> findBySecondaryStudent(){
//		try {
//			//call serv method
//			return new ResponseEntity(studentService.findByIsSecondaryStudent(true),HttpStatus.OK);
//		}
//		catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	//retrieving wheather a student is not secondary student
	//@GetMapping("/Student/NotSecondaryStudent")
	
	@GetMapping("/isNotSecondary")
	public ResponseEntity<List<Student>> getNotSecondaryStudents(){
		try {
			return new ResponseEntity<List<Student>>(studentService.checkIfStudentIsNotSecondary(false),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	public ResponseEntity<List<Student>> findByNotSecondaryStudent(){
//		try {
//			return new ResponseEntity(studentService.findByIsSecondaryStudent(false),HttpStatus.OK);
//
//		}
//		catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	

		
     //sorting
	//search by location



}
