
import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from '../student-service.service';
import { Student } from '../Student';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit{

  id: number = 0;
  student: Student = new Student();
  constructor(private studentService:StudentServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];  //1

    this.studentService.getStudentById(this.id).subscribe(data => {
      this.student = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.studentService.updateStudent(this.id, this.student).subscribe( data =>{
      this.getAllStudentDetails();
    }
    , error => console.log(error));
  }

  getAllStudentDetails(){
    this.router.navigate(['/see-all-students']);
  }
  back(){
    this.router.navigate(['see-all-students'])
  }
}

