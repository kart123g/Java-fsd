import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Emp } from './emp';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  constructor(public http:HttpClient) { }

  loadEmpData():Observable<Emp[]>{
    return this.http.get<Emp[]>("http://localhost:3000/employees");
  }

  // in post method 1st parameter url and 2nd parameter data in json format. 
  storeEmpData(emp:any):Observable<Emp>{
    return this.http.post<Emp>("http://localhost:3000/employees",emp);
  }

  // it is consider as path param 
  findEmpById(id:any):Observable<Emp>{
    return this.http.get<Emp>("http://localhost:3000/employees/"+id);
  }

  delete(id:any):Observable<any>{
    return this.http.delete<any>("http://localhost:3000/employees/"+id);
  }

   // in post method 1st parameter url and 2nd parameter data in json format. 
   updateEmpData(id:any,emp:any):Observable<Emp>{
    return this.http.put<Emp>("http://localhost:3000/employees/"+id,emp);
  }


}
