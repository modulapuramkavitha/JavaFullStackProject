import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { SchoolServiceService } from '../school-service.service';
import { School } from '../school';
@Component({
  selector: 'app-schoollist',
  templateUrl: './schoollist.component.html',
  styleUrls: ['./schoollist.component.css']
})
export class SchoollistComponent {

  schools: School[] = [];
  count: number = 4;
  p: number = 1;

  constructor(
    private schoolService: SchoolServiceService, // Replace with your service
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllSchoolDetails();
  }

  viewSchool(id: number) {
    this.router.navigate(['view-school-details', id]);
  }

  deleteSchool(id : number){
    var status = confirm("Are you sure to delete this record?");
    if (status == true) {
    this.schoolService.deleteSchool(id).subscribe( data => {
      this.getAllSchoolDetails();
    })
  }
    else{
      this.getAllSchoolDetails();
    }
  
  }

  updateSchool(id: number) {
    this.router.navigate(['update-school', id]);
  }

  removeAllSchools() {
    var status = confirm('Are you sure to delete all the records?');
    if (status == true) {
      this.schoolService.deleteAll().subscribe(
        (details: any) => {
          console.log(details); // Handle the response as needed
          this.getAllSchoolDetails();
        },
        (error: any) => {
          console.log(error); // Handle errors as needed
        }
      );
    } else {
      this.getAllSchoolDetails();
    }
  }

  private getAllSchoolDetails(): void {
    this.schoolService.getSchoolList().subscribe((data: School[]) => {
      this.schools = data;
      console.log(data);
    });
  }
}
