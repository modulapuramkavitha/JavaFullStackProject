import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Student Management System';
  constructor(public userService:UserService,
    private router:Router){

  }
  logOut(){
    var status = confirm("Are you sure to log out?");
    if (status == true) {
      sessionStorage.removeItem('loginStatus')
      sessionStorage.removeItem('email')
      sessionStorage.removeItem('userId')
      sessionStorage.removeItem('userRole')
      sessionStorage.removeItem('userName')
      this.router.navigate(['sign-in'])
    }
    else{
      this.router.navigate(['see-all-students']);
    }
  }
}
