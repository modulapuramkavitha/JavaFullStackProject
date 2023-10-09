import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SchoolServiceService } from '../school-service.service';

@Component({
  selector: 'app-viewschool',
  templateUrl: './viewschool.component.html',
  styleUrls: ['./viewschool.component.css']
})
export class ViewschoolComponent implements OnInit{
  id:number;
  particularSchool: any;

  constructor(private route:ActivatedRoute,private router :Router,private schoolService:SchoolServiceService){ }
  ngOnInit(): void {
    //'view-school-details/:4
    this.id = this.route.snapshot.params['id'];  //1
    this.schoolService.getSchoolById(this.id).subscribe( data => {
     this.particularSchool = data;
      console.log( this.particularSchool);
    });
  }
  back(){
    this.router.navigate(['see-all-schools'])
  }
  
    }