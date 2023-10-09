import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from '../student-service.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Student } from '../Student';



@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent implements OnInit{

  id: number = 0;
  particularStudent: Student = new Student();
  constructor(private route: ActivatedRoute,private router:Router, private studentService: StudentServiceService) { }

  ngOnInit(): void {
    //'view-flight-details/:4
    this.id = this.route.snapshot.params['id'];  //1

  
    this.studentService.getStudentById(this.id).subscribe( data => {
      this.particularStudent = data;
      console.log( this.particularStudent);
    });
  }

}