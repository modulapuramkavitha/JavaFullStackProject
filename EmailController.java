package SpringProject.StudentManagementSystemUsingSpring.StudentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringProject.StudentManagementSystemUsingSpring.StudentServiceImplementation.EmailService;
@Controller
@RequestMapping("/email")
@CrossOrigin
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/getEmail")
	public ResponseEntity<String> checkEmail()
	{
	emailService.sendEmail("modulapuramkavitha996@gmail.com", "Check", "Checking Email");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	}
}
