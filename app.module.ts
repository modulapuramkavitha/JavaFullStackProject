import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ViewStudentComponent } from './view-student/view-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { SchoollistComponent } from './schoollist/schoollist.component';
import { CreateschoolComponent } from './createschool/createschool.component';
import { ViewschoolComponent } from './viewschool/viewschool.component';
import { UpdateschoolComponent } from './updateschool/updateschool.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    ViewStudentComponent,
    StudentListComponent,
    SigninComponent,
    SignupComponent,
    SchoollistComponent,
    CreateschoolComponent,
    ViewschoolComponent,
    UpdateschoolComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
