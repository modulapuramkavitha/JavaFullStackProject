import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateStudentComponent } from './create-student/create-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ViewStudentComponent } from './view-student/view-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { AuthGuardService } from './auth-guard.service';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { SchoollistComponent } from './schoollist/schoollist.component';
import { CreateschoolComponent } from './createschool/createschool.component';
import { UpdateschoolComponent } from './updateschool/updateschool.component';
import { ViewschoolComponent } from './viewschool/viewschool.component';

const routes: Routes = [
  {path: 'see-all-students', component: StudentListComponent,canActivate:[AuthGuardService]},
  {path: 'sign-in',component:SigninComponent},
  {path: 'sign-up',component:SignupComponent},
  {path:'view-student-details/:id',component:ViewStudentComponent},
  {path:'update-student/:id',component:UpdateStudentComponent},
  {path:'create-student',component:CreateStudentComponent},
  {path:'see-all-schools', component: SchoollistComponent, canActivate:[AuthGuardService]},
  {path: 'create-school', component: CreateschoolComponent,canActivate:[AuthGuardService]},
  {path: 'update-school/:id', component: UpdateschoolComponent,canActivate:[AuthGuardService]},
  {path: 'view-school-details/:id', component: ViewschoolComponent,canActivate:[AuthGuardService]}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
