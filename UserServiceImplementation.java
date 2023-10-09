package SpringProject.StudentManagementSystemUsingSpring.StudentServiceImplementation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringProject.StudentManagementSystemUsingSpring.Model.User;
import SpringProject.StudentManagementSystemUsingSpring.Repository.UserRepository;

@Service
public class UserServiceImplementation {
@Autowired
private UserRepository userRepository;

 public void addUser(User user) {
	 this.userRepository.save(user);
 }
 public Optional<User> getUserByEmail(String email){
	 return this.userRepository.findByuserEmail(email);
 }
}

