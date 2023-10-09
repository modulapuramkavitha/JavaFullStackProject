
import { Component, OnInit  } from '@angular/core';
import { Router } from '@angular/router';

import { StudentServiceService } from '../student-service.service';
import { Student } from '../Student';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit{

  students: Student[] = [];
  firstName : String = "";
  constructor(private studentService: StudentServiceService,
    private router: Router) { }


    viewStudent(id : number){   //4

      this.router.navigate(['view-student-details', id]);  //'view-student-details, 4
     
    }

    deleteStudent(id : number){
      var status = confirm("Are you sure to delete this record?");
      if (status == true) {
      this.studentService.deleteStudent(id).subscribe( data => {
        this.getAllStudentDetails();
      })
    }
      else{
        this.getAllStudentDetails();
      }
    
    }

    updateStudent(id : number){
      this.router.navigate(['update-student', id]);
    }
  ngOnInit(): void {
    this.getAllStudentDetails();
  }
  removeAllStudents(){
    var status = confirm("Are you sure to delete all the records?");
    if (status == true) {
      this.studentService.deleteAll().subscribe(details => {
        console.log(details);  //null
        this.getAllStudentDetails();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getAllStudentDetails();
  }
  }

  getSecondaryStudents(){
    this.studentService.findBySecondary().subscribe({
      next: (res) => {
      console.log(res);
      this.students = res;
    },
    error: (e) => console.error(e)
  });
  }
getNonSecondaryStudents(){
  this.studentService.findByNotSecondary().subscribe({
    next: (res) => {
    console.log(res);
    this.students = res;
  },
  error: (e) => console.error(e)
  });
  }
 
  

  private getAllStudentDetails() : any{
    this.studentService.getStudentList().subscribe(data => {
      this.students = data;
      console.log(data);
    });
  }
}
