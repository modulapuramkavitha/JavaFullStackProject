import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Student } from './Student';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {


  private baseURL = "http://localhost:8080/studentmanagementsystem.com";

  constructor(private httpClient: HttpClient) { }
  
 
  getStudentById(id : number) : Observable<Student> {
    return this.httpClient.get<Student>(`${this.baseURL}/readStudent/${id}`);

  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteAllStudents`);
  }

  getStudentList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}/readAllStudents`);
  }

  deleteStudent(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteStudent/${id}`);

  }

  findBySecondary(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(`${this.baseURL}/isSecondary`);
  }

  findByNotSecondary(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(`${this.baseURL}/isNotSecondary`);
  }
  
  createStudent(obj : Student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveStudent`, obj);
  }
  updateStudent(id : number, studentObj : Student) : Observable<Student> {
    return this.httpClient.put<Student>(`${this.baseURL}/updateStudents/${id}`, studentObj);
  }
 
  signin(email:any, password:any):Observable<any>
  {
  
    const params=new HttpParams().set('email',email).set('password',password);
    console.log(params);
    return this.httpClient.get(`${this.baseURL}/login`,{params});
  
  }

}
