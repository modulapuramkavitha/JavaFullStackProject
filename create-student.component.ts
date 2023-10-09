import { Component, OnInit } from '@angular/core';
import { Student } from '../Student';
import { StudentServiceService } from '../student-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent {

  constructor(private studentService: StudentServiceService,
    private router: Router) { }

    student : Student = new Student();
    
    saveStudent(){
      this.studentService.createStudent(this.student).subscribe( data =>{
        console.log(data);
        this.goToStudentList();
      },
      error => console.log(error));
    }
  
    goToStudentList(){
      this.router.navigate(['/see-all-students']);
    }
    
    onSubmit(){
      console.log(this.student);
      this.saveStudent();
    }



}
