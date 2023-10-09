import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { School } from '../school';
import { SchoolServiceService } from '../school-service.service';

@Component({
  selector: 'app-updateschool',
  templateUrl: './updateschool.component.html',
  styleUrls: ['./updateschool.component.css']
})
export class UpdateschoolComponent {

  id: number = 0;
  school: School= new School();
  constructor(private schoolService: SchoolServiceService,
    private route: ActivatedRoute,
    private router: Router){}
    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];  
      
    this.schoolService.getSchoolById(this.id).subscribe(data => {
      this.school = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.schoolService.updateSchool(this.id, this.school).subscribe( data =>{
      this.getAllSchoolDetails();
    }
    , error => console.log(error));
  }
  getAllSchoolDetails(){
    this.router.navigate(['/see-all-schools']);
  }
  back(){
    this.router.navigate(['see-all-schools'])
  }
}
